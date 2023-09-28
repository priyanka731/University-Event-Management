package com.priyanka.UniversityEventManagement.service;

import com.priyanka.UniversityEventManagement.model.Department;
import com.priyanka.UniversityEventManagement.model.Student;
import com.priyanka.UniversityEventManagement.repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    IStudentRepo studentRepo;
    public String addAStudent(Student student) {
        studentRepo.save(student);

        return "Student added !!!";
    }

    public String addStudents(List<Student> student) {

        studentRepo.saveAll(student);

        return "Students added !!!";
    }

    public Iterable<Student> getAllStudents() {

        return studentRepo.findAll();
    }

    public Optional<Student> getStudentById(Integer id) {
        return studentRepo.findById(id);
    }

    public String updateStudentDepartment(Integer id, Department department) {
        Optional<Student> s = studentRepo.findById(id);

        if(s.isEmpty())
        {return "Student id not found!!!";}

        Student stu = s.get();
        stu.setStudentDepartment(department);
        studentRepo.save(stu);
        return  "Id updated";
    }

    public String removeStudentById(Integer id) {

        Student e = studentRepo.findById(id).orElse(null);
        if(e==null)
        {
            return "Id not found";
        }
        studentRepo.delete(e);

        return "Student Removed";
    }
}