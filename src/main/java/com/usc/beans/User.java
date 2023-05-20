package com.usc.beans;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity // jpa or mapping
@Table(name = "usc.user")
public class User implements UserDetails {
    private static final long serialVersionUID = 1L;
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "USC_USER_SEQ")
    private int id;
    @Column(name = "username", unique = true, nullable = false)  // @column define a column name

    private String username;
    @Column(name = "password", nullable = false)
    private String password;

    // one user to many profiles
    // one profile to many users
    // eager to build table first
    //
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "c_user_c_user_profile", joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = {
                    @JoinColumn(name = "user_profile_id", referencedColumnName = "id") })
    private List<UserProfile> profiles = new ArrayList<UserProfile>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return profiles;
    }


    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", profiles=" + profiles +
                '}';
    }

    public List<UserProfile> getProfiles() {
        return profiles;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProfiles(List<UserProfile> profiles) {
        this.profiles = profiles;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public User(int id, String username, String password, List<UserProfile> profiles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.profiles = profiles;
    }

    public User() {
    }
}
