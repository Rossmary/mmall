package com.company.service.impl;

import com.company.common.ServerResponse;
import com.company.dao.pojo.Cart;
import com.company.dao.vo.CartProduct;
import com.company.dao.vo.CartProductVoList;
import com.company.service.iservice.CartService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/11/28 0028.
 */
public class CartServiceImplTest {
    ApplicationContext ctx;
    CartService cartService;
    @Before
    public void setUp() throws Exception {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        cartService = ctx.getBean(CartService.class);
        System.out.println("tear up........");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tear down..............");
    }

    @Test
    public void testFindAllProduct() throws Exception {
        ServerResponse<CartProductVoList> lists = cartService.findAllProduct(21);
        System.out.println(lists);
    }


    @Test
    public void testAddProduct() throws Exception {

    }

    @Test
    public void testUpdateNum() throws Exception {
        int cnt = cartService.updateNum(22,27,3);
        System.out.println(cnt);
    }

    @Test
    public void testDeleteProduct() throws Exception {
        int cnt = cartService.deleteProduct(22,27);
        System.out.println(cnt);
    }

    @Test
    public void testCheckOneProduct() throws Exception {
        int cnt = cartService.checkOneProduct(22,27);
        System.out.println(cnt);
    }

    @Test
    public void testUnCheckedProduct() throws Exception {
        int cnt = cartService.unCheckedProduct(22,27);
        System.out.println(cnt);
    }

    @Test
    public void testFindCount() throws Exception {
        int cnt = cartService.findCount(22);
        System.out.println(cnt);
    }

    @Test
    public void testAllCheck() throws Exception {
        int cnt = cartService.allCheck(22);
        System.out.println(cnt);
    }

    @Test
    public void testAllUnCheck() throws Exception {
        int cnt = cartService.allUnCheck(22);
        System.out.println(cnt);
    }
}