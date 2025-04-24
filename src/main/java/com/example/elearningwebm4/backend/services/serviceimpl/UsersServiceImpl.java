package com.example.elearningwebm4.backend.services.serviceimpl;

import com.example.elearningwebm4.backend.models.Users;
import com.example.elearningwebm4.backend.repositories.IUsersRepository;
import com.example.elearningwebm4.backend.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private IUsersRepository IUsersRepository;

    @Override
    public Users findByEmail(String email) {
        return IUsersRepository.findByEmail(email);
    }
}
