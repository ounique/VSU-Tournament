package com.vsu.project.service.services;

import com.vsu.project.service.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department addDepartment(Department department);
    void delete(long id);
    Department getById(long id);
    Department updateDepartment(Department department);
    List<Department> getAll();
}
