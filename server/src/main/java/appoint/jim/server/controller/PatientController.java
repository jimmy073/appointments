package appoint.jim.server.controller;

import appoint.jim.server.entities.Patient;
import appoint.jim.server.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@CrossOrigin(origins = "*")
public class PatientController {
    @Autowired
    protected PatientService patientService;

    @GetMapping("")
    public List<Patient> patientList(){
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public Patient patient(@PathVariable int id){
        return patientService.findById(id);
    }

    @PostMapping("/create")
    public Patient create(@RequestBody Patient patient){
        return patientService.create(patient);
    }

}
