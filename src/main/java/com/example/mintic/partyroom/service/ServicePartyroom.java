package com.example.mintic.partyroom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mintic.partyroom.model.Partyroom;
import com.example.mintic.partyroom.repository.RepositoryPartyroom;

@Service
public class ServicePartyroom {
    
    @Autowired
    private RepositoryPartyroom repositoryPartyroom;

    
    public List<Partyroom> getAll() {
        return repositoryPartyroom.getAll();
    }

    public Optional<Partyroom> getPartyroom(int id) {
        return repositoryPartyroom.getPartyroom(id);
    }

    public Partyroom save(Partyroom partyroom) {
        if (partyroom.getId() == null) {
            return repositoryPartyroom.save(partyroom);
        } else {
            Optional<Partyroom> partyroom1 = repositoryPartyroom.getPartyroom(partyroom.getId());
            if (partyroom1.isEmpty()) {
                return repositoryPartyroom.save(partyroom);
            } else {
                return partyroom;
            }
        }
    }

    public Partyroom update(Partyroom partyroom) {
        if (partyroom.getId() !=null){
            Optional<Partyroom> e= repositoryPartyroom.getPartyroom(partyroom.getId());
            if(!e.isEmpty()){
                if (partyroom.getName ( ) !=null) {
                    e.get ( ) .setName (partyroom.getName());
                }
                if (partyroom.getOwner () !=null) {
                    e.get () .setOwner (partyroom.getOwner());
                }
                if (partyroom.getCapacity () !=null) {
                    e.get () .setCapacity (partyroom.getCapacity());
                }
                if (partyroom.getDescription () !=null) {
                    e.get () .setDescription (partyroom.getDescription());
                }
                repositoryPartyroom.save(e.get());
                return e.get();
                }
                else{
                    return partyroom;
                }
            }else{
                return partyroom;
            }
        }


    public boolean deletePartyroom(int id){
        boolean d = getPartyroom(id).map(partyroom -> {
            repositoryPartyroom.delete(partyroom);
            return true;
        }).orElse(false);
        return d;
    }
}
