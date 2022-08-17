/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leonardo.FFApiApplication.domain.service;

import com.leonardo.FFApiApplication.domain.model.Produto;
import com.leonardo.FFApiApplication.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author devsys-b
 */
@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;
    
    public Produto salvar (Produto produto) {
        //Cliente clienteExistente = clienteRepository.findByEmail(cliente.getEmail());        
        return produtoRepository.save(produto);
    }
    
    public void excluir(Long produtoId) {
        produtoRepository.deleteById(produtoId);
    }
}
