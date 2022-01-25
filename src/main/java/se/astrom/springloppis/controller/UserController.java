package se.astrom.springloppis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import se.astrom.springloppis.entity.UserEntity;
import se.astrom.springloppis.service.BeanScopesDemo;
import se.astrom.springloppis.service.UserService;

import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("signup")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity){
        var createdUser = userService.createUser(userEntity);

        logger.trace("TRACE level logging.");
        logger.debug("DEBUG level logging.");
        logger.info("INFO level logging.");
        logger.warn("WARN level logging.");
        logger.error("ERROR level logging.");

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("{userId}")
    public ResponseEntity<Optional<UserEntity>> getUserById(@PathVariable Long userId){
        var foundUser = userService.getUserById(userId);
        return new ResponseEntity<>(foundUser, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<UserEntity>> getUsers(){
        var usersList = userService.getUsers();
        return new ResponseEntity<>(usersList, HttpStatus.OK);
    }


}
