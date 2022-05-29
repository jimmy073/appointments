package appoint.jim.server.service;

import appoint.jim.server.entities.Department;
import appoint.jim.server.entities.Doctor;
import appoint.jim.server.repo.DepartmentRepo;
import appoint.jim.server.repo.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {
    @Autowired protected DoctorRepo doctorRepo;
    @Autowired protected DepartmentService departmentService;

    public Doctor create(Doctor doctor, int deptId){
        Department department = departmentService.findById(deptId);
        if(department !=null){
            doctor.setDepartment(department);
            return doctorRepo.save(doctor);
        }
        return new Doctor();
    }

    public List<Doctor> getAllDoctors(){
        return doctorRepo.findAll();
    }

    public List<Doctor> getAllDoctorsInDepartment(int id){
        Department department = departmentService.findById(id);
        if(department!=null){
            return doctorRepo.findByDepartment(department);
        }else{
            return new ArrayList<>();
        }

    }

    public Doctor findById(int id){
        return doctorRepo.findById(id).orElse(null);
    }
}
