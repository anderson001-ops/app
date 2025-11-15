package com.main.app.backend.dto;

import com.main.app.backend .dto.UserCreateRequest;
import com.main.app.backend.dto.UserUpdateRequest;
import com.main.app.backend.model.User;
import com.main.app.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new
        RuntimeException("Usuario no encontrado"));
    }

    public User Create (UserCreateRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setRole(request.getRole());
        user.setActive(request.getActive() != null ? request.getActive() : true);
        return userRepository.save(user);
    }

    public User update(Long id, UserUpdateRequest request) {
        User user = findById(id);

    //validar que el coordinador no pueda modificar el admin principal 
    if (id ==1L && isCoordinador()){
        throw new RuntimeException("no tienes permiso para modicar el administrador principal");
    }
    User.setUsername(request.getUsername());
    User.setEmail(request.getEmail());
    User.setRole(request.getRole());
    User.setActive(request.getActive());

    if (request.getPassword() != null && !request.getPassword().isEmpty()) {
        user.setPassword(passwordEncoder.encode(request.getPassword()));
    }
    return userRepository.save(user);
    }
    private boolean isCoordinador(){
        Authentication authentication = SecurityContextHolder.
        getContext().getAuthentication();
        if (authentication != null && authentication.getAuthorities()!= null){
            return authentication.getAuthorities().stream()
            .anyMatch(grantedAuthority -> grantedAuthority.getAuthority()
            .equals("ROLE_COORDINADOR"));
        }
        return false;
    }
    public void delete(Long id){
        User user = findById(id);
        
        // validar que no se elimine el usuario admin principal
        if (id == 1L){
            throw new RuntimeException("No tienes permiso para eliminar el administrador principal");
        }

        // validar que el usuario exista
        if (user = null){
            throw new RuntimeException("Usuario no encontrado");
        }
        userRepository.delete(user);
        
    }
}