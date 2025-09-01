package com.pallidamors.springtest.mybatis.repository;

import com.pallidamors.springtest.mybatis.domain.RealEstate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RealEstateRepository {

    //real_estate 에 전달 받은 id와 일치하는 행 조회
    public RealEstate selectRealEstate(@Param("id") int id);

    //real_estate 테이블에서 전달 받은 월세보다 낮은 행 조회
    public List<RealEstate> selectRealEstateListByRentPrice(@Param("rentPrice")int rentPrice);

    //real_estate 테이블에서 전달받은 면적과 가격에 대한 조건에 대응되는 행 조회
    public List<RealEstate> selectRealEstateListByAreaAndPrice(
            @Param("area") int area
            , @Param("price") int price);

    public int insertRealEstateByObject(RealEstate realEstate);

    public int insertRealEstateByParameter(
            @Param("realtorId") int realtorId
            ,@Param("address") String address
            ,@Param("area") int area
            ,@Param("type") String type
            ,@Param("price") int price
            ,@Param("rentPrice") int rentPrice
    );

    public int updateRealEstate(
            @Param("id")int id
            , @Param("type") String type
            , @Param("price") int price);

    public int deleteRealEstate(@Param("id") int id);
}
