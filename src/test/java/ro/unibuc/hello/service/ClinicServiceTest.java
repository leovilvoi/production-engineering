package ro.unibuc.hello.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ro.unibuc.hello.data.entity.Clinic;
import ro.unibuc.hello.data.repository.ClinicRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class ClinicServiceTest{
    
    @Mock
    private ClinicRepository clinicRepository;

    @InjectMocks
    private ClinicService clinicService;

    private Clinic clinic;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        clinic = new Clinic("1", "Clinic One", "123 Street", "1234567890");
    }

    @Test
    void testGetAllClinics(){
        when(clinicRepository.findAll()).thenReturn(Arrays.asList(clinic));
        List<Clinic> clinics = clinicService.getAllClinics();
        assertEquals(1, clinics.size());
        verify(clinicRepository, times(1)).findAll();
    }

    @Test
    void testGetClinicById(){
        when(clinicRepository.findById("1")).thenReturn(Optional.of(clinic));
        Optional<Clinic> foundClinic = clinicService.getClinicById("1");
        assertTrue(foundClinic.isPresent());
        assertEquals(clinic, foundClinic.get());
        verify(clinicRepository, times(1)).findById("1");
    }

    @Test
    void testCreateClinic(){
        when(clinicRepository.save(clinic)).thenReturn(clinic);
        Clinic createdClinic = clinicService.createClinic(clinic);
        assertEquals(clinic, createdClinic);
        verify(clinicRepository, times(1)).save(clinic);
    }

    @Test
    void testDeleteClinic(){
        clinicService.deleteClinic("1");
        verify(clinicRepository, times(1)).deleteById("1");
    }

    @Test
    void testFindClinicsByName(){
        when(clinicRepository.findByName("Clinic One")).thenReturn(Arrays.asList(clinic));
        List<Clinic> clinics = clinicService.findClinicsByName("Clinic One");
        assertEquals(1, clinics.size());
        verify(clinicRepository, times(1)).findByName("Clinic One");
    }
}
