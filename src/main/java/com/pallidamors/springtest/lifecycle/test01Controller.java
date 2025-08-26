package com.pallidamors.springtest.lifecycle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class test01Controller {

    @RequestMapping("/lifecycle/test01/1")
    @ResponseBody
    public String htmlResponse(){
        return "<html>\n" +
                "   <head><title>String 응답하기</title></head>\n" +
                "   <body>\n" +
                "       <h2>테스트 프로젝트 완성</h2>\n" +
                "       <b>해당 프로젝트를 통해서 문제 풀이를 진행합니다.</b>\n" +
                "   </body>\n" +
                "</html>\n";
    }

    @RequestMapping("/lifecycle/test01/2")
    @ResponseBody
    public Map<String, Integer> mapResponse(){
        Map<String, Integer> scoreMap =  new HashMap<>();
        scoreMap.put("국어",80);
        scoreMap.put("수학",90);
        scoreMap.put("영어",85);

        return scoreMap;
    }
}
