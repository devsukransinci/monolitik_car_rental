package com.devsukran.rentacar.business.responses.create.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateModelResponse {
    private int brandId;

    private String name;
    private LocalDateTime createdDate;

}
