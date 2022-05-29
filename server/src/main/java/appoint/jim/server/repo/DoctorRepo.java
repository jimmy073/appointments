package appoint.jim.server.repo;

import appoint.jim.server.entities.Appointment;
import appoint.jim.server.entities.Department;
import appoint.jim.server.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepo extends JpaRepository<Doctor, Integer> {
    List<Doctor> findByDepartment(Department department);

}
