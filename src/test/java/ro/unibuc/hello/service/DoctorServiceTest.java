package ro.unibuc.hello.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ro.unibuc.hello.data.entity.Doctor;
import ro.unibuc.hello.data.repository.DoctorRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class DoctorServiceTest{
    @Mock
    private DoctorRepository doctorRepository;

    @InjectMocks
    private DoctorService doctorService;

    private Doctor doctor;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        doctor = new Doctor("1", "Doctor One", "Cardiology", "1234567890", "doctor@example.com", "1");
    }

    @Test
    void testGetAllDoctors(){
        when(doctorRepository.findAll()).thenReturn(Arrays.asList(doctor));
        List<Doctor> doctors = doctorService.getAllDoctors();
        assertEquals(1, doctors.size());
        verify(doctorRepository, times(1)).findAll();
    }

    @Test
    void testGetDoctorById(){
        when(doctorRepository.findById("1")).thenReturn(Optional.of(doctor));
        Optional<Doctor> foundDoctor = doctorService.getDoctorById("1");
        assertTrue(foundDoctor.isPresent());
        assertEquals(doctor, foundDoctor.get());
        verify(doctorRepository, times(1)).findById("1");
    }

    @Test
    void testCreateDoctor(){
        when(doctorRepository.save(doctor)).thenReturn(doctor);
        Doctor createdDoctor = doctorService.createDoctor(doctor);
        assertEquals(doctor, createdDoctor);
        verify(doctorRepository, times(1)).save(doctor);
    }

    @Test
    void testDeleteDoctor(){
        doctorService.deleteDoctor("1");
        verify(doctorRepository, times(1)).deleteById("1");
    }

    @Test
    void testFindByDoctorName(){
        when(doctorRepository.findByDoctorName("Doctor One")).thenReturn(Arrays.asList(doctor));
        List<Doctor> doctors = doctorService.findDoctorsByName("Doctor One");
        assertEquals(1, doctors.size());
        verify(doctorRepository, times(1)).findByDoctorName("Doctor One");
    }
}