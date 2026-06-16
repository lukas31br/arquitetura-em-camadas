package com.uel.integracaosql.service.Impl;

import com.uel.integracaosql.model.Users;
import com.uel.integracaosql.repository.UserDAO;
import com.uel.integracaosql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service // Permite ao Spring Boot reconhecer este componente de negócio (spring bean)
public class UserServiceImpl implements UserService {

    @Autowired // Injetar automaticamente dependências necessárias
    private UserDAO userDAO;

    @Override
    public List<Users> findAll() {
        // Conecta o método em inglês solicitado pelo Controller com a sua listagem em português
        return userDAO.listar_users();
    }

    @Override
    public Users save(Users user) {
        // Realiza o cadastro utilizando a conexão JDBC manual do seu DAO
        userDAO.cadastro_usuario(user);
        // Como o método DAO é 'void', retorna o próprio objeto populado para o Controller
        return user;
    }
}