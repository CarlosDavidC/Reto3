package com.example.mintic.partyroom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mintic.partyroom.repository.RepositoryScore;

@Service
public class ServiceScore {
    
    @Autowired
    private RepositoryScore repositoryScore;
}
