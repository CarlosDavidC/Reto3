package com.example.mintic.partyroom.repository.crud;

import org.springframework.data.repository.CrudRepository;
import com.example.mintic.partyroom.model.Score;

public interface CrudRepositoryScore extends CrudRepository<Score,Integer> {
    
}
