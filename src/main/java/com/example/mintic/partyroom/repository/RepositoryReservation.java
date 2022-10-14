package com.example.mintic.partyroom.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.mintic.partyroom.model.Reservation;
import com.example.mintic.partyroom.repository.crud.CrudRepositoryReservation;

@Repository
public class RepositoryReservation {
    
    @Autowired
    private CrudRepositoryReservation crudRepositoryReservation;

    
    public List<Reservation> getAll(){
        return (List<Reservation>) crudRepositoryReservation.findAll();
    }
    public Optional<Reservation> getReservation(int id){
        return crudRepositoryReservation.findById(id);
    }
    
    public Reservation save(Reservation reservation){
        return crudRepositoryReservation.save(reservation);
    }

    public void delete(Reservation reservation){
        crudRepositoryReservation.delete(reservation);
    }




    public List<Reservation> ReservacionStatus(String status){
        return crudRepositoryReservation.findAllByStatus(status);
    }

    public List<Reservation> ReservacionTiempo(java.util.Date fechaUno, java.util.Date fechaDos){
        return crudRepositoryReservation.findAllByStartDateAfterAndStartDateBefore(fechaUno, fechaDos);
    }

       
    public   List<Object[]> reporteClientes() {
        return crudRepositoryReservation.reporteClientes();

    }
}
