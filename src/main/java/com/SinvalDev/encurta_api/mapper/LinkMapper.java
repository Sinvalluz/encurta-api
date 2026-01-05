package com.SinvalDev.encurta_api.mapper;

import com.SinvalDev.encurta_api.dto.LinkDto;
import com.SinvalDev.encurta_api.model.Link;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LinkMapper {
    LinkMapper INSTANCE = Mappers.getMapper(LinkMapper.class);

    Link linkDtoToLinkEntity(LinkDto dto);

    LinkDto linkEntityToLinkDto(Link linkEntity);
}
