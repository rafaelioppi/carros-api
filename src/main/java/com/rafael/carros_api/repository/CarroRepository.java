package com.rafael.carros_api.repository;

import com.rafael.carros_api.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {

}
