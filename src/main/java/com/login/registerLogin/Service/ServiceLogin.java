package com.login.registerLogin.Service;

import com.login.registerLogin.DTO.UserDTO;
import com.login.registerLogin.Entity.User;
import com.login.registerLogin.Repositories.UserRepository;
import com.login.registerLogin.utils.EncryptPassword;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ServiceLogin {

    BCrypt bCrypt = new BCrypt();

    @Autowired
    private UserRepository userRepository;

    public User save(User newUser){
        if (validaremail(newUser.getEmaillUsuario()) && validarUserName(newUser.getNombreUsuario())){
            User user1 = new User();
            user1.setContrasena(EncryptPassword.md5(newUser.getContrasena()));
            user1.setId(newUser.getId());
            user1.setEmaillUsuario(newUser.getEmaillUsuario());
            user1.setNombreUsuario(newUser.getNombreUsuario());
            user1.setTipoUsuario(newUser.getTipoUsuario());
            userRepository.save(user1);
            return user1;
        }else {
            return null;
        }

    }

    public UserDTO login(User user){
        String pass = EncryptPassword.md5(user.getContrasena());
        User result = userRepository.login(user.getEmaillUsuario(),pass);
        if (result != null){
            return mapUserToDTO(result);
        }
        return null;
    }

    private UserDTO mapUserToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setNombreUsuario(user.getNombreUsuario());
        userDTO.setEmaillUsuario(user.getEmaillUsuario());
        userDTO.setTipoUsuario(user.getTipoUsuario());
        return userDTO;
    }

    public User findById(Integer id){
        Optional<User> optional = userRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

    public boolean deleteUser(Integer id){
        userRepository.delete(findById(id));
        return true;
    }


    public boolean updateUser(Integer id,User user){
        User findUser = findById(id);
        if (findUser != null && validaremail(user.getEmaillUsuario()) && validarUserName(user.getNombreUsuario())){
            findUser.setEmaillUsuario(user.getEmaillUsuario());
            findUser.setNombreUsuario(user.getNombreUsuario());
            findUser.setContrasena(user.getContrasena());
            findUser.setTipoUsuario(user.getTipoUsuario());
            userRepository.save(findUser);
            return true;
        }else {
            return false;
        }
    }

    public boolean validaremail(String email){
        String regex = "^[a-zA-Z0-9._%+-]+@gmail\\.com$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public boolean validarUserName(String name){
        String regex = "^[a-zA-Z]+$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(name);

        return matcher.matches();
    }
}