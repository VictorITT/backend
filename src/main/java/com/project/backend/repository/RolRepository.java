package com.project.backend.repository;


import com.project.backend.model.Rol;
import com.project.backend.security.enums.NameRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByNameRol(NameRol nameRol);
}

