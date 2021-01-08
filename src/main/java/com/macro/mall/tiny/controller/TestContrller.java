package com.macro.mall.tiny.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangyonglong
 * @version 1.0
 * @className TestContrller
 * @date 1/8/21 11:28 AM
 **/
@RestController
@RequestMapping("/test")
public class TestContrller {
	@RequestMapping("/index")
	public String index(){
		return "3323";
	}
}
