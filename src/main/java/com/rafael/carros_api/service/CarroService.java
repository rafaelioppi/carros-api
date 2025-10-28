package com.rafael.carros_api.service;

import com.rafael.carros_api.model.Carro;
import com.rafael.carros_api.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public List<Carro> listarTodos() {
        return carroRepository.findAll();
    }

    public Optional<Carro> buscarPorId(Long id) {
        return carroRepository.findById(id);
    }

    public Carro salvar(Carro carro) {
        return carroRepository.save(carro);
    }

    public Carro atualizar(Long id, Carro carroAtualizado) {
        return carroRepository.findById(id)
            .map(carro -> {
                carro.setModelo(carroAtualizado.getModelo());
                carro.setMarca(carroAtualizado.getMarca());
                carro.setAno(carroAtualizado.getAno());
                carro.setPreco(carroAtualizado.getPreco());
                return carroRepository.save(carro);
            })
            .orElseThrow(() -> new RuntimeException("Carro não encontrado"));
    }

    public void deletar(Long id) {
        carroRepository.deleteById(id);
    }
}
