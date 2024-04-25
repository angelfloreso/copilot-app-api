package com.apex.copilotapi.services;

import com.apex.copilotapi.entities.Users;
import com.apex.copilotapi.repositories.UsersRepository;
import com.apex.copilotapi.requests.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UsersRepository usersRepository;

    public void addUser(UserRequest user) {
        usersRepository.save(
                new Users(
                        user.getFirstName(),
                        user.getLastName(),
                        user.getEmail(),
                        user.getRole(),
                        user.getStatus(),
                        user.getUsername()
                )
        );
    }

    public void editUser(Long userId, UserRequest user) {
        usersRepository.findById(userId).ifPresent(u -> {
            u.setFirstName(user.getFirstName());
            u.setLastName(user.getLastName());
            u.setEmail(user.getEmail());
            usersRepository.save(u);
        });
    }

    public void deleteUser(Long userId) {
        usersRepository.deleteById(userId);
    }

    public Users getUser(Long userId) {
        return usersRepository.findById(userId).orElse(null);
    }

    public List<Users> getAllUsers() {
        return (List<Users>) usersRepository.findAll();
    }

}
