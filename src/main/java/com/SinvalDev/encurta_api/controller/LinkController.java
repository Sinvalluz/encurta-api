package com.SinvalDev.encurta_api.controller;

import com.SinvalDev.encurta_api.dto.LinkDto;
import com.SinvalDev.encurta_api.dto.LinkRequestDto;
import com.SinvalDev.encurta_api.dto.LinkResponseDto;
import com.SinvalDev.encurta_api.mapper.LinkMapper;
import com.SinvalDev.encurta_api.service.LinkService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@CrossOrigin(origins = "*")
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

    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> getLinkByShortCode(@PathVariable String shortCode) {
        LinkDto linkDto = linkService.findLinkByShortCode(shortCode);
        String originalUrl = linkDto.originalUrl();

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(originalUrl)).build();
    }
}
