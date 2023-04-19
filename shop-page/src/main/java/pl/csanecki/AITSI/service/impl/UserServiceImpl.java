package pl.csanecki.AITSI.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.csanecki.AITSI.entity.Role;
import pl.csanecki.AITSI.entity.User;
import pl.csanecki.AITSI.repository.RoleRepository;
import pl.csanecki.AITSI.repository.UserRepository;
import pl.csanecki.AITSI.service.UserService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);

        Role userRole = roleRepository.findByRole("ADMIN");

        Set<Role> userRoles = new HashSet<>(Arrays.asList(userRole));
        user.setRoles(userRoles);

        return userRepository.save(user);
    }
}
