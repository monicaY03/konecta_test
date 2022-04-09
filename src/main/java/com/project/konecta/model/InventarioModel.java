package com.project.konecta.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "inventario")
public class InventarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 20)
    private String nombre_producto;
    @Column(nullable = false, length = 25)
    private String referencia;
    @Column(nullable = false)
    private Integer precio;
    @Column(nullable = false)
    private Integer peso;
    @Column(nullable = false, length = 30)
    private String categoria;
    @Column(nullable = false)
    private Integer stock;

    @OneToMany(mappedBy = "inventario", cascade = CascadeType.ALL)
    private List<VentaModel> venta;


    @Column(columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
    private String fecha_creacion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public List<InventarioModel> registrosPorDefecto() {
        List<InventarioModel> model = new ArrayList<>();
        InventarioModel inventario1 = new InventarioModel();
        inventario1.setId(1);
        inventario1.setNombre_producto("Gaseosa");
        inventario1.setCategoria("Bebida");
        inventario1.setPrecio(3000);
        inventario1.setStock(500);
        inventario1.setPeso(1000);
        inventario1.setReferencia("Pepsi");
        InventarioModel inventario2 = new InventarioModel();
        inventario2.setId(2);
        inventario2.setNombre_producto("Dulce");
        inventario2.setCategoria("Golosinas");
        inventario2.setPrecio(500);
        inventario2.setStock(2000);
        inventario2.setPeso(20);
        inventario2.setReferencia("Bom Bom Bum");
        model.add(inventario1);
        model.add(inventario2);
        return model;
    }
}
