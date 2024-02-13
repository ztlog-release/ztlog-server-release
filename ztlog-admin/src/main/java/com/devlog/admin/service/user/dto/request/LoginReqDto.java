package com.devlog.admin.service.user.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ToString
@Builder
public class LoginReqDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -4963635693182734520L;

    private Long userNo;

    private String username;

    private String password;

    private String grant;

}