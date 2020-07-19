package com.com.db1.mapper;

import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface SkTzMapperM {

	@SuppressWarnings("rawtypes")
	Map selectByPrimaryKey1(String id);
	
}