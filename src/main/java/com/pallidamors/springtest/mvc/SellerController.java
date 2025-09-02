package com.pallidamors.springtest.mvc;

import com.pallidamors.springtest.mvc.domain.Seller;
import com.pallidamors.springtest.mvc.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @ResponseBody
    @PostMapping("/mvc/seller/add")
    public String addSeller(
            @RequestParam("nickname") String nickname
            ,@RequestParam("temperature") double temperature
            ,@RequestParam("profileImage") String profileImage){

        //seller 정보 추가하는 기능 -> service
        int count = sellerService.createSeller(nickname,temperature,profileImage);
        return "실행 결과" + count;

    }

    @GetMapping("/mvc/seller/form")
    public String sellerForm(){
        return "mvc/sellerForm";
    }

    @GetMapping("/mvc/seller/info")
    public String sellerInfo(Model model){
        //가장 최근 등록된 판매자 정보
        Seller seller = sellerService.getLastSeller();
        model.addAttribute("result",seller);
        return "mvc/sellerInfo";
    }
}
