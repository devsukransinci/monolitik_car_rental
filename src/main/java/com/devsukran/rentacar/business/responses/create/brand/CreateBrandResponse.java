package com.devsukran.rentacar.business.responses.create.brand;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateBrandResponse {

    private int id;
    private String name;


}
