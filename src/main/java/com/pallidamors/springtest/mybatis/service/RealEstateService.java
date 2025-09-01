package com.pallidamors.springtest.mybatis.service;

import com.pallidamors.springtest.mybatis.domain.RealEstate;
import com.pallidamors.springtest.mybatis.repository.RealEstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealEstateService {

    @Autowired
    private RealEstateRepository realEstateRepository;

    // 전달 받은 id와 일치하는 매물 정보 얻어오기

    public RealEstate getRealEstate(int id){

        //real_estate 테이블에서 전달 받은 id와 일치하는 행 조회
        RealEstate realEstate = realEstateRepository.selectRealEstate(id);
        return realEstate;
    }

    //전달 받은 금액보다 낮은 매물 리스트 얻어 오기
    public List<RealEstate> getRealEstateListByRentPrice(int rentPrice){
        //real_estate 테이블에서 전달 받은 월세보다 낮은 행 조회
        List<RealEstate> realEstatesList = realEstateRepository.selectRealEstateListByRentPrice(rentPrice);
        return  realEstatesList;
    }

    public  List<RealEstate> getRealEstateListByAreaAndPrice(int area, int price){

        //real_estate 테이블에서 전달받은 면적과 가격에 대한 조건에 대응되는 행 조회
        List<RealEstate> realEstateList = realEstateRepository.selectRealEstateListByAreaAndPrice(area, price);
        return  realEstateList;

    }

    //객체로 insert 하기
    public int createRealEstateByObject(RealEstate realEstate){
        //테이블에 insert 추가하는 기능
        int count = realEstateRepository.insertRealEstateByObject(realEstate);
        return count;

    }

    //파라미터로 insert 진행
    //    //address : 썅떼빌리버 오피스텔 814호
    //    //area : 45
    //    //type : 월세
    //    //price : 100000
    //    //rentPrice : 120
    public int createRealEstateByParameter(
            int realtorId,
            String address
            ,int area
            ,String type
            ,int price
            ,int rentPrice
    ){
        // real_estate 테이블에 한행을 저장하는 기능
        int count = realEstateRepository.insertRealEstateByParameter(realtorId, address, area, type, price, rentPrice);
        return count;
    }

    //전달 박은 id에 대응되는 매물 정보중 type과 price가 전달 받은 값으로 수정
    public int updateRealEstateByTypeAndPrice(int id, String type,int price){
        int count = realEstateRepository.updateRealEstate(id, type, price);
        return count;
    }

    public int deleteRealEstate(int id){
        int count = realEstateRepository.deleteRealEstate(id);
        return count;
    }

}
