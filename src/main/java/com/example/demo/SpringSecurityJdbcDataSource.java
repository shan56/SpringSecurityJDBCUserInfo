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
//            userRole.setUser(user);

            Set<Role> userRoles = new HashSet<Role>();
            userRoles.add(userRole);
//            user.setRoles(userRoles);
            userRepository.save(user);

            roleRepository.save(userRole);

            User superuser = new User("super", "super@domain.com", "super",
                    "Super", "Super", true);

            Role superAut1 = new Role("super", "ROLE_USER");
//            superAut1.setUser(superuser);
            Role superAut2 = new Role("super", "ROLE_ADMIN");
//            superAut2.setUser(superuser);
//            Set<Role> superRoles = new HashSet<Role>();
//            superRoles.add(superAut1);
//            superRoles.add(superAut2);
//            superuser.setRoles(superRoles);
            userRepository.save(superuser);
            roleRepository.save(superAut1);
            roleRepository.save(superAut2);

            User admin = new User("yoda", "yoda@domain.com", "yoda",
                    "Yoda", "Adoy", true);
            Role adminRole = new Role("yoda", "ROLE_ADMIN");
//            adminRole.setUser(admin);
//            Set<Role> adminRoles = new HashSet<Role>();
//            adminRoles.add(adminRole);
//            admin.setRoles(adminRoles);
            userRepository.save(admin);
            roleRepository.save(adminRole);
        };
    }

}
