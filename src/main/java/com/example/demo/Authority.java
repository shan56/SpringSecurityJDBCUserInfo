package com.example.demo;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Collection;

@Entity
//@Table(name="authorities", uniqueConstraints = @UniqueConstraint(columnNames = {"username", "authority"}))
@Table(name="authorities")

public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "authority")
    private String authority;

    //    @ManyToMany(mappedBy = "authorities", fetch = FetchType.LAZY)
    //    private Collection<User> users;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Authority() {
    }

    public Authority(String username, String authority) {
        this.username = username;
        this.authority = authority;
        //this.user = new User();
    }

    public Authority(String authority) {
        this.authority = authority;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
