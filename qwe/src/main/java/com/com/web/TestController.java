package com.com.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.com.comm.PageBean;
import com.com.comm.ResultUtils;
import com.com.db1.model.GkGj;
import com.com.service.TestService;
import com.github.pagehelper.PageHelper;

@RestController
@RequestMapping("/")
public class TestController {
	
	
	

	@Autowired
	TestService testService;
	
	@RequestMapping("/")
	public String test(){
		// TODO Auto-generated method stub
		testService.testSelect();
		return "1";
	}
	
	@RequestMapping(value = "selectByAll_db1",produces = "application/json;charset=utf-8")
	public String selectByAll(){
		PageHelper.startPage(1,0);
		List<GkGj> gt = testService.testSelectAll(new GkGj());
		return ResultUtils.ResultSuccess(new PageBean<GkGj>(gt));
	}
	

}
