package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Students;
import com.example.demo.repository.Studentsrepository;

@Service
public class Studentsservices {
    @Autowired
    Studentsrepository repo;
    public Students insertion(Students S) {
    	return repo.save(S);
    }
    public Iterable<Students> addstuStudents(List<Students> s) {
    	return repo.saveAll(s);
    }
    public List<Students> getAll(){
    	return (List<Students>) repo.findAll();
    }
    
    //get operations
    public Optional<Students> getbyId(int id) {
    	return repo.findById(id);
    }
    public Students getbyEmail(String email) {
    	return repo.findByEmail(email);
    }
    
    
    public String deletebyId(int id) {
    	repo.deleteById(id);
    	return "Successfully Deleted" + id;
    }
    
    //update
    public Students updateAll(Students std) {
    	int id = std.getId();
    	Students stdt = repo.findById(id).get();
    	stdt.setId(std.getId());
    	stdt.setName(std.getName());
    	stdt.setEmail(std.getEmail());
    	stdt.setPassword(std.getPassword());
    	return repo.save(std);
    }
    
    
	
}
