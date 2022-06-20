package br.com.crud.desafiocrud.controllers;

import br.com.crud.desafiocrud.entity.DadosLogin;
import br.com.crud.desafiocrud.dto.UserAutheticatedDTO;
import br.com.crud.desafiocrud.entity.User;
import br.com.crud.desafiocrud.services.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController1 {

    private UserAuthenticationService userAuthenticationService;

    @Autowired
    public AuthenticationController1(UserAuthenticationService userAuthenticationService){
        this.userAuthenticationService = userAuthenticationService;
    }

    public AuthenticationController1(){

    }


    @PostMapping("/login")
    public ResponseEntity<UserAutheticatedDTO> autenticar(@RequestBody DadosLogin dadosLogin, @RequestHeader String Authorization){
        User user = userAuthenticationService.authenticate(dadosLogin, Authorization);
        return new ResponseEntity<UserAutheticatedDTO>(UserAutheticatedDTO.toDTO(user, "Bearer "), HttpStatus.ACCEPTED);
    }
}
