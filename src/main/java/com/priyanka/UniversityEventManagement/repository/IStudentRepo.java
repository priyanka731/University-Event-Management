package com.priyanka.UniversityEventManagement.repository;

import com.priyanka.UniversityEventManagement.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepo extends CrudRepository<Student,Integer> {
}