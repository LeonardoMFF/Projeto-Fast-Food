/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leonardo.FFApiApplication.domain.service;

import com.leonardo.FFApiApplication.domain.model.Pedido;
import com.leonardo.FFApiApplication.domain.model.StatusPedido;
import com.leonardo.FFApiApplication.domain.repository.PedidoRepository;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author devsys-b
 */
@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;
    
    public Pedido salvar (Pedido pedido) {
        
        pedido.setAbertoEm(LocalDateTime.now());
        pedido.setStatus(StatusPedido.ABERTO);
        
        
        return pedidoRepository.save(pedido);
    }
    
    public void excluir(Long pedidoID) {
        pedidoRepository.deleteById(pedidoID);
    }
}
