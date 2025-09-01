package com.pallidamors.springtest.database.repository;

import com.pallidamors.springtest.database.domain.Store;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//6.레파지토리 생성
@Mapper
public interface StoreRepository {

    //7. 테이블 모든 행 조회 -> Mapper.xml활용
    //11. 도메인 작성후  작성 가능
    public List<Store> selectStoreList();
}
