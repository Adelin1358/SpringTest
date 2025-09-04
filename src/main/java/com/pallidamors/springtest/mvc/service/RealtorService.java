package com.pallidamors.springtest.mvc.service;

import com.pallidamors.springtest.mvc.domain.Realtor;
import com.pallidamors.springtest.mvc.repository.RealtorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RealtorService {

    @Autowired
    private RealtorRepository realtorRepository;

    public int createRealtor(String office , String phoneNumber, String address, String grade){
        //데이터 베이스 에 추가
        int count = realtorRepository.insertRealtor(office,phoneNumber,address,grade);
        return count;

    }

    public int createRealtorByObject(Realtor  realtor){
        int count = realtorRepository.insertRealtorByObject(realtor);
        return count;
    }
}
