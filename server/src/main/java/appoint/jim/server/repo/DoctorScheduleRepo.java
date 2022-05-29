package appoint.jim.server.repo;

import appoint.jim.server.entities.Appointment;
import appoint.jim.server.entities.Doctor;
import appoint.jim.server.entities.DoctorSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorScheduleRepo extends JpaRepository<DoctorSchedule, Integer> {
    List<DoctorSchedule> findByDoctor(Doctor doctor);

}
