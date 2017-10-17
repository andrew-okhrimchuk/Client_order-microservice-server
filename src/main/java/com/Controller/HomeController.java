package com.Controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Home page controller.
 *
 * @author Paul Chapman
 */
@Controller
public class HomeController {

    @RequestMapping(value ="/", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public String home() {
        return "index";
    }

}