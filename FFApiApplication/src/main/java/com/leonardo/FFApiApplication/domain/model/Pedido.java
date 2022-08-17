/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leonardo.FFApiApplication.domain.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

/**
 *
 * @author devsys-b
 */
@Entity
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    
    @Enumerated(EnumType.STRING)
    private StatusPedido status;
    
    private LocalDateTime abertoEm;
    private LocalDateTime fechadoEm;
    private String obs;
    
    private Item item;

    public Pedido() {
    }

    public Pedido(long id, Cliente cliente, StatusPedido status, LocalDateTime dataHoraPedido, LocalDateTime dataHoraEntrega, String observacao, Item item) {
        this.id = id;
        this.cliente = cliente;
        this.status = status;
        this.abertoEm = dataHoraPedido;
        this.fechadoEm = dataHoraEntrega;
        this.obs = observacao;
        this.item = item;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public LocalDateTime getAbertoEm() {
        return abertoEm;
    }

    public void setAbertoEm(LocalDateTime abertoEm) {
        this.abertoEm = abertoEm;
    }

    public LocalDateTime getFechadoEm() {
        return fechadoEm;
    }

    public void setFechadoEm(LocalDateTime fechadoEm) {
        this.fechadoEm = fechadoEm;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
        public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
    
    
    
}
