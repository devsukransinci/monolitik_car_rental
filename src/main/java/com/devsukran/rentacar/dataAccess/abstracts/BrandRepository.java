package com.devsukran.rentacar.dataAccess.abstracts;

import com.devsukran.rentacar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand,Integer> {

 Brand findById(int id);
}
