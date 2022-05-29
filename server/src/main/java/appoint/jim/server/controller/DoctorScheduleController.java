package appoint.jim.server.controller;

import appoint.jim.server.entities.DoctorSchedule;
import appoint.jim.server.entities.ScheduleTime;
import appoint.jim.server.service.DoctorScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/schedules")
@CrossOrigin(origins = "*")
public class DoctorScheduleController {
    @Autowired protected DoctorScheduleService doctorScheduleService;

    @GetMapping("")
    public List<DoctorSchedule> scheduleList(){
        return doctorScheduleService.getAllSchedules();
    }

    @GetMapping("/{doctorId}")
    public List<DoctorSchedule> getDoctorSchedules(@PathVariable int doctorId){
        return doctorScheduleService.getDoctorSchedules(doctorId);
    }

    @PostMapping("/create/{doctorId}")
    public DoctorSchedule createSchedule(@PathVariable int doctorId, @RequestBody DoctorSchedule schedule){
        return doctorScheduleService.create(doctorId, schedule);
    }

    @GetMapping("/schedule-times/{scheduleId}")
    public Set<ScheduleTime> getDoctorScheduleTimes(@PathVariable int scheduleId){
        return doctorScheduleService.getDoctorSchedulesTime(scheduleId);
    }
}
