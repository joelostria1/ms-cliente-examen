package com.examen.ms.apiclients.repositories;

import com.examen.ms.apiclients.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    Optional<ClientEntity> findByNombre(String nombre);
}
