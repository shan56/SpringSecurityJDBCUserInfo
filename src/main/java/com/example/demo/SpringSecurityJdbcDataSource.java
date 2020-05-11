package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringSecurityJdbcDataSource {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJdbcDataSource.class, args);
    }


    @Bean
    public CommandLineRunner run(UserRepository userRepository, RoleRepository roleRepository) throws Exception {
        return (String[] args) -> {
            User user = new User("darth", "darth@domain.com", "darth",
                                  "Darth", "Vader", true);
            Role userRole = new Role("darth", "ROLE_USER");

            userRepository.save(user);
            roleRepository.save(userRole);

            User superuser = new User("super", "super@domain.com", "super",
                    "Super", "Super", true);

            Role superAut1 = new Role("super", "ROLE_USER");
            Role superAut2 = new Role("super", "ROLE_ADMIN");
            userRepository.save(superuser);
            roleRepository.save(superAut1);
            roleRepository.save(superAut2);

            User admin = new User("yoda", "yoda@domain.com", "yoda",
                    "Yoda", "Adoy", true);
            Role adminRole = new Role("yoda", "ROLE_ADMIN");
            userRepository.save(admin);
            roleRepository.save(adminRole);
        };
    }

}
