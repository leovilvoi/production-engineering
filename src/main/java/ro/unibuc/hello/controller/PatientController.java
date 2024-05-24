package ro.unibuc.hello.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ro.unibuc.hello.data.entity.*;
import ro.unibuc.hello.data.repository.PatientRepository;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/patients")
public class PatientController{

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping
    @ResponseBody
    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Patient> getPatientById(@PathVariable String id){
        return patientRepository.findById(id);
    }

    @PostMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Patient createPatient(@RequestBody Patient patient){
        return patientRepository.save(patient);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePatient(@PathVariable String id){
        patientRepository.deleteById(id);
    }

    @GetMapping("/search")
    @ResponseBody
    public List<Patient>  findPatientByName(@RequestParam String name){
        return patientRepository.findByName(name);
    }

}