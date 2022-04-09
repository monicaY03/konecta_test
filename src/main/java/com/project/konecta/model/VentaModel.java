package com.project.konecta.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="ventas")
public class VentaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "inventario_id")
    @JsonIgnore
    private InventarioModel inventario;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(nullable = false)
    private Integer Total;

    @Column(columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
    private String fecha_registro;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public InventarioModel getInventario() {
        return inventario;
    }

    public void setInventario(InventarioModel inventario) {
        this.inventario = inventario;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getTotal() {
        return Total;
    }

    public void setTotal(Integer total) {
        Total = total;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
}
