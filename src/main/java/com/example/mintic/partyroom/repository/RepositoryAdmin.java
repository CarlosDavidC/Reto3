package com.example.mintic.partyroom.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.mintic.partyroom.repository.crud.CrudRepositoryAdmin;

@Repository
public class RepositoryAdmin {
    
    @Autowired
    private CrudRepositoryAdmin crudRepositoryAdmin;
}
