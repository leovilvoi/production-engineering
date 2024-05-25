package ro.unibuc.hello.data.entity;

import org.junit.jupiter.api.Test;
import ro.unibuc.hello.TestUtils;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentTest {

    @Test
    void testAppointment() {
        Date appointmentDate = new Date();
        Appointment appointment = TestUtils.buildTestAppointment("1", "1", "1", appointmentDate, "General Checkup");

        assertEquals("1", appointment.getId());
        assertEquals("1", appointment.getDoctorId());
        assertEquals("1", appointment.getPatientId());
        assertEquals(appointmentDate, appointment.getAppointmentDate());
        assertEquals("General Checkup", appointment.getDescription());
    }
}