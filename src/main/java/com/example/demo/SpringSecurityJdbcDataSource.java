package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class SpringSecurityJdbcDataSource {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJdbcDataSource.class, args);
    }


    @Bean
    public CommandLineRunner run(UserRepository userRepository, AuthorityRepository authorityRepository) throws Exception {
        return (String[] args) -> {
            authorityRepository.save(new Authority("neo", "USER"));
            authorityRepository.save(new Authority("oracle","ADMIN"));

            Authority userAuthority = authorityRepository.findByAuthority("USER");
            Authority adminAuthority = authorityRepository.findByAuthority("ADMIN");

            User user = new User("neo", "neo@matrix.com", "user",
                                  "Neo", "Wonder", true);
            user.setAuthorities(Arrays.asList(userAuthority));
            userRepository.save(user);


            User admin  = new User("oracle", "oracle@matrix.com", "super",
                    "Oracle", "Super", true);
            admin.setAuthorities(Arrays.asList(adminAuthority));
            userRepository.save(admin);
        };
    }

}
