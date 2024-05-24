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
import ro.unibuc.hello.data.repository.ClinicRepository;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/clinics")
public class ClinicController {

    @Autowired 
    private ClinicRepository clinicRepository;

    @GetMapping
    @ResponseBody
    public List<Clinic> getAllClinics(){
        return clinicRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Clinic> getClinicById(@PathVariable String id){
        return clinicRepository.findById(id);
    }

    @PostMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Clinic createClinic(@RequestBody Clinic clinic){
        return clinicRepository.save(clinic);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClinic(@PathVariable String id){
        clinicRepository.deleteById(id);
    }

    @GetMapping("/search")
    @ResponseBody
    public List<Clinic> findClinicsByName(@RequestParam String name){
        return clinicRepository.findByName(name);
    }

    // // get all the doctors in a clinic
    // @GetMapping("/{id}/doctors")
    // @ResponseBody
    // public List<Doctor> getClinicDoctors(@PathVariable String id){
    //     return doctorService.getDoctorsByClinicId(id);
    // }

}
