package com.pallidamors.springtest.database;

import com.pallidamors.springtest.database.domain.Store;
import com.pallidamors.springtest.database.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StoreController {

    //15. 조회 정보 얻을 멤버 변수 준비
    @Autowired
    private StoreService storeService;

    //1.store 모든 정보를 reaponse 에 담는다
    @RequestMapping("/db/store/list")
    @ResponseBody
    public List<Store> storeList(){

        //2.store 정보 얻어오기(서비스에서 작성되야 됨)
        //14. 서비스 작성 완료
        List<Store> storelist = storeService.getStoreList();
        return storelist;
    }

}
