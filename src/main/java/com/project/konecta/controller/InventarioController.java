package com.project.konecta.controller;

import com.project.konecta.model.InventarioModel;
import com.project.konecta.model.VentaModel;
import com.project.konecta.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("inventario")
public class InventarioController {

    @Autowired
    InventarioService service;

    @GetMapping("/consultaTodo")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PostMapping("guardar")
    public ResponseEntity<?> save(@RequestBody InventarioModel inventario) {
        return new ResponseEntity<>(service.save(inventario), HttpStatus.OK);
    }

    @PutMapping("actualizar")
    public ResponseEntity<?> update(@RequestBody InventarioModel inventario) {
        return new ResponseEntity<>(service.update(inventario), HttpStatus.OK);
    }

    @GetMapping("consultar/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("eliminarProducto/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>("Producto eliminado", HttpStatus.OK);
    }
    @PostMapping("venta")
    public ResponseEntity<?> venta(@RequestBody InventarioModel inventario) {
        InventarioModel inventarioNew = service.findById(inventario.getId());
        VentaModel venta = new VentaModel();
        Integer cantidad =inventario.getStock();
        venta.setTotal(cantidad*inventarioNew.getPrecio());
        inventarioNew.setStock(inventarioNew.getStock()-inventario.getStock());
        venta.setInventario(inventarioNew);
        venta.setCantidad(cantidad);
        service.venderProducto(venta);
        service.save(inventarioNew);

        return new ResponseEntity<>("Registro Exitoso", HttpStatus.OK);
    }

}
