package com.com.db2.mapper;

import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface SkTzMapperS {

    @SuppressWarnings("rawtypes")
	Map selectByPrimaryKey(String id);

}