package main.com.app.backend.dto;

import com.main.app.backend.model.User;
public class LoginResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String username;
    private String email;
    private User.Role role;

    public LoginResponse(){
    }
    public LoginResponse(String token,User user){
        this.token= token;
        this.id=user.getId();
        this.username=user.getUsername();
        this.email=user.getEmail();
        this.role=user.getRole();
    }
    public String getToken(){
        return token;
    }

    public void setToken(String token){
        this.token= token;
    }
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type= type;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }
    public String getUsername(){
        return username;
    }

    public void setUsername(String userName){
        this.username=username;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public String getRole(){
        return role;
    }
    public void setRole(User.Role role){
        this.role=role;
    }

    

}