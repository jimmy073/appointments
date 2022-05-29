package appoint.jim.server.controller;

import appoint.jim.server.entities.Appointment;
import appoint.jim.server.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
@CrossOrigin(origins = "*")
public class AppointmentController {
    @Autowired protected
    AppointmentService appointmentService;

    @GetMapping("")
    public List<Appointment> getAllAppointments(){
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/doctor/{id}")
    public List<Appointment> geDoctorAppointments(@PathVariable int id){
        return appointmentService.getDoctorAppointments(id);
    }

    @GetMapping("/patient/{id}")
    public List<Appointment> getPatientAppointments(@PathVariable int id){
        return appointmentService.getPatientAppointments(id);
    }

    @PostMapping("/make-appointment/{patientId}/{timeId}")
    public Appointment makeAppointment(@PathVariable int patientId, @PathVariable int timeId){
            return appointmentService.makeAppointment(patientId, timeId);
    }
}
