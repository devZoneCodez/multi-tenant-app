package io.devzonecodez.mt.service.impl;

import io.devzonecodez.mt.dto.UserDto;
import io.devzonecodez.mt.model.User;
import io.devzonecodez.mt.repo.UserRepo;
import io.devzonecodez.mt.repo.UserRepoCustom;
import io.devzonecodez.mt.service.UserService;
import io.devzonecodez.mt.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private Converter converter;

    @Autowired
    private UserRepoCustom userRepoCustom;

    @Override
    public List<UserDto> findAll() {
        List<UserDto> users = new ArrayList<>();
        Iterable<User> userIterable = userRepo.findAll();
        userIterable.forEach(user -> users.add(converter.convertToDto(user)));
        return users;
    }

    @Override
    public List<UserDto> findAllFromCustom() {
        List<UserDto> users = new ArrayList<>();
        Iterable<User> userIterable = userRepoCustom.findAll();
        userIterable.forEach(user -> users.add(converter.convertToDto(user)));
        return users;
    }
}
