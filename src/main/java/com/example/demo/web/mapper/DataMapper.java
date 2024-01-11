package com.example.demo.web.mapper;

import com.example.demo.model.Data;
import com.example.demo.web.dto.DataDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataMapper extends Mappable<Data, DataDTO>{

}
