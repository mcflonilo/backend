package com.example.eksamenprep.appointment;

import com.example.eksamenprep.Model.Appointment;
import com.example.eksamenprep.Repo.AppointmentRepo;
import com.example.eksamenprep.service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class AppointmentServiceUnitTest {

    @MockBean
    private AppointmentRepo appointmentRepo;
    @Autowired
    private AppointmentService appointmentService;

    @Test
    void shouldFetchAllAppointments() {
        List<Appointment> appointmentList = List.of(
                new Appointment(),
                new Appointment(),
                new Appointment()
        );
        when(appointmentRepo.findAll()).thenReturn(appointmentList);
        var appointments = appointmentService.getAppointments();
        assert appointments.size() == appointmentList.size();
    }
}
