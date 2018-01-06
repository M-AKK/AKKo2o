package com.akk.o2o.web.superadmin;

import com.akk.o2o.entity.Area;
import com.akk.o2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @author: Created by Akk_Mac
 * @Date: 2017/12/22 18:03
 */
@RestController
@RequestMapping("/superadmin")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping(value = "/listarea")
    public Map<String, Object> listArea(){

        Map<String, Object> modelMap = new HashMap<>();
        List<Area> list = new ArrayList<>();
        try{
            list = areaService.getAreaList();
            modelMap.put("rows", list);
            modelMap.put("total", list.size());
        } catch(Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());

        }
        return modelMap;
    }

}
