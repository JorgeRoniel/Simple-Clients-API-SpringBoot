package shr.company.api_client_cep.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;
import shr.company.api_client_cep.models.User;
import shr.company.api_client_cep.services.UserServices;

@RestController
@RequestMapping("/clients")
@SuppressWarnings("rawtypes")
public class UserControllers {
    
    @Autowired
    private UserServices services;

    
    @PostMapping("/addClient")
    public ResponseEntity addUser(@RequestBody User user){
        services.insertUser(user);

        return ResponseEntity.ok(user);
    }

    @GetMapping("/listClients")
    public ResponseEntity<Iterable<User>> listAll(){
        return ResponseEntity.ok(services.listAllUsers());
    }

    @GetMapping("findClient/{id}")
    public ResponseEntity<User> findUser(@PathParam("id") Long id){
        return ResponseEntity.ok(services.findOneUser(id));
    }

    @PutMapping("/updateClient/{id}")
    public ResponseEntity updateUser(@PathParam("id") Long id, @RequestBody User user){
        services.updateUser(id, user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteClient/{id}")
    public ResponseEntity deleteUser(@PathParam("id") Long id){
        services.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
