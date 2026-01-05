package com.SinvalDev.encurta_api.controller;

import com.SinvalDev.encurta_api.dto.LinkDto;
import com.SinvalDev.encurta_api.dto.LinkRequestDto;
import com.SinvalDev.encurta_api.dto.LinkResponseDto;
import com.SinvalDev.encurta_api.mapper.LinkMapper;
import com.SinvalDev.encurta_api.service.LinkService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/link")
@AllArgsConstructor
public class LinkController {

    private final LinkService linkService;
    private final LinkMapper linkMapper;

    @PostMapping
    public ResponseEntity<LinkResponseDto> createLink(@RequestBody LinkRequestDto linkRequestDto) {
        LinkDto linkDto = linkService.create(linkRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(linkMapper.linkDtoToLinkResponseDto(linkDto));
    }
}
