package ro.unibuc.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.unibuc.hello.data.entity.Clinic;
import ro.unibuc.hello.data.repository.ClinicRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicService {
    
    @Autowired
    private ClinicRepository clinicRepository;

    public List<Clinic> getAllClinics(){
        return clinicRepository.findAll();
    }

    public Optional<Clinic> getClinicById(String id){
        return clinicRepository.findById(id);
    }

    public Clinic createClinic(Clinic clinic){
        return clinicRepository.save(clinic);
    }

    public Clinic updateClinic(String id, Clinic clinic){
        clinic.setId(id);
        return clinicRepository.save(clinic);
    }

    public void deleteClinic(String id){
        clinicRepository.deleteById(id);
    }

    public List<Clinic> findClinicsByName(String name){
        return clinicRepository.findByName(name);
    }
}
