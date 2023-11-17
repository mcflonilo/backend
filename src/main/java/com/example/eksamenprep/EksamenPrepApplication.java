package com.example.eksamenprep;

import com.example.eksamenprep.Model.*;
import com.example.eksamenprep.Repo.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class EksamenPrepApplication {

	public static void main(String[] args) {
		SpringApplication.run(EksamenPrepApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(
			PetRepo petRepo,
			CustomerRepo customerRepo,
			VetRepo vetRepo,
			RoomRepo roomRepo,
			AppointmentRepo appointmentRepo
			) {

		return args -> {
			Customer customer = customerRepo.save(new Customer("larsern", "lm.opheim39@gmail.com"));
			Pet pet = petRepo.save(new Pet("mbappe", "turtle"));
			customer.getPets().add(pet);
			customerRepo.save(customer);
			Vet vet = vetRepo.save(new Vet("cum johnson"));
			Room room = roomRepo.save(new Room("exam room 1"));
			Appointment appointment = new Appointment(LocalDateTime.now(), 1L);
			appointment.setRoom(room);
			appointment.setVet(vet);
			appointment.setPet(pet);
			appointmentRepo.save(appointment);
		};
	}

}
