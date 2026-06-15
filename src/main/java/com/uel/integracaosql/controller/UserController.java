package com.uel.integracaosql.controller;

import com.uel.integracaosql.model.Users;
import com.uel.integracaosql.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    // Injeção de dependência via construtor do Spring
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Exemplo de Endpoint para buscar todos os usuários (GET /api/users)
    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        // Altere o método de chamada do serviço de acordo com o nome que você definiu na sua UserService
        List<Users> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    // Exemplo de Endpoint para criar um novo usuário (POST /api/users)
    @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody Users user) {
        // Altere o método de chamada do serviço de acordo com o nome que você definiu na sua UserService
        Users savedUser = userService.save(user);
        return ResponseEntity.ok(savedUser);
    }
}