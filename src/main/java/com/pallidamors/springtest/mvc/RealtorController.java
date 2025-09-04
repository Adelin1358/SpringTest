package com.pallidamors.springtest.mvc;

import com.pallidamors.springtest.mvc.domain.Realtor;
import com.pallidamors.springtest.mvc.service.RealtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RealtorController {

    @Autowired
    private RealtorService realtorService;
    //

    @PostMapping("/mvc/realtor/add")
    public String addRealtor(@RequestParam("office") String office
            , @RequestParam("phoneNumber") String phoneNumber
            , @RequestParam("address") String address
            , @RequestParam("grade") String grade
            , Model model){
        //추가하는 기능 -> 서비스 영역
        //realtorService.createRealtor(office, phoneNumber, address, grade);

        Realtor realtor = new Realtor();
        realtor.setOffice(office);
        realtor.setPhoneNumber(phoneNumber);
        realtor.setAddress(address);
        realtor.setGrade(grade);
        //객체로 저장
        int count =  realtorService.createRealtorByObject(realtor);
        model.addAttribute("realtor",realtor);

        return "mvc/realtorAddInfo";
    }

    @GetMapping("/mvc/realtor/addForm")
    public String realtorAddForm(){
        return "mvc/realtorAddForm";
    }

}
