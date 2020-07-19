package com.com.db1.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.com.db1.model.GkGj;


@Repository
public interface GkGjMapper {
    int deleteByPrimaryKey(String id);

    int insert(GkGj record);

    int insertSelective(GkGj record);

    GkGj selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GkGj record);

    int updateByPrimaryKeyWithBLOBs(GkGj record);

    int updateByPrimaryKey(GkGj record);
    
    List<GkGj>  selectByAll(GkGj gkGj);
}