package com.akk.o2o.dao;

import com.akk.o2o.BaseTest;
import com.akk.o2o.entity.Area;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

import static org.junit.Assert.assertEquals;


public class AreaDaoTest extends BaseTest {
	@Autowired
	private AreaDao areaDao;

	@Test
	public void testBQueryArea() throws Exception {
		List<Area> areaList = areaDao.queryArea();
		assertEquals(4, areaList.size());
	}


}