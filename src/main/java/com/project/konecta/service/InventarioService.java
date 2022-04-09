package com.project.konecta.service;

import com.project.konecta.model.InventarioModel;
import com.project.konecta.model.VentaModel;
import com.project.konecta.repository.IGenericoCrud;
import com.project.konecta.repository.IInventarioRepository;
import com.project.konecta.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioService implements IGenericoCrud<InventarioModel> {

    @Autowired IInventarioRepository repository;
    @Autowired IVentaRepository ventaRepository;

    @Override
    public List<InventarioModel> findAll() {
        return repository.findAll();
    }

    @Override
    public InventarioModel save(InventarioModel entity) {
        return repository.save(entity);
    }

    @Override
    public InventarioModel update(InventarioModel entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public InventarioModel findById(Integer id) {
        return repository.findById(id).get();
    }

    public VentaModel venderProducto(VentaModel entity) {
        return ventaRepository.save(entity);
    }

    public List<VentaModel> findAllVentas() {
        return ventaRepository.findAll();
    }

}
