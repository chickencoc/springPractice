package com.example.practice.practice5.jpa.model;

import com.example.practice.practice5.jpa.repository.MemberLogHistoryRepository;
import com.example.practice.practice5.jpa.util.SpringBeanUtils;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;

public class MemberEntityListener {
    @PostPersist
    @PostUpdate
    public void afterMemberSave(Object o) {
        MemberLogHistoryRepository memberLogHistoryRepository = SpringBeanUtils.getBean(MemberLogHistoryRepository.class);

        if(o instanceof Member) {
            Member member = (Member) o;

            MemberLogHistory mlh = MemberLogHistory.builder()
                    .memberId(member.getId())
                    .name(member.getName())
                    .email(member.getEmail())
                    .nation(member.getNation())
                    .build();

            memberLogHistoryRepository.save(mlh);
        } else if(o instanceof Member3) {
            Member3 member = (Member3) o;

            MemberLogHistory mlh = MemberLogHistory.builder()
                    .memberId(member.getId())
                    .name(member.getName())
                    .email(member.getEmail())
                    .build();

            memberLogHistoryRepository.save(mlh);
        }
    }
}
