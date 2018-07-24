package com.svlugovoy.spring5mvcrest.api.v1.mapper;

import com.svlugovoy.spring5mvcrest.api.v1model.CategoryDTO;
import com.svlugovoy.spring5mvcrest.domain.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO categoryToCategoryDTO(Category category);
}
