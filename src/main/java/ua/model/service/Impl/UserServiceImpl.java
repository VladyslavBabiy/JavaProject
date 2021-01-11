package ua.model.service.Impl;

import ua.model.dto.UserDTO;
import ua.model.entity.User;
import ua.model.exeption.AlreadyUsedEmail;
import ua.model.exeption.AlreadyUsedName;
import ua.model.service.UserService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl extends UserService {
    @Override
    public void addUser(UserDTO userDTO) {
        if (userDao.findByLogin(userDTO.getLogin()).isPresent()) {
            throw new AlreadyUsedName("Login " + userDTO.toString() + " already exists in system;");
        }
        if (userDao.findByEmail(userDTO.getEmail()).isPresent()) {
            throw new AlreadyUsedEmail("Email " + userDTO.toString() + " already exists in system;");
        }

        userDao.add(buildUserDtoToUser(userDTO));
    }

    @Override
    public Optional<User> getById(Long id) {
        return userDao.getById(id);
    }

    @Override
    public void update(UserDTO userDTO) {
        userDao.update(buildUserDtoToUser(userDTO));
    }

    @Override
    public void remove(UserDTO userDTO) {
        userDao.remove(buildUserDtoToUser(userDTO));
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return userDao.findByLogin(login);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public List<User> getAll() {
        return userDao.geAll();
    }

    private User buildUserDtoToUser(UserDTO userDTO) {
        return User.builder()
                .email(userDTO.getEmail())
                .login(userDTO.getLogin())
                .password(userDTO.getPassword())
                .firs_name(userDTO.getFirst_name())
                .middle_name(userDTO.getMiddle_name())
                .last_name(userDTO.getLast_name())
                .role(User.Role.User)
                .build();
    }

}
