package com.devsukran.rentacar.dataAccess.abstracts;

import com.devsukran.rentacar.entities.concretes.Brand;
import com.devsukran.rentacar.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository  extends JpaRepository<Model,Integer> {
    Model findByName(String name);
}
