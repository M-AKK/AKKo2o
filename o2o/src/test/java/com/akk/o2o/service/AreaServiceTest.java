package com.akk.o2o.service;

import com.akk.o2o.BaseTest;
import com.akk.o2o.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class AreaServiceTest extends BaseTest {

    @Autowired
    private AreaService areaService;

    @Test
    public void getAreaList() throws Exception {
        List<Area> areaList = areaService.getAreaList();
        assertNotNull(areaList);
    }

}