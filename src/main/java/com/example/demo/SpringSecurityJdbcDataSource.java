package com.example.demo;

import org.hibernate.query.criteria.internal.expression.AbstractTupleElement;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringSecurityJdbcDataSource {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJdbcDataSource.class, args);
    }


    @Bean
    public CommandLineRunner run(UserRepository userRepository, AuthorityRepository authorityRepository) throws Exception {
        return (String[] args) -> {
            User user = new User("darth", "darth@domain.com", "darth",
                                  "Darth", "Vader", true);
            Authority userAuth = new Authority("darth", "ROLE_USER");
            Set<Authority> userAuthorities = new HashSet<Authority>();
            userAuthorities.add(userAuth);
            user.setAuthorities(userAuthorities);
            userRepository.save(user);
            authorityRepository.save(userAuth);

            User superuser = new User("super", "super@domain.com", "super",
                    "Super", "Super", true);

            Authority superAut1 = new Authority("super", "ROLE_USER");
            Authority superAut2 = new Authority("super", "ROLE_ADMIN");
            Set<Authority> superAuthorities = new HashSet<Authority>();
            superAuthorities.add(superAut1);
            superAuthorities.add(superAut2);
            superuser.setAuthorities(superAuthorities);
            userRepository.save(superuser);
            authorityRepository.save(superAut1);
            authorityRepository.save(superAut2);

            User admin = new User("yoda", "yoda@domain.com", "yoda",
                    "Yoda", "Adoy", true);
            Authority adminAuth = new Authority("yoda", "ROLE_ADMIN");
            Set<Authority> adminAuthorities = new HashSet<Authority>();
            adminAuthorities.add(adminAuth);
            admin.setAuthorities(adminAuthorities);
            userRepository.save(admin);
            authorityRepository.save(adminAuth);
        };
    }

}
