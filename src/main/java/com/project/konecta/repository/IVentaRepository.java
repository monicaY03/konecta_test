package com.project.konecta.repository;

import com.project.konecta.model.VentaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository extends JpaRepository<VentaModel,Integer> {
}
