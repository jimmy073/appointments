package appoint.jim.server.service;

import appoint.jim.server.entities.Appointment;
import appoint.jim.server.entities.Doctor;
import appoint.jim.server.entities.Patient;
import appoint.jim.server.entities.ScheduleTime;
import appoint.jim.server.enums.GenericStatus;
import appoint.jim.server.repo.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService {
    @Autowired protected AppointmentRepo appointmentRepo;
    @Autowired protected PatientService patientService;
    @Autowired protected ScheduleTimeService scheduleTimeService;
    @Autowired protected DoctorService doctorService;

    public Appointment makeAppointment(int patientId, int scheduleTimeId){
        Patient patient = patientService.findById(patientId);
        ScheduleTime scheduleTime = scheduleTimeService.findById(scheduleTimeId);
        if(patient !=null && scheduleTime !=null){
            if(scheduleTime.getStatus().equals(GenericStatus.AVAILABLE)){
                    Appointment appointment = new Appointment();
                    appointment.setPatient(patient);
                    appointment.setDoctor(scheduleTime.getDoctorSchedule().getDoctor());
                    // appointment.setStatus();
                    appointment.setScheduledTime(scheduleTime);
                    appointment.setDateRequested(LocalDate.now());
                    Appointment appointment1 = appointmentRepo.save(appointment);
                    scheduleTime.setStatus(GenericStatus.BOOKED);
                    scheduleTimeService.update(scheduleTime);
                    return appointment1;
            }
        }
        return new Appointment();
    }

    public List<Appointment> getAllAppointments(){
        return appointmentRepo.findAll();
    }

    public List<Appointment> getPatientAppointments(int patientId){
        Patient patient = patientService.findById(patientId);
        if(patient!=null){
            return appointmentRepo.findByPatient(patient);
        }
        return new ArrayList<>();
    }

    public List<Appointment> getDoctorAppointments(int doctorId){
        Doctor doctor = doctorService.findById(doctorId);
        if(doctor!=null){
            return appointmentRepo.findByDoctor(doctor);
        }
        return new ArrayList<>();
    }
}
