package com.it_components_store.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        String errorPage = "";

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value()) {

                errorPage = "errorPage/pageNotFound";

            } else if (statusCode == HttpStatus.FORBIDDEN.value()) {
                errorPage = "errorPage/forbiddenPage";

            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                errorPage = "errorPage/errorPage";

            }
            else if(statusCode == HttpStatus.BAD_REQUEST.value()){
                errorPage = "errorPage/badRequestPage";
            }
        }

        return errorPage;
    }

}
