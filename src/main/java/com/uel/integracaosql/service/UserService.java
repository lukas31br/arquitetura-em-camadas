package com.uel.integracaosql.service;

import com.uel.integracaosql.model.Users;
import java.util.List;

/**
 * Interface que define o contrato de negócios para os Usuários.
 * Ela dita os métodos que o Controller pode enxergar, escondendo a lógica real.
 */
public interface UserService {

    // Contrato para listar todos os usuários cadastrados
    List<Users> findAll();

    // Contrato para salvar ou registrar um novo usuário
    Users save(Users user);
}