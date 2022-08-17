/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leonardo.FFApiApplication.domain.service;

import com.leonardo.FFApiApplication.domain.model.Cliente;
import com.leonardo.FFApiApplication.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author devsys-b
 */
@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    
    public Cliente salvar (Cliente cliente) {
//        Cliente clienteExistente = clienteRepository.findByEmail(cliente.getEmail());
//        
//        //Lembre-se que o método SAVE pode ser usado para atualizar um cliente já existente também!!
//        //ID Vazio --> Novo Registro
//        //ID Preenchido --> Alterar existente
//        
//        //Verifica se o cliente existe
//        if (clienteExistente != null && !clienteExistente.equals(cliente)) {
//            //Lançar Exception
//            throw new DomainException("Já existe um cliente com esse email!");
//            
//        }
        
        return clienteRepository.save(cliente);
    }
    
    public void excluir(Long clienteId) {
        clienteRepository.deleteById(clienteId);
    }
}

