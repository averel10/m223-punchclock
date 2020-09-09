package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Department;
import ch.zli.m223.punchclock.domain.Department;
import ch.zli.m223.punchclock.exceptions.EntryNotFoundException;
import ch.zli.m223.punchclock.repository.DepartmentRepository;
import ch.zli.m223.punchclock.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department createDepartment(Department department) {
        return departmentRepository.saveAndFlush(department);
    }

    public Department updateDepartment(Department department) {
        if(departmentRepository.findById(department.getId()).isPresent()) {
            return departmentRepository.saveAndFlush(department);
        }
        throw new EntryNotFoundException();
    }
}
