package com.challenge4.apichallenge4.Dto.User;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
public class UserDtoLogin {
    @ApiModelProperty(example = "reservasi@gmail.com")
    private String email;
    @ApiModelProperty(example = "nicehuy")
    private String password;
}
