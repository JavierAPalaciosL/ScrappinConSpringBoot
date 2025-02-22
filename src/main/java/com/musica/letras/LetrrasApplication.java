package com.musica.letras;

import com.musica.letras.entity.UserEntity;
import com.musica.letras.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.*;

@SpringBootApplication
public class LetrrasApplication implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LetrrasApplication(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public static void main(String[] args) {
        SpringApplication.run(LetrrasApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        UserEntity user = new UserEntity();
        user.setEmail("user@email.com");
        user.setPassword(passwordEncoder.encode("123456"));

        UserEntity user2 = new UserEntity();
        user2.setEmail("user2@email.com");
        user2.setPassword(passwordEncoder.encode("123456"));

        userRepository.save(user);
        userRepository.save(user2);
        
    }
}
