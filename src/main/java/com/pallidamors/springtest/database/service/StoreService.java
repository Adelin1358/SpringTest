package com.pallidamors.springtest.database.service;

import com.pallidamors.springtest.database.domain.Store;
import com.pallidamors.springtest.database.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//3.부가적인 기능 수행
@Service
public class StoreService {

    //13. 받을 멤버변수 작성, 객체 만들기 싫으니까 @Autowired 작성
    @Autowired
    private StoreRepository storeRepository;

    //4.store 정보 얻어오기 기능 선언
    public List<Store> getStoreList(){

        //5. store 테이블의 모든 행 조회(서비스 기능 아님, 레파지토리)
        //12. 레파지토리 작성 완료
        List<Store> storeList = storeRepository.selectStoreList();
        return storeList;

    }
}
