package com.example.elearningwebm4.backend.services.serviceimpl;

import com.example.elearningwebm4.backend.models.Users;
import com.example.elearningwebm4.backend.repositories.IUsersRepository;
import com.example.elearningwebm4.backend.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private IUsersRepository usersRepository;

    @Override
    public Users findByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    @Override
    public Users findByUserId(Long userId) {
        return usersRepository.findByUserId(userId);
    }

    @Override
    public Page<Users> findAllUsers(Pageable pageable) {
        return usersRepository.findAllUsers(pageable);
    }

    @Override
    public Page<Users> findByNameContaining(String name, Pageable pageable) {
        return usersRepository.findByNameContaining(name, pageable);
    }

    @Override
    public void saveUser(Users user) {
        usersRepository.save(user);
    }

//    @Override
//    public void deleteUserById(Long userId) {
//        usersRepository.deleteById(userId);
//    }

    @Override
    public void changeStatusUserById(Long userId) {
        Users user = usersRepository.findById(userId).get();
        user.setStatus(!user.isStatus());
        usersRepository.save(user);
    }
}
