package ru.kostromin.diary.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import ru.kostromin.diary.domain.Student;

@Service
public interface StudentRepo extends CrudRepository<Student,Long> {
    Student findByStudentname(String studentname);
}
