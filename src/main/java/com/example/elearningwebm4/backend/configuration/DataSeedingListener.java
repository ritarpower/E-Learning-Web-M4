package com.example.elearningwebm4.backend.configuration;



import com.example.elearningwebm4.backend.common.EncryptPasswordUtils;
import com.example.elearningwebm4.backend.models.Role;
import com.example.elearningwebm4.backend.models.Users;
import com.example.elearningwebm4.backend.repositories.RoleRepository;
import com.example.elearningwebm4.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private UserRepository accountRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (roleRepository.findByName("ROLE_ADMIN") == null) {
            roleRepository.save(new Role("ROLE_ADMIN"));
        }

        if (roleRepository.findByName("ROLE_USER") == null) {
            roleRepository.save(new Role("ROLE_USER"));
        }

        //them admin
        if (accountRepository.findByEmail("admin@gmail.com") == null) {
            Users admin = new Users();
            admin.setName("admin");
            admin.setEmail("admin@gmail.com");
            admin.setStatus(true);
            admin.setCreateAt(LocalDateTime.now());
            // mã hóa mật khẩu
            admin.setPassword(EncryptPasswordUtils.EncryptPasswordUtils("123456"));
            List<Role> roles = new ArrayList<>();
            roles.add(roleRepository.findByName("ROLE_ADMIN"));
            roles.add(roleRepository.findByName("ROLE_USER"));
            admin.setRoles(roles);
            accountRepository.save(admin);
        }

        //Them user
        if (accountRepository.findByEmail("member@gmail.com") == null) {
            Users user = new Users();
            user.setName("member");
            user.setEmail("member@gmail.com");
            user.setStatus(true);
            user.setCreateAt(LocalDateTime.now());
            // mã hóa mật khẩu
            user.setPassword(EncryptPasswordUtils.EncryptPasswordUtils("123456"));
            List<Role> roles = new ArrayList<>();
            roles.add(roleRepository.findByName("ROLE_USER"));
            user.setRoles(roles);
            accountRepository.save(user);
        }
    }

    @Override
    public boolean supportsAsyncExecution() {
        return ApplicationListener.super.supportsAsyncExecution();
    }
}
