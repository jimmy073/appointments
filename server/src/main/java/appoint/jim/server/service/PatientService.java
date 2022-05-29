package appoint.jim.server.service;

import appoint.jim.server.entities.Patient;
import appoint.jim.server.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired protected PatientRepo patientRepo;

    public Patient create(Patient patient){
        Patient patient1 = patientRepo.findByTelephone(patient.getTelephone());
        if(patient1!=null){
            return patient1;
        }
        return patientRepo.save(patient);
    }

    public List<Patient> getAllPatients(){
        return patientRepo.findAll();
    }

    public Patient findById(int id){
        return patientRepo.findById(id).orElse(null);
    }
}
