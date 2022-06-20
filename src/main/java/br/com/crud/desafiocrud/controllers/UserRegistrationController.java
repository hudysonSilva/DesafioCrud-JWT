package br.com.crud.desafiocrud.controllers;

import br.com.crud.desafiocrud.dto.UserAutheticatedDTO;
import br.com.crud.desafiocrud.dto.UserRegistrationDTO;
import br.com.crud.desafiocrud.entity.User;
import br.com.crud.desafiocrud.services.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRegistrationController {

    private UserRegistrationService userRegistrationService;

    @Autowired
    public UserRegistrationController(UserRegistrationService userRegistrationService){
        this.userRegistrationService = userRegistrationService;
    }

    public UserRegistrationController(){

    }

    @PostMapping("/user")
    public ResponseEntity<UserAutheticatedDTO> registrate(@RequestBody UserRegistrationDTO userRegistrationDTO){
        User user = userRegistrationService.registrate(userRegistrationDTO.toUser());
        return  new ResponseEntity<UserAutheticatedDTO>(UserAutheticatedDTO.toDTO(user, "Bearer "), HttpStatus.CREATED);
    }

}
