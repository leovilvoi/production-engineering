package ro.unibuc.hello.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ro.unibuc.hello.data.entity.Appointment;
import ro.unibuc.hello.data.repository.AppointmentRepository;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class AppointmentServiceTest{
    @Mock
    private AppointmentRepository appointmentRepository;

    @InjectMocks
    private AppointmentService appointmentService;

    private Appointment appointment;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        appointment = new Appointment("1", "1", "1", new Date(), "Check-up");
    }

    @Test
    void testGetAllAppointments(){
        when(appointmentRepository.findAll()).thenReturn(Arrays.asList(appointment));
        List<Appointment> appointments = appointmentService.getAllAppointments();
        assertEquals(1, appointments.size());
        verify(appointmentRepository, times(1)).findAll();
    }

    @Test
    void testGetAppointmentById(){
        when(appointmentRepository.findById("1")).thenReturn(Optional.of(appointment));
        Optional<Appointment> foundAppointment = appointmentService.getAppointmentById("1");
        assertTrue(foundAppointment.isPresent());
        assertEquals(appointment, foundAppointment.get());
        verify(appointmentRepository, times(1)).findById("1");
    }

    @Test
    void testCreateAppointment(){
        when(appointmentRepository.save(appointment)).thenReturn(appointment);
        Appointment createdAppointment = appointmentService.createAppointment(appointment);
        assertEquals(appointment, createdAppointment);
        verify(appointmentRepository, times(1)).save(appointment);
    }

    @Test
    void testDeleteAppointment(){
        appointmentService.deleteAppointment("1");
        verify(appointmentRepository, times(1)).deleteById("1");
    }

    @Test
    void testFindAppointmentsByDoctorId(){
        when(appointmentRepository.findByDoctorId("1")).thenReturn(Arrays.asList(appointment));
        List<Appointment> appointments = appointmentService.findAppointmentsByDoctorId("1");
        assertEquals(1, appointments.size());
        verify(appointmentRepository, times(1)).findByDoctorId("1");
    }
}
