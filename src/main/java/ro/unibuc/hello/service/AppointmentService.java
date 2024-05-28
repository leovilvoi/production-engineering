package ro.unibuc.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.unibuc.hello.data.entity.Appointment;
import ro.unibuc.hello.data.repository.AppointmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    
    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAllAppointments(){
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointmentById(String id){
        return appointmentRepository.findById(id);
    }

    public Appointment createAppointment(Appointment appointment){
        return appointmentRepository.save(appointment);
    }

    public Appointment updateAppointment(String id, Appointment appointment){
        appointment.setId(id);
        return appointmentRepository.save(appointment);
    }

    public void deleteAppointment(String id){
        appointmentRepository.deleteById(id);
    }

    public List<Appointment> findAppointmentsByDoctorId(String doctorId){
        return appointmentRepository.findByDoctorId(doctorId);
    }

    public List<Appointment> findAppointmentsByPatientId(String patientId){
        return appointmentRepository.findByPatientId(patientId);
    }
}
