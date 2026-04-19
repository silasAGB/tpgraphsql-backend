package com.ifrimastergl.tpgraphsql.service;

import com.ifrimastergl.tpgraphsql.entity.User;
import com.ifrimastergl.tpgraphsql.repository.UserRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public User register(String email, String password) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("Email déjà utilisé");
        }
        return userRepository.save(new User(email, password));
    }

    public User login(String email, String password) {
        return userRepository.findByEmail(email)
            .filter(u -> u.getPassword().equals(password))
            .orElseThrow(() -> new RuntimeException("Email ou mot de passe incorrect"));
    }
}