package com.example.practice.training.shin.service;

import com.example.practice.training.shin.model.User;
import com.example.practice.training.shin.model.dto.AddUserRequest;
import com.example.practice.training.shin.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long register(AddUserRequest dto) {
        return userRepository.save(
                User.builder()
                        .email(dto.getEmail())
                        .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                        .build()
        ).getId();
    }
}
