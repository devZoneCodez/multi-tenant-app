package io.devzonecodez.mt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto implements Serializable {
    private Long recordId;
    private String firstName;
    private String lastName;
    private Long mobile;
}
