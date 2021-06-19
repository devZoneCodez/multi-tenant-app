package io.devzonecodez.mt.controller;

import io.devzonecodez.mt.dto.UserDto;
import io.devzonecodez.mt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@Transactional
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/all")
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @GetMapping(path = "/allCustom")
    public List<UserDto> findAllCustom() {
        return userService.findAllFromCustom();
    }
}
