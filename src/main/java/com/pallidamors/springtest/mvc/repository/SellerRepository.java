package com.pallidamors.springtest.mvc.repository;

import com.pallidamors.springtest.mvc.domain.Seller;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SellerRepository {


    public int insertSeller(
            @Param("nickname") String nickname
            , @Param("temperature") double temperature
            , @Param("profileImage") String profileImage);

    public Seller selectLastSeller();
}
