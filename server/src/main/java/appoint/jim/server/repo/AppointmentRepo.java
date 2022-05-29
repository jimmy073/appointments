package appoint.jim.server.repo;

import appoint.jim.server.entities.Appointment;
import appoint.jim.server.entities.Doctor;
import appoint.jim.server.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {
    List<Appointment> findByPatient(Patient patient);
    List<Appointment> findByDoctor(Doctor doctor);
}
