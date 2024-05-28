package ro.unibuc.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.unibuc.hello.data.entity.Patient;
import ro.unibuc.hello.data.repository.PatientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService{
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientById(String id){
        return patientRepository.findById(id);
    }

    public Patient createPatient(Patient patient){
        return patientRepository.save(patient);
    }

    public void deletePatient(String id){
        patientRepository.deleteById(id);
    }

    public List<Patient> findPatientsByName(String name){
        return patientRepository.findByName(name);
    }
}
