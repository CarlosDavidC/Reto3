package com.example.mintic.partyroom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mintic.partyroom.model.Message;
import com.example.mintic.partyroom.repository.RepositoryMessage;

@Service
public class ServiceMessage {

    @Autowired
    private RepositoryMessage repositoryMessage;

    
    public List<Message> getAll() {
        return repositoryMessage.getAll();
    }

    public Optional<Message> getMessage(int id) {
        return repositoryMessage.getMessage(id);
    }

    public Message save(Message message) {
        if (message.getIdMessage() == null) {
            return repositoryMessage.save(message);
        } else {
            Optional<Message> message1 = repositoryMessage.getMessage(message.getIdMessage());
            if (message1.isEmpty()) {
                return repositoryMessage.save(message);
            } else {
                return message;
            }
        }
    }

    public Message update(Message message) {
        if (message.getIdMessage() !=null){
            Optional<Message> e= repositoryMessage.getMessage (message.getIdMessage());
            if(!e.isEmpty()){
                if (message.getMessageText ( ) !=null) {
                    e.get ( ) .setMessageText(message.getMessageText());
                    }
                    repositoryMessage.save(e.get());
                    return e.get();
                }else{
                    return message;
                }
            }else{
                return message;
            }
        }

    public boolean deleteMessage(int id){
        boolean d = getMessage(id).map(message -> {
            repositoryMessage.delete(message);
            return true;
        }).orElse(false);
        return d;
    }
}
