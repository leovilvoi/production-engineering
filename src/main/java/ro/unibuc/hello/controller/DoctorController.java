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
import ro.unibuc.hello.data.repository.DoctorRepository;
import java.util.List;


@Controller
@RequestMapping("/doctors")
public class DoctorController{

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping
    @ResponseBody
    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public List<Doctor> getDoctorById(@PathVariable String id){
        return doctorRepository.findByClinicId(id);
    }

    @PostMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor createDoctor(@RequestBody Doctor doctor){
        return doctorRepository.save(doctor);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDoctor(@PathVariable String id){
        doctorRepository.deleteById(id);
    }

    @GetMapping("/search")
    @ResponseBody
    public List<Doctor> findDoctorsByName(@RequestParam String name){
        return doctorRepository.findByDoctorName(name);
    }

}