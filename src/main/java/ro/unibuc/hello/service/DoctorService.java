package ro.unibuc.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.unibuc.hello.data.entity.Doctor;
import ro.unibuc.hello.data.repository.DoctorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    
    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }

    public Optional<Doctor> getDoctorById(String id){
        return doctorRepository.findById(id);
    }

    public Doctor createDoctor(Doctor doctor){
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(String id, Doctor doctor){
        doctor.setId(id);
        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(String id){
        doctorRepository.deleteById(id);
    }

    public List<Doctor> findDoctorsByName(String name){
        return doctorRepository.findByDoctorName(name);
    }
}
