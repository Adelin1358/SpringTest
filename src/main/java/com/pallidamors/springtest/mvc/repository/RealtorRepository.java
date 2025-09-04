package com.pallidamors.springtest.mvc.repository;

import com.pallidamors.springtest.mvc.domain.Realtor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RealtorRepository {

    public int insertRealtor(@Param("office") String office
            ,@Param("phoneNumber") String phoneNumber
            ,@Param("address") String address
            ,@Param("grade") String grade);

    public int insertRealtorByObject(Realtor realtor);
}
