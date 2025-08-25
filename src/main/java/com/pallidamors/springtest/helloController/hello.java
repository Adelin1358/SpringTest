package com.pallidamors.springtest.helloController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class hello {

    @ResponseBody
    @RequestMapping("/test/hello")
    public String helloworld() {
        return "Hello World!";
    }
}
