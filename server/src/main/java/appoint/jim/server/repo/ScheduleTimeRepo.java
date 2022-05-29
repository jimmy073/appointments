package appoint.jim.server.repo;

import appoint.jim.server.entities.Appointment;
import appoint.jim.server.entities.DoctorSchedule;
import appoint.jim.server.entities.ScheduleTime;
import appoint.jim.server.enums.GenericStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleTimeRepo extends JpaRepository<ScheduleTime, Integer> {
    List<ScheduleTime> findByDoctorSchedule(DoctorSchedule schedule);
    List<ScheduleTime> findByDoctorScheduleAndStatus(DoctorSchedule schedule, GenericStatus status);
}
