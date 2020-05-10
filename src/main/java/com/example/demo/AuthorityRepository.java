package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface AuthorityRepository extends CrudRepository<Authority, Long> {
//    Collection<Authority> findAllByAuthority(String authority);
//    Collection<Authority> findAllByUsername(String username);
//    Authority findByUsernameAndAuthority(String username, String authority);

    Authority findByAuthority(String authority);
}
