package com.bitlab.sprint2.service;

import com.bitlab.sprint2.model.Role;
import com.bitlab.sprint2.model.User;
import com.bitlab.sprint2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleService roleService;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void addRoleToUser(Long userId, Long roleId) {
        User user = getUserById(userId);
        Role role = roleService.getRoleById(roleId);
        if (user == null || role == null) {
            return;
        }

        List<Role> roles = user.getRole();
        roles.add(role);

        userRepository.save(user);
    }

    public void removeRoleFromUser(Long userId, Long roleId) {
        User user = getUserById(userId);
        Role role = roleService.getRoleById(roleId);
        if (user == null || role == null) {
            return;
        }

        List<Role> roles = user.getRole();
        roles.remove(role);
        userRepository.save(user);
    }
}