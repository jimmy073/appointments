package appoint.jim.server.service;

import appoint.jim.server.entities.Doctor;
import appoint.jim.server.entities.DoctorSchedule;
import appoint.jim.server.entities.ScheduleTime;
import appoint.jim.server.enums.GenericStatus;
import appoint.jim.server.repo.DoctorScheduleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Service
public class DoctorScheduleService {
    @Autowired protected DoctorScheduleRepo scheduleRepo;
    @Autowired protected DoctorService doctorService;
    @Autowired protected ScheduleTimeService scheduleTimeService;

    public List<DoctorSchedule> getAllSchedules(){
       return scheduleRepo.findAll();
    }

    public List<DoctorSchedule> getDoctorSchedules(int id){
        Doctor doctor = doctorService.findById(id);
        if(doctor!=null){
            return scheduleRepo.findByDoctor(doctor);
        }
        return new ArrayList<>();
    }

    public DoctorSchedule create(int doctorId, DoctorSchedule schedule){
        Doctor doctor = doctorService.findById(doctorId);
        if(doctor!=null){
            schedule.setDoctor(doctor);
            LocalDate date = LocalDate.parse(schedule.getScheduleDate()+"");
            schedule.setScheduleDate(date);
            DoctorSchedule newSchedule = scheduleRepo.save(schedule);
            // Adding schedules time hours on a scheduled date (every day supposed to have 8 hours)
            for(int i=0; i<8; i++){
                ScheduleTime time= new ScheduleTime();
                time.setDoctorSchedule(newSchedule);
                time.setStatus(GenericStatus.AVAILABLE);
                if(i<4){
                    time.setStartFrom(""+(i+8)+"H:00 A.M");
                    time.setEndFrom(""+(i+9)+"H:00 A.M");
                }else{
                    time.setStartFrom(""+(i-3)+"H:00 P.M");
                    time.setEndFrom(""+(i-2)+"H:00 P.M");
                }
                time.setStatus(GenericStatus.AVAILABLE);
            scheduleTimeService.create(time);
            }
            return scheduleRepo.save(newSchedule); //scheduleRepo.save(schedule);
        }
        return new DoctorSchedule();
    }

    public Set<ScheduleTime> getDoctorSchedulesTime(int id){
        DoctorSchedule schedule = scheduleRepo.findById(id).orElse(null);
        if(schedule!=null){
            return schedule.getScheduleHour();
        }
        return null;
    }

}
