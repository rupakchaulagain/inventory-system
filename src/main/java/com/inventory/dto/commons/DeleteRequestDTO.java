package com.inventory.dto.commons;

import com.inventory.constraintvalidator.DeleteStatus;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class DeleteRequestDTO implements Serializable {
    @NotNull
    private Long id;

    @NotNull
    @NotEmpty
    private String remarks;

//    @NotNull
//    @DeleteStatus
//    private Character status;

}
