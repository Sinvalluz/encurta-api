package com.SinvalDev.encurta_api.service;


import com.SinvalDev.encurta_api.dto.LinkDto;
import com.SinvalDev.encurta_api.dto.LinkRequestDto;
import com.SinvalDev.encurta_api.mapper.LinkMapper;
import com.SinvalDev.encurta_api.model.Link;
import com.SinvalDev.encurta_api.repository.LinkRepository;
import com.SinvalDev.encurta_api.utils.ShortCodeGenerator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Slf4j
@Service
@AllArgsConstructor
public class LinkService {

    private final LinkMapper linkMapper;
    private final LinkRepository linkRepository;

    public LinkDto create(LinkRequestDto linkRequestDto) {
        LocalDateTime dateNow = LocalDateTime.now();
        try {
            Link link = Link.builder()
                    .originalUrl(linkRequestDto.originalUrl())
                    .shortCode(ShortCodeGenerator.generate())
                    .creationDate(dateNow).build();

            Link linkSaved = linkRepository.save(link);
            log.info("Salvando entidade link no banco de dados id={}", linkSaved.getId());

            return linkMapper.linkEntityToLinkDto(linkSaved);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar link", e);
        }
    }
}
