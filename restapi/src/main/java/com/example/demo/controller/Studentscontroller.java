package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Students;
import com.example.demo.services.Studentsservices;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:4200")
public class Studentscontroller {
 @Autowired
 Studentsservices services;
 @PostMapping("/insertion")
 public Students insertion(@RequestBody Students S) {
	 return services.insertion(S);
 }
 @PostMapping("/adding")
  public Iterable<Students> addstudents(@RequestBody List<Students> s) {
	 return services.addstuStudents(s);
 }
 @GetMapping("/getall")
 public List<Students> getall(){
	 return services.getAll();
 }
 @GetMapping("/getbyId/{id}")
 public Optional<Students> getbyId(@PathVariable int id) {
	 return services.getbyId(id);
 }
 @GetMapping("/findbyEmail/{email}")
 public Students findByEmail(@PathVariable String email) {
	 return services.getbyEmail(email);
 }
 @DeleteMapping("/deletebyId/{id}")
 public String deletebyId(@PathVariable int id) {
	 return services.deletebyId(id);
 }
 @PutMapping("/update")
 public Students updateAll(@RequestBody Students std) {
	 return services.updateAll(std);
 }
}
