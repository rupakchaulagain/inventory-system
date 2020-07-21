package com.inventory.dto.request.admin;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author rupak ON 2020/07/21-8:37 AM
 */
@Getter
public class AdminRequestDTO implements Serializable {

    @NotNull
    @NotEmpty
    private String adminName;

    @NotNull
    @NotEmpty
    private String userName;

    @NotNull
    @NotEmpty
    private String password;

    private String mobileNumber;

    private String remarks;


}
