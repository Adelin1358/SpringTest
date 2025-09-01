package com.pallidamors.springtest.mybatis;

import com.pallidamors.springtest.mybatis.domain.RealEstate;
import com.pallidamors.springtest.mybatis.service.RealEstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RealEstateController {

    @Autowired
    private RealEstateService realEstateService;

    @ResponseBody
    @RequestMapping("/mybatis/real-estate/select/1")
    public RealEstate realEstate(@RequestParam("id") int id){

        // 전달 받은 id와 일치하는 매물 정보 얻어 오기
        RealEstate realEstate  = realEstateService.getRealEstate(id);

        return  realEstate;

    }
    @ResponseBody
    @RequestMapping("/mybatis/real-estate/select/2")
    public List<RealEstate> realEstateListByRentPrice(@RequestParam("rent") int rentPrice){

        //전달 받은 금액보다 낮은 매물 리스트 얻어 오기
        List<RealEstate> realEstateList =  realEstateService.getRealEstateListByRentPrice(rentPrice);
        return realEstateList;

    }

    @ResponseBody
    @RequestMapping("/mybatis/real-estate/select/3")
    public List<RealEstate> realEstateListByAreaAndPrice(
            @RequestParam("area")int area
            ,@RequestParam("price") int price){

        //면적과 가격에 대한 조건에 대응되는 매물 리스트 얻어오기
        List<RealEstate> realEstateList =  realEstateService.getRealEstateListByAreaAndPrice(area, price);
        return realEstateList;

    }
    @ResponseBody
    @RequestMapping("/mybatis/real-estate/insert/1")
    public String writeRealEstateByObject(){
        //3,푸르지용 리버 303동 1104호, 89, 매매, 100000
        RealEstate realEstate = new RealEstate();
        realEstate.setRealtorId(3);
        realEstate.setAddress("푸르지용 리버 303동 1104호");
        realEstate.setArea(89);
        realEstate.setType("매매");
        realEstate.setPrice(100000);

        int count = realEstateService.createRealEstateByObject(realEstate);
        return "입력 성공 :" + count;
    }

    //address : 썅떼빌리버 오피스텔 814호
    //area : 45
    //type : 월세
    //price : 100000
    //rentPrice : 120
    @ResponseBody
    @RequestMapping("/mybatis/real-estate/insert/2")
    public String writeRealEstateByParameter(@RequestParam("realtorId")  int realtorId){
        int count = realEstateService.createRealEstateByParameter( realtorId,"썅떼빌리버 오피스텔 814호",45,"월세",100000,120);
        return "입력 성공 :" + count;
    }

    @ResponseBody
    @RequestMapping("/mybatis/real-estate/edit")
    public String editRealEstateByTypeAndPrice(){
        //type전세  price 70000 id =22
        int count = realEstateService.updateRealEstateByTypeAndPrice(22,"전세",70000);
        return "입력 성공 :" + count;
    }
    @ResponseBody
    @RequestMapping("/mybatis/real-estate/remove")
    public String removeRealEstate(@RequestParam("id") int id){
        int count = realEstateService.deleteRealEstate(id);
        return "삭제 성공 :" + count;
    }

}
