package com.example.mintic.partyroom.repository.crud;
import org.springframework.data.repository.CrudRepository;
import com.example.mintic.partyroom.model.Reservation;

public interface CrudRepositoryReservation  extends CrudRepository<Reservation,Integer>{
    
}
