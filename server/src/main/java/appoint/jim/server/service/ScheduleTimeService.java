package appoint.jim.server.service;

import appoint.jim.server.entities.Doctor;
import appoint.jim.server.entities.DoctorSchedule;
import appoint.jim.server.entities.ScheduleTime;
import appoint.jim.server.enums.GenericStatus;
import appoint.jim.server.repo.ScheduleTimeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleTimeService {
    @Autowired protected ScheduleTimeRepo scheduleTimeRepo;

    public void create(ScheduleTime scheduleTime){
         scheduleTimeRepo.save(scheduleTime);
    }

    public void update(ScheduleTime scheduleTime){
        scheduleTimeRepo.save(scheduleTime);
    }

    public List<ScheduleTime> doctorSchedulesTime(DoctorSchedule schedule){
        return scheduleTimeRepo.findByDoctorSchedule(schedule);
    }

    public List<ScheduleTime> AvailableDoctorSchedulesTime(DoctorSchedule schedule){
        return scheduleTimeRepo.findByDoctorScheduleAndStatus(schedule, GenericStatus.AVAILABLE);
    }

    public ScheduleTime findById(int id){
        return scheduleTimeRepo.findById(id).orElse(null);
    }
}
