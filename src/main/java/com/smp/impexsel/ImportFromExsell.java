package com.smp.impexsel;

import com.smp.model.StateStore;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by Sergey_Stefoglo on 1/17/2017.
 */
public class ImportFromExsell {
    private FileInputStream fileInputStream;
    private Long orgId;
    DataFormat format;
    private final int IND_NUM_ID=3;
    private final int IND_NAME=2;
    private final int IND_COUNT=21;
    private final int IND_COST=20;
    private final int COUNT_COLUMN=23;

    public ImportFromExsell(FileInputStream fileInputStream, Long orgId) {
        this.fileInputStream = fileInputStream;
        this.orgId = orgId;
    }

    public void importFromXLS(List<StateStore> list) throws IOException {


        HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
        HSSFSheet worksheet = workbook.getSheetAt(0);
        format = workbook.createDataFormat();
        for (int i = 6; i < worksheet.getLastRowNum(); i++) {
            HSSFRow row1 = worksheet.getRow(i);

            if (row1.getLastCellNum() == COUNT_COLUMN) {
                HSSFCell cellName = row1.getCell((short) IND_NAME);
                HSSFCell cellNumlacatureId = row1.getCell((short) IND_NUM_ID);
                HSSFCell cellCount = row1.getCell((short) IND_COUNT);
                HSSFCell cellCost = row1.getCell((short) IND_COST);
                StringBuffer numlacatureId = new StringBuffer();
                if (cellNumlacatureId.getCellType() == 1) {
                    numlacatureId.append(cellNumlacatureId.getStringCellValue());
                } else {
                    Double nu = cellNumlacatureId.getNumericCellValue();
                    String currentValue = String.valueOf(nu.intValue());
                    for (int j = 0; j < 11 - currentValue.length(); j++) {
                        numlacatureId.append("0");
                    }
                    numlacatureId.append(currentValue);
                }

                list.add(getStateStore(numlacatureId.toString(), cellName.getStringCellValue(), orgId, cellCost.getNumericCellValue(), cellCount.getNumericCellValue()));

                System.out.println(i);
            }
        }

    }

    public List<StateStore> importFromXLSX(List<StateStore> list) throws IOException {

        try {
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet worksheet = workbook.getSheetAt(0);
            for (int i = 6; i < worksheet.getLastRowNum(); i++) {
                XSSFRow row1 = worksheet.getRow(i);

                if (row1.getLastCellNum() == 23) {
                    XSSFCell cellName = row1.getCell((short) IND_NAME);
                    XSSFCell cellNumlacatureId = row1.getCell((short) IND_NUM_ID);
                    XSSFCell cellCount = row1.getCell((short) IND_COUNT);
                    XSSFCell cellCost = row1.getCell((short) IND_COST);
                    StringBuffer numlacatureId = new StringBuffer();
                    if (cellNumlacatureId.getCellType() == 1) {
                        numlacatureId.append(cellNumlacatureId.getStringCellValue());
                    } else {
                        Double nu = cellNumlacatureId.getNumericCellValue();
                        String currentValue = String.valueOf(nu.intValue());
                        for (int j = 0; j < 11 - currentValue.length(); j++) {
                            numlacatureId.append("0");
                        }
                        numlacatureId.append(currentValue);
                    }

                    list.add(getStateStore(numlacatureId.toString(), cellName.getStringCellValue(), orgId, cellCost.getNumericCellValue(), cellCount.getNumericCellValue()));

                    System.out.println(list.size() + ": " + list.get(list.size() - 1));
                }
            }


            return list;
        } catch (java.nio.channels.ClosedChannelException e) {
            return list;
        }
    }

    private StateStore getStateStore(String nomeclatureID, String name, Long orgId, Double cost, Double count) {
        StateStore stateStore = new StateStore();
        stateStore.setNomeclatureID(nomeclatureID);
        stateStore.setName(name);
        stateStore.setOrgId(orgId);
        stateStore.setCost(cost);
        stateStore.setCount(Math.ceil(count));
        System.out.println(stateStore);
        return stateStore;
    }
}
