package com.rafael.carros_api.controller;

import com.rafael.carros_api.model.Carro;
import com.rafael.carros_api.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroService service;

    /**
     * Retorna todos os carros.
     */
    @GetMapping
    public ResponseEntity<List<Carro>> listarTodos() {
        List<Carro> carros = service.listarTodos();
        return ResponseEntity.ok(carros);
    }

    /**
     * Retorna um carro específico pelo ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Carro> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo carro.
     */
    @PostMapping
    public ResponseEntity<Carro> salvar(@RequestBody Carro carro) {
        Carro novoCarro = service.salvar(carro);
        return ResponseEntity.ok(novoCarro);
    }

    /**
     * Atualiza um carro existente.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Carro> atualizar(@PathVariable Long id, @RequestBody Carro carro) {
        try {
            Carro atualizado = service.atualizar(id, carro);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Remove um carro pelo ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
