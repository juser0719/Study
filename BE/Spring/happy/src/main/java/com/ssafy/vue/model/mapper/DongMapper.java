package com.ssafy.vue.model.mapper;


import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vue.model.DongDto;

@Mapper
public interface DongMapper {


	void registerDong(DongDto dongDto) throws Exception;

	
}
