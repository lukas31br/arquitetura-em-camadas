package com.uel.integracaosql.controller;

import com.uel.integracaosql.model.Users;
import com.uel.integracaosql.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController // Transforma esta classe em um componente REST que recebe JSON e responde JSON
@RequestMapping("/api/users") // Define que qualquer requisição que comece com '/api/users' cairá aqui
@CrossOrigin(origins = "*")
public class UserController {

    // Dependência da nossa Interface de serviço (Garante o desacoplamento das camadas)
    private final UserService userService;

    // Injeção de dependência via Construtor. O Spring Boot fornece automaticamente a implementação UserService
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping // Mapeia requisições HTTP do tipo GET (Ex: acessar via navegador ou Postman http://localhost:8080/api/users)
    public ResponseEntity<List<Users>> getAllUsers() {
        // Solicita a lista de usuários para a camada de Serviço
        List<Users> users = userService.findAll();
        // Devolve uma resposta HTTP com status 200 OK e a lista convertida para JSON no corpo da resposta
        return ResponseEntity.ok(users);
    }

    @PostMapping // Mapeia requisições HTTP do tipo POST para cadastrar dados (Enviar dados de formulário/JSON)
    public ResponseEntity<Users> createUser(@RequestBody Users user) {
        // @RequestBody avisa ao Spring para interceptar o JSON enviado no corpo da requisição e convertê-lo em um objeto Users do Java

        // Passa o objeto usuário para ser validado no Service e, consequentemente, inserido no banco pelo UserDAO
        Users savedUser = userService.save(user);

        // Retorna status HTTP 200 OK devolvendo os dados do usuário que acabaram de ser persistidos no PostgreSQL
        return ResponseEntity.ok(savedUser);
    }
}