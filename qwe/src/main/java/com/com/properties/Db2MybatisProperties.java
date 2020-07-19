package com.com.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.datasource.db2.extend")
public class Db2MybatisProperties {
	
	private String mybatisMapperLocations;
	private String pagehelperDialect;
	private String pagehelperReasonable;
	private String pagehelperSupportMethodsArguments;
	private String pagehelperParams;
	private String pagehelperOffsetAsPageNum;
	private String pagehelperRowBoundsWithCount;

	public String getMybatisMapperLocations() {
		return mybatisMapperLocations;
	}

	public void setMybatisMapperLocations(String mybatisMapperLocations) {
		this.mybatisMapperLocations = mybatisMapperLocations;
	}

	public String getPagehelperDialect() {
		return pagehelperDialect;
	}

	public void setPagehelperDialect(String pagehelperDialect) {
		this.pagehelperDialect = pagehelperDialect;
	}

	public String getPagehelperReasonable() {
		return pagehelperReasonable;
	}

	public void setPagehelperReasonable(String pagehelperReasonable) {
		this.pagehelperReasonable = pagehelperReasonable;
	}

	public String getPagehelperSupportMethodsArguments() {
		return pagehelperSupportMethodsArguments;
	}

	public void setPagehelperSupportMethodsArguments(String pagehelperSupportMethodsArguments) {
		this.pagehelperSupportMethodsArguments = pagehelperSupportMethodsArguments;
	}

	public String getPagehelperParams() {
		return pagehelperParams;
	}

	public void setPagehelperParams(String pagehelperParams) {
		this.pagehelperParams = pagehelperParams;
	}

	public String getPagehelperOffsetAsPageNum() {
		return pagehelperOffsetAsPageNum;
	}

	public void setPagehelperOffsetAsPageNum(String pagehelperOffsetAsPageNum) {
		this.pagehelperOffsetAsPageNum = pagehelperOffsetAsPageNum;
	}

	public String getPagehelperRowBoundsWithCount() {
		return pagehelperRowBoundsWithCount;
	}

	public void setPagehelperRowBoundsWithCount(String pagehelperRowBoundsWithCount) {
		this.pagehelperRowBoundsWithCount = pagehelperRowBoundsWithCount;
	}
	
	
}

