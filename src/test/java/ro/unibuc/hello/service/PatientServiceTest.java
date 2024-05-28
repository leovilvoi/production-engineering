package ro.unibuc.hello.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ro.unibuc.hello.data.entity.Patient;
import ro.unibuc.hello.data.repository.PatientRepository;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class PatientServiceTest {
    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private PatientService patientService;

    private Patient patient;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        patient = new Patient("1", "Patient One", "123 Street", "1234567890", new Date(), "1");
    }

    @Test
    void testGetAllPatients(){
        when(patientRepository.findAll()).thenReturn(Arrays.asList(patient));
        List<Patient> patients = patientService.getAllPatients();
        assertEquals(1, patients.size());
        verify(patientRepository, times(1)).findAll();
    }

    @Test
    void testGetPatientById(){
        when(patientRepository.findById("1")).thenReturn(Optional.of(patient));
        Optional<Patient> foundPatient = patientService.getPatientById("1");
        assertTrue(foundPatient.isPresent());
        assertEquals(patient, foundPatient.get());
        verify(patientRepository, times(1)).findById("1");
    }

    @Test
    void testCreatePatient(){
        when(patientRepository.save(patient)).thenReturn(patient);
        Patient createdPatient = patientService.createPatient(patient);
        assertEquals(patient, createdPatient);
        verify(patientRepository, times(1)).save(patient);
    }

    @Test
    void testDeletePatient(){
        patientService.deletePatient("1");
        verify(patientRepository, times(1)).deleteById("1");
    }

    @Test
    void testFindPatientsByName(){
        when(patientRepository.findByName("Patient One")).thenReturn(Arrays.asList(patient));
        List<Patient> patients = patientService.findPatientsByName("Patient One");
        assertEquals(1, patients.size());
        verify(patientRepository, times(1)).findByName("Patient One");
    }
}
