package appoint.jim.server.service;

import appoint.jim.server.entities.Department;
import appoint.jim.server.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired protected DepartmentRepo departmentRepo;

    public Department create(Department department){
        return  departmentRepo.save(department);
    }

    public List<Department> getAllDepartments(){
        return  departmentRepo.findAll();
    }

    public Department findById(int id){
        return  departmentRepo.findById(id).orElse(null);
    }
}
