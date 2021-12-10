package com.project.backend.security.service;


import com.project.backend.model.Rol;
import com.project.backend.security.enums.NameRol;
import com.project.backend.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolNombre(NameRol nameRol){
        return rolRepository.findByNameRol(nameRol);
    }

    public void save(Rol rol){
        rolRepository.save(rol);
    }
}
