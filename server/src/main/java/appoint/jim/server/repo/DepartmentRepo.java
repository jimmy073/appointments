package appoint.jim.server.repo;

import appoint.jim.server.entities.Appointment;
import appoint.jim.server.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department, Integer> {
}
