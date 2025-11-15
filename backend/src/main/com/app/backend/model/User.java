package com.main.app.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @Column(nullable=false, unique = true)
    private string name;

    @JsonIgnore
    @column (nullable=false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @column(nullable= false)
    private Role role;

    @Column(nullable = false)
    private Boolean active = true;

    @column(name="created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    public enum Role{
        ADMIN,COORDINADOR
    }
    public void setUSername(String username){
        this.username=username;
    }

    public string getUSername(){
        return username;
    }

    public void setPassword(String password){
        this.password= password;
    }

    public String getPassword(){
        return password;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public string getEmail(){
        return email;
    }

    public void setRole(Role role){
        this.role=role;
    }

    public Role getRole(){
        return role;
    }

    public void setActive(Boolean active){
        this.active=active;
    }

    public boolean getActive(){
        return active;
    }

    public long getId(){
        return id;
    }
}