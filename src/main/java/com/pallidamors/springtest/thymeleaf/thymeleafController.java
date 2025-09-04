package com.pallidamors.springtest.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class thymeleafController {

    @GetMapping("/thymeleaf/test01")
    public String test01(){
        return "thymeleaf/test01";
    }
}
