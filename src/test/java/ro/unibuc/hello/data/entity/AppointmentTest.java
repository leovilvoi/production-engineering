package ro.unibuc.hello.data.entity;

import org.junit.jupiter.api.Test;
import ro.unibuc.hello.TestUtils;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentTest {

    @Test
    void testAppointment() {
        Date now = new Date();
        Appointment appointment = TestUtils.buildTestAppointment("1", "1", "1", now, "General Checkup");

        assertEquals("1", appointment.getId());
        assertEquals("1", appointment.getDoctorId());
        assertEquals("1", appointment.getPatientId());
        assertEquals(now, appointment.getAppointmentDate());
        assertEquals("General Checkup", appointment.getDescription());
    }

    @Test
    void testEqualsAndHashCode() {
        Date now = new Date();
        Appointment appointment1 = TestUtils.buildTestAppointment("1", "1", "1", now, "Check-up");
        Appointment appointment2 = TestUtils.buildTestAppointment("1", "1", "1", now, "Check-up");

        assertEquals(appointment1, appointment2);
        assertEquals(appointment1.hashCode(), appointment2.hashCode());
    }

    @Test
    void testNoArgsConstructor() {
        Appointment appointment = new Appointment();
        Date now = new Date();
        appointment.setId("1");
        appointment.setDoctorId("1");
        appointment.setPatientId("1");
        appointment.setAppointmentDate(now);
        appointment.setDescription("Check-up");

        assertEquals("1", appointment.getId());
        assertEquals("1", appointment.getDoctorId());
        assertEquals("1", appointment.getPatientId());
        assertEquals(now, appointment.getAppointmentDate());
        assertEquals("Check-up", appointment.getDescription());
    }

    @Test
    void testAllArgsConstructor() {
        Date now = new Date();
        Appointment appointment = new Appointment("1", "1", "1", now, "Check-up");

        assertEquals("1", appointment.getId());
        assertEquals("1", appointment.getDoctorId());
        assertEquals("1", appointment.getPatientId());
        assertEquals(now, appointment.getAppointmentDate());
        assertEquals("Check-up", appointment.getDescription());
    }

    @Test
    void testBuilder() {
        Date now = new Date();
        Appointment appointment = Appointment.builder()
                .id("1")
                .doctorId("1")
                .patientId("1")
                .appointmentDate(now)
                .description("Check-up")
                .build();

        assertEquals("1", appointment.getId());
        assertEquals("1", appointment.getDoctorId());
        assertEquals("1", appointment.getPatientId());
        assertEquals(now, appointment.getAppointmentDate());
        assertEquals("Check-up", appointment.getDescription());
    }
}