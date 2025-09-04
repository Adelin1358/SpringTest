package com.pallidamors.springtest.mvc.service;

import com.pallidamors.springtest.mvc.domain.Seller;
import com.pallidamors.springtest.mvc.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;
    //
    public int createSeller(
            String nickname
            ,double temperature
            ,String profileImage
    ){
        //데이터 베이스에 추가
        int count= sellerRepository.insertSeller(nickname,temperature,profileImage);
        return count;
    }


    //가장 최근에 등록한  정보 얻어오기
    public Seller getLastSeller(){
       Seller seller = sellerRepository.selectLastSeller();
       return seller;
    }

    public Seller getSellerById(int id){
        Seller seller = sellerRepository.selectSellerById(id);
        return seller;
    }
}
