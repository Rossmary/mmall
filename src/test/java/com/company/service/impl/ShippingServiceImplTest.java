package com.company.service.impl;

import com.company.common.ServerResponse;
import com.company.dao.pojo.Shipping;
import com.company.service.iservice.ShippingService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/11/28 0028.
 */
public class ShippingServiceImplTest {
    ApplicationContext ctx;
    ShippingService shippingService;
    @Before
    public void setUp() throws Exception {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        shippingService = ctx.getBean(ShippingService.class);
        System.out.println("Tear up .......");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Tear down............");
    }


    @Test
    public void testAdd() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }

    @Test
    public void testUpdate() throws Exception {
        Shipping shipping=shippingService.select(3).getData();
        System.out.println(shipping);
        shipping.setReceiverAddress("软件园1");
        int s=shippingService.update(shipping);
        System.out.println(s);
    }

    @Test
    public void testSelect() throws Exception {
        Shipping shipping=shippingService.select(3).getData();
        System.out.println(shipping);
    }

    @Test
    public void testFindAll() throws Exception {

    }
}