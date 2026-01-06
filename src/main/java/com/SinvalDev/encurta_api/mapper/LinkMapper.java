package com.SinvalDev.encurta_api.mapper;

import com.SinvalDev.encurta_api.dto.LinkDto;
import com.SinvalDev.encurta_api.dto.LinkResponseByShortCodeDto;
import com.SinvalDev.encurta_api.dto.LinkResponseDto;
import com.SinvalDev.encurta_api.model.Link;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LinkMapper {
    LinkMapper INSTANCE = Mappers.getMapper(LinkMapper.class);

    Link linkDtoToLinkEntity(LinkDto dto);

    LinkDto linkEntityToLinkDto(Link linkEntity);

    LinkDto linkResponseDtoToLinkDto(LinkResponseDto linkResponseDto);

    LinkResponseDto linkDtoToLinkResponseDto(LinkDto linkDto);

    LinkDto linkResponseByShortCodeDtoToLinkDto(LinkResponseByShortCodeDto linkResponseByShortCodeDto);

    LinkResponseByShortCodeDto linkDtoToLinkResponseByShortCodeDto(LinkDto linkDto);
}
