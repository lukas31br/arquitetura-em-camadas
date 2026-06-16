package com.uel.integracaosql.service.Impl;

import com.uel.integracaosql.model.Users;
import com.uel.integracaosql.repository.UserDAO;
import com.uel.integracaosql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service // Informa ao Spring Boot que esta classe armazena as regras de negócio e cria um Bean na memória
public class UserServiceImpl implements UserService {

    @Autowired // Injeta o seu componente UserDAO de forma automática gerenciada pelo Spring
    private UserDAO userDAO;

    @Override
    public List<Users> findAll() {
        // Faz a ponte: o Controller pede um "findAll()", e o Service traduz chamando "listar_users()" do DAO
        return userDAO.listar_users();
    }

    @Override
    public Users save(Users user) {
        // Envia o objeto recebido do controlador direto para a query de INSERT nativa do seu DAO
        userDAO.cadastro_usuario(user);

        // Como o seu método cadastro_usuario() retorna 'void', retornamos o próprio objeto recebido
        // para cumprir a assinatura que o padrão REST e o Controller exigem.
        return user;
    }
}