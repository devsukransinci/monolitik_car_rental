package com.devsukran.rentacar.dataAccess.abstracts;

import com.devsukran.rentacar.entities.concretes.Brand;
import com.devsukran.rentacar.entities.concretes.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository  extends JpaRepository<Car,Integer> {
}
