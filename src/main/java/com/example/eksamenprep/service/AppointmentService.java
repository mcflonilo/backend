package com.example.eksamenprep.service;

import com.example.eksamenprep.Appointment;
import com.example.eksamenprep.Repo.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AppointmentService {
    private final AppointmentRepo appointmentRepo;

    @Autowired
    public AppointmentService(AppointmentRepo appointmentRepo) {
        this.appointmentRepo = appointmentRepo;
    }

    public List<Appointment> getAppointments(){
        return appointmentRepo.findAll();
    }

    public Appointment getAppointmentById(Long id){
        return appointmentRepo.findById(id).orElse(null);
    }

    public Appointment createAppointment(Appointment appointment){
        return appointmentRepo.save(appointment);
    }
}
