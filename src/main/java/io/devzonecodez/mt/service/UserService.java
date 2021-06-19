package io.devzonecodez.mt.service;

import io.devzonecodez.mt.dto.UserDto;

import java.util.List;

public interface UserService {

    public List<UserDto> findAll();

    public List<UserDto> findAllFromCustom();


}
