package com.login.registerLogin.Controller;

import com.login.registerLogin.Entity.User;
import com.login.registerLogin.Response.ResponseHandler;
import com.login.registerLogin.Service.ServiceLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("/login")
public class UserController {
    @Autowired
    private ServiceLogin serviceLogin;

    @PostMapping("/")
    public ResponseEntity<Object> saveProduct(@RequestBody User newUser) {
        try {
            User save = serviceLogin.save(newUser);
            if ( save != null){
                return ResponseHandler.generateResponse("Success", HttpStatus.CREATED,save);
            } else{
                return ResponseHandler.generateResponse("Error", HttpStatus.NOT_ACCEPTABLE , "Email o nombre de usuario invalido");
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PostMapping("/access")
    public ResponseEntity<Object> login(@RequestBody User user) {
        try {
            if (serviceLogin.login(user) != null){
                return ResponseHandler.generateResponse("Success", HttpStatus.CREATED,serviceLogin.login(user));
            } else{
                return ResponseHandler.generateResponse("Error", HttpStatus.NOT_ACCEPTABLE , "Email o contrasena invalido");
            }

        } catch (Exception e) {
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
        try {
            return ResponseHandler.generateResponse("Succes",HttpStatus.OK,serviceLogin.deleteUser(id));
        }catch (Exception e){
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editProducto(@PathVariable Integer id, @RequestBody User user){
        try {
            if (serviceLogin.updateUser(id,user) == true){
                return ResponseHandler.generateResponse("Succes",HttpStatus.OK,serviceLogin.updateUser(id,user));
            } else {
                return ResponseHandler.generateResponse("Error", HttpStatus.NOT_ACCEPTABLE,"Email o nombre de usuario incorrectos");
            }

        }catch (Exception e){
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        }
    }

}