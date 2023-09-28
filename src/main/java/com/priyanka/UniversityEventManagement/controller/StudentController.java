package com.priyanka.UniversityEventManagement.controller;

import com.priyanka.UniversityEventManagement.model.Department;
import com.priyanka.UniversityEventManagement.model.Student;
import com.priyanka.UniversityEventManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("student")//Add Student
    public String addAStudent(@RequestBody Student student)
    {
        return studentService.addAStudent(student);
    }
    @PostMapping("students")//Add Multiple students
    public String addStudents(@RequestBody List<Student> student)
    {
        return studentService.addStudents(student);
    }

    @GetMapping("students")//get all students
    public Iterable<Student> getAllStudents()
    {
        return studentService.getAllStudents();
    }

    @GetMapping("student/{id}")//get by id
    public Optional<Student> getStudentById(@PathVariable Integer id)
    {
        return studentService.getStudentById(id);
    }

    @PutMapping("student/{id}/{department}")//get student by id or department
    public String updateStudentDepartment(@PathVariable Integer id, @PathVariable Department department)
    {
        return  studentService.updateStudentDepartment(id,department);
    }
    @DeleteMapping("student/{id}")//delete student by id
    public String removeStudentById(@PathVariable Integer id)
    {
        return  studentService.removeStudentById(id);
    }
}

