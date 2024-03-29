package com.example.form.service.impl;

import com.example.form.model.User;
import com.example.form.repository.IUserRepository;
import com.example.form.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public List<User> findAll() {
        return (List<User>) iUserRepository.findAll();
    }

    @Override
    public void create(User user) {
        iUserRepository.save(user);
    }
}
