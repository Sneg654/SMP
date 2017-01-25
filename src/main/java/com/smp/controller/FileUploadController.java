package com.smp.controller;

import com.smp.impexsel.ImportFromExsell;
import com.smp.model.Organization;
import com.smp.model.StateStore;
import com.smp.model.UserToOrg;
import com.smp.service.MailService;
import com.smp.service.OrgService;
import com.smp.service.StateStoreService;
import com.smp.service.UserToOrgService;
import org.apache.xmlbeans.impl.piccolo.io.FileFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergey_Stefoglo on 1/16/2017.
 */
@Controller
@RequestMapping()
public class FileUploadController {
    ImportFromExsell importFromExsell;

    @Autowired
    private UserToOrgService userToOrgService;

    @Autowired
    private OrgService orgService;

    @Autowired
    private StateStoreService stateStoreService;
    @Autowired
    private MailService mailService;

    public File convert(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public
    @ResponseBody
    ModelAndView uploadFileHandler(@RequestParam("file") MultipartFile file,
                                   @RequestParam("choseOrgId") Long orgId,
                                   ModelMap model) {

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
//                Long orgId = 1L;

                try (FileInputStream fileInputStream = new FileInputStream(convert(file))) {


                    importFromExsell = new ImportFromExsell(fileInputStream, orgId);
                    // Creating the directory to store file
                    List<StateStore> stateStores = new ArrayList<>();
                    fileFormat(file.getOriginalFilename(), stateStores);
                    for (StateStore stateStore : stateStores) {

                        List<StateStore> stores = stateStoreService.findById(stateStore);
                        if (stores != null && stores.size() != 0) {
                            StateStore store = stores.get(0);
                            if (store.getCheck() && store.getMin() > stateStore.getCount()) {
                                store.setCount(stateStore.getCount());
                                store.setCost(stateStore.getCost());
                                store.setSend(false);
                                stateStoreService.autoUpdate(stateStore);
                            }
                        } else {
                            stateStoreService.insertStore(stateStore);

                        }

                    }
                }
                //
                List<StateStore> stateStoreList = stateStoreService.findForSending(orgId);
                mailService.messageBodyFrom(stateStoreList);
                mailService.sendEmail();
                for (StateStore state : stateStoreList) {
                    stateStoreService.sendUpdate(state);
                }
                //
                model.addAttribute("message", "Файл успешно загрузжен");
                return list(model);
            } catch (Exception e) {
                model.addAttribute("message", "Ошибка чтения ");
                return list(model);
            }
        } else {
            model.addAttribute("message", "Ошибка чтения ");
            return list(model);
        }
    }


    @RequestMapping("/upl")
    public ModelAndView list(ModelMap model) {

        List<UserToOrg> userToOrgs = userToOrgService.findByUserId(1L);
        List<Organization> organizations = new ArrayList<>();
        for (UserToOrg userToOrg : userToOrgs) {
            organizations.add(orgService.findById(userToOrg.getOrgId()));
        }

        model.put("orgs", organizations);
        return new ModelAndView("upload", model);
    }

    private void fileFormat(String filename, List<StateStore> stateStores) throws IOException {
        String obj = filename.substring(filename.indexOf(".") + 1);
        if (obj.equalsIgnoreCase("xls")) {
            importFromExsell.importFromXLS(stateStores);
        } else if (obj.equalsIgnoreCase("xlsx")) {
            importFromExsell.importFromXLSX(stateStores);
        } else {
            throw new FileFormatException();
        }

    }


}