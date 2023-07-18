package com.example.practice.practice5.jpa.service;

import com.example.practice.practice5.jpa.model.Crew;
import com.example.practice.practice5.jpa.repository.CrewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CrewService {

    private final CrewRepository crewRepository;

    /**
     * transaction은 public 메소드에서만 적용이 됨.
     * */
    @Transactional
    public void put() {
        Crew crew = Crew.builder()
                .name("엔티티")
                .build();

        crewRepository.save(crew);
    }
}
