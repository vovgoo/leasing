package by.vovgoo.leasing.service.impl;

import by.vovgoo.leasing.dto.SupportDto;
import by.vovgoo.leasing.dto.pages.SupportPage.SupportRequest;
import by.vovgoo.leasing.entity.Support;
import by.vovgoo.leasing.entity.User;
import by.vovgoo.leasing.mapper.SupportMapper;
import by.vovgoo.leasing.repositories.SupportRepository;
import by.vovgoo.leasing.service.SupportService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SupportServiceImpl implements SupportService {

    private final SupportRepository supportRepository;

    private final SupportMapper supportMapper;

    @Override
    @Transactional
    public SupportDto create(SupportRequest supportRequest) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Support support = Support.builder()
                .user(user)
                .subject(supportRequest.getSubject())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        return Optional.of(support).map(supportRepository::save).map(supportMapper::mapFrom).orElseThrow();
    }
}
