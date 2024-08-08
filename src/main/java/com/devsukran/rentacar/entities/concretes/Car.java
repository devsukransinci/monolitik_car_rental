package com.devsukran.rentacar.entities.concretes;

import com.devsukran.rentacar.core.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cars")
@EqualsAndHashCode(callSuper = true)
public class Car extends BaseEntity<Integer> {

    @Column(name = "ModelYear")
    private int ModelYear;
    @Column(name = "plate")
    private String plate;
    @Column(name = "state")
    private int state;
    @Column(name = "dailyPrice")
    private double dailyPrice;

    @ManyToOne
    @JoinColumn(name = "modelId")
    private Model model;
}
