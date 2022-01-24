package se.astrom.springloppis.service;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import se.astrom.springloppis.entity.UserEntity;
import se.astrom.springloppis.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity createUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    public void deleteUser(Long userId) {
        UserEntity foundUser = userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
        userRepository.delete(foundUser);
    }

    public Optional<UserEntity> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public Iterable<UserEntity> getUsers() {
        return userRepository.findAll();
    }
}
