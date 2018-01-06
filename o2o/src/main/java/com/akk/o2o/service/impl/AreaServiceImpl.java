package com.akk.o2o.service.impl;

import com.akk.o2o.dao.AreaDao;
import com.akk.o2o.entity.Area;
import com.akk.o2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @author: Created by Akk_Mac
 * @Date: 2017/12/22 14:29
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }
}
