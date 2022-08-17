/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leonardo.FFApiApplication.api.controller;

import com.leonardo.FFApiApplication.domain.model.Cliente;
import com.leonardo.FFApiApplication.domain.repository.ClienteRepository;
import com.leonardo.FFApiApplication.domain.service.ClienteService;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author devsys-b
 */
@RestController
public class ClienteController {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping("/clientes")
    public List<Cliente> listas() {
        
        //Linguagem JPQL só que do Jakarta
        return clienteRepository.findAll();
        //return clienteRepository.findByNome("KGe");
        //return clienteRepository.findByNomeContaining("Silva");
    }
    
    @GetMapping("/clientes/{clienteID}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long clienteID) {
        Optional<Cliente> cliente = clienteRepository.findById(clienteID);
        
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
        
        return clienteService.salvar(cliente);
    }
    
    @PutMapping("/clientes/{clienteID}")
    public ResponseEntity<Cliente> atualizar(@Valid @PathVariable Long clienteID,
            @RequestBody Cliente cliente) {
        
        //verificar se o cliente existe
        if(!clienteRepository.existsById(clienteID)) {
            return ResponseEntity.notFound().build();
        }
        
        cliente.setId(clienteID);
        cliente = clienteService.salvar(cliente);
        return ResponseEntity.ok(cliente);
        
    }
    
    
    @DeleteMapping("/clientes/{clienteID}")
    public ResponseEntity<Void> excluir (@PathVariable Long clienteID) {
        //verifica se o cliente existe ou não
        
        if (!clienteRepository.existsById(clienteID)) {
            return ResponseEntity.notFound().build();
        }
        
        clienteService.excluir(clienteID);
        return ResponseEntity.noContent().build();
        
    }
}
