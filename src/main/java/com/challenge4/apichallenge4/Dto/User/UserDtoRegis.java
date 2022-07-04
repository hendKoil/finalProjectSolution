package com.challenge4.apichallenge4.Dto.User;


import com.challenge4.apichallenge4.Entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


@Setter
@Getter
public class UserDtoRegis {
    @JsonIgnore
    private int userId;
    @ApiModelProperty(example = "why")
    private String nama;
    @ApiModelProperty(example = "hyper@gmail.com")
    private String email;
    @ApiModelProperty(example = "heiya")
    private String password;
}
