package com.project.konecta.repository;

import com.project.konecta.model.InventarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInventarioRepository extends JpaRepository<InventarioModel,Integer> {
}
