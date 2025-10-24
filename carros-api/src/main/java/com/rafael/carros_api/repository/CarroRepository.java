package com.rafael.carros_api.repository;

import com.rafael.carros_api.model.carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<carro, Long> {

}
