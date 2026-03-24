package app.pfe.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.pfe.dao.LoginRequest;
import app.pfe.service.AuthentificationService;



@RestController
@RequestMapping("/auth")
public class AuthentificationController {

    private final AuthentificationService authService;

    public AuthentificationController(AuthentificationService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        System.out.println("comfirmation##########");
        
        String token = authService.login(request.email(), request.password());
        return ResponseEntity.ok(token);
    }

}
