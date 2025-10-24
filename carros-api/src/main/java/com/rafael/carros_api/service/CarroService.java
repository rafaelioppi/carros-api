package com.rafael.carros_api.service;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.rafael.carros_api.repository.CarroRepository;
import com.rafael.carros_api.model.Carro;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public List<Carro> getAllCarros() {
        return carroRepository.findAll();
    }

    public Carro getCarroById(Long id) {
        return carroRepository.findById(id).orElse(null);
    }

    public Carro salvarCarro(Carro carro) {
        return carroRepository.save(carro);
    }

    public Carro atualizarCarro(Long id, Carro carroDetalhes) {
        Carro carro = carroRepository.getCarroById(id);
        if (carro != null) {
            carro.setModelo(carroDetalhes.getModelo());
            carro.setMarca(carroDetalhes.getMarca());
            carro.setAno(carroDetalhes.getAno());
            carro.setPreco(carroDetalhes.getPreco());
            return salvarCarro(carroDetalhes);
        }
        return null;
    }

    public void deletarCarro(Long id) {
        carroRepository.deleteById(id);
    }

}
