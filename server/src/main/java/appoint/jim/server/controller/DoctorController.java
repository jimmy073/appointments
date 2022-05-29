package appoint.jim.server.controller;

import appoint.jim.server.entities.Doctor;
import appoint.jim.server.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
@CrossOrigin(origins = "*")
public class DoctorController {
    @Autowired protected DoctorService doctorService;

    @GetMapping("")
    public List<Doctor> doctorsList(){
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public Doctor doctor(@PathVariable int id){
        return doctorService.findById(id);
    }

    @GetMapping("/department/{id}")
    public List<Doctor> doctorsListInDepartment(@PathVariable int id){
        return doctorService.getAllDoctorsInDepartment(id);
    }

    @PostMapping("/create/{id}")
    public Doctor create(@PathVariable int id, @RequestBody Doctor doctor){
       return doctorService.create(doctor, id);
    }
}
