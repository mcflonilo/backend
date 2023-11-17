package com.example.eksamenprep.appointment;

import com.example.eksamenprep.service.AppointmentService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AppointmentServiceIntegrationTest {
    @Autowired
    private AppointmentService appointmentService;

    @Test
    @Transactional
    void shouldFetchAllAppointments() {
        var appointments = appointmentService.getAppointments();
        assert appointments.size() == 1;
        assert appointments.get(0).getAppointmentId() == 1;
    }

}

