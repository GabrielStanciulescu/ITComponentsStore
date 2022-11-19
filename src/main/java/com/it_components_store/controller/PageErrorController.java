package com.it_components_store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class PageErrorController {

    @RequestMapping("/403")
    public String forbiddenPage(){
        return "forbiddenPage";
    }
}
