package appoint.jim.server.controller;

import appoint.jim.server.entities.Department;
import appoint.jim.server.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@CrossOrigin(origins = "*")
public class DepartmentController {
    @Autowired protected DepartmentService departmentService;

    @GetMapping("")
    public List<Department> departmentList(){
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Department department(@PathVariable int id){
        return departmentService.findById(id);
    }

    @PostMapping("/create")
    public Department create(@RequestBody Department department){
        System.out.println(department);
        return departmentService.create(department);
    }
}
