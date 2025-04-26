package com.example.elearningwebm4.backend.configuration;



import com.example.elearningwebm4.backend.common.EncryptPasswordUtils;
import com.example.elearningwebm4.backend.models.Role;
import com.example.elearningwebm4.backend.models.Users;
import com.example.elearningwebm4.backend.repositories.IRoleRepository;
import com.example.elearningwebm4.backend.repositories.IUsersRepository;
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
    private IUsersRepository accountRepository;

    @Autowired
    private IRoleRepository IRoleRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (IRoleRepository.findByName("ROLE_ADMIN") == null) {
            IRoleRepository.save(new Role("ROLE_ADMIN"));
        }

        if (IRoleRepository.findByName("ROLE_USER") == null) {
            IRoleRepository.save(new Role("ROLE_USER"));
        }

        //them admin
        if (accountRepository.findByEmail("admin@gmail.com") == null) {
            Users admin = new Users();
            admin.setName("admin");
            admin.setEmail("admin@gmail.com");
            admin.setStatus(true);
            // mã hóa mật khẩu
            admin.setPassword(EncryptPasswordUtils.EncryptPasswordUtils("123456"));
            List<Role> roles = new ArrayList<>();
            roles.add(IRoleRepository.findByName("ROLE_ADMIN"));
            roles.add(IRoleRepository.findByName("ROLE_USER"));
            admin.setRoles(roles);
            accountRepository.save(admin);
        }

        //Them user
        if (accountRepository.findByEmail("member@gmail.com") == null) {
            Users user = new Users();
            user.setName("member");
            user.setEmail("member@gmail.com");
            user.setStatus(true);
            // mã hóa mật khẩu
            user.setPassword(EncryptPasswordUtils.EncryptPasswordUtils("123456"));
            List<Role> roles = new ArrayList<>();
            roles.add(IRoleRepository.findByName("ROLE_USER"));
            user.setRoles(roles);
            accountRepository.save(user);
        }

        if (accountRepository.findByEmail("minhphuc@gmail.com") == null) {
            Users user = new Users();
            user.setName("minhphuc");
            user.setEmail("minhphuc@gmail.com");
            user.setStatus(true);
            // mã hóa mật khẩu
            user.setPassword(EncryptPasswordUtils.EncryptPasswordUtils("123456"));
            List<Role> roles = new ArrayList<>();
            roles.add(IRoleRepository.findByName("ROLE_USER"));
            user.setRoles(roles);
            accountRepository.save(user);
        }
    }

    @Override
    public boolean supportsAsyncExecution() {
        return ApplicationListener.super.supportsAsyncExecution();
    }
}
