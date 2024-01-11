package com.example.demo.web.mapper;

import com.example.demo.model.Data;
import com.example.demo.model.test.DataTestOptions;
import com.example.demo.web.dto.DataDTO;
import com.example.demo.web.dto.DataTestOptionsDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataTestOptionsMapper extends Mappable<DataTestOptions, DataTestOptionsDto>{

}
