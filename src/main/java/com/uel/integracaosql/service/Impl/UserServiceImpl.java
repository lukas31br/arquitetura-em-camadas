package com.uel.integracaosql.service.Impl;

import com.uel.integracaosql.model.Users;
import com.uel.integracaosql.repository.UserDAO;
import com.uel.integracaosql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<Users> findAll() {
        return userDAO.findAll();
    }

    @Override
    public Optional<Users> findById(Long id) {
        return userDAO.findById(id);
    }

    @Override
    public Users save(Users user) {
        // You can add business rules here (e.g., password encryption, validation)
        return userDAO.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userDAO.deleteById(id);
    }
}