package com.javamentor.qa.platform.webapp.controllers.rest;

import com.javamentor.qa.platform.models.dto.AuthenticationRequestDTO;
import com.javamentor.qa.platform.models.dto.TokenResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @PostMapping("/token")
    public ResponseEntity<TokenResponseDTO> authentication (AuthenticationRequestDTO authenticationRequest) {

        return new ResponseEntity<> (HttpStatus.OK);
    }

    @PostMapping("/logout")
    public void logout (HttpServletResponse response, HttpServletRequest request) {

    }
}
