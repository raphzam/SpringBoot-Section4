package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerBean implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public void run(String...strings) throws Exception {

//        USER with USER ROLE

        User user = new User ();
        user.setUsername("bart");
        user.setEmail("bart@domain.com");
        user.setPassword("bart");
        user.setFirstName("Bart");
        user.setLastName("Simpson");
        user.setEnabled(true);

        Role userRole = new Role();
        userRole.setUsername("bart");
        userRole.setRole("ROLE_USER");

        userRepository.save(user);
        roleRepository.save(userRole);

//        ADMIN with ADMIN AND USER ROLE
        User admin = new User();
        admin.setUsername("super");
        admin.setEmail("super@domain.com");
        admin.setPassword("super");
        admin.setFirstName("Super");
        admin.setLastName("Hero");
        admin.setEnabled(true);

        Role adminRole1 = new Role("super", "ROLE_ADMIN");
        Role adminRole2 = new Role("super", "ROLE_USER");

        userRepository.save(admin);
        roleRepository.save(adminRole1);
        roleRepository.save(adminRole2);


    }

}
