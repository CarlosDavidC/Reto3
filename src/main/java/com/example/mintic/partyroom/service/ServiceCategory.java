package com.example.mintic.partyroom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mintic.partyroom.model.Category;
import com.example.mintic.partyroom.repository.RepositoryCategory;

@Service
public class ServiceCategory {
    
    @Autowired
    private RepositoryCategory repositoryCategory;

    
    public List<Category> getAll() {
        return repositoryCategory.getAll();
    }

    public Optional<Category> getCategory(int id) {
        return repositoryCategory.getCategory(id);
    }

    public Category save(Category category) {
        if (category.getId() == null) {
            return repositoryCategory.save(category);
        } else {
            Optional<Category> category1 = repositoryCategory.getCategory(category.getId());
            if (category1.isEmpty()) {
                return repositoryCategory.save(category);
            } else {
                return category;
            }
        }
    }

    public boolean deleteCategory(int id){
        boolean d = getCategory(id).map(category -> {
            repositoryCategory.delete(category);
            return true;
        }).orElse(false);
        return d;
    }
}
