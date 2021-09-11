package io.devzonecodez.mt.util;

import io.devzonecodez.mt.dto.UserDto;
import io.devzonecodez.mt.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Converter {

    @Autowired
    private ModelMapper modelMapper;

    public User convertToEntity(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

    public UserDto convertToDto(User userEntity) {
        return modelMapper.map(userEntity, UserDto.class);
    }

}
