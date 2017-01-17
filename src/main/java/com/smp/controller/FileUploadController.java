package com.smp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Sergey_Stefoglo on 1/16/2017.
 */
@Controller
@RequestMapping
public class FileUploadController {

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String uploadForm() {
        return "upload";
    }


    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ModelAndView upload(@RequestParam("file") MultipartFile file,
                               ModelMap model) {
        if (!file.isEmpty()) {
//            uploadFacade.upload(file, type);

            model.put("result", String.format("File '%s' successfully uploaded.", file.getOriginalFilename()));
        }
        return new ModelAndView("upload", model);


    }

//    private <StateStore> void parseAndSave(MultipartFile file, Parser<StateStore> parser, AService<StateStore> service) {
//        List<StateStore> entities = parser.parse(file);
//    }
    }

