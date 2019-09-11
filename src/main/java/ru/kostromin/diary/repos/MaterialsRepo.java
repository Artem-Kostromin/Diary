package ru.kostromin.diary.repos;

import org.springframework.data.repository.CrudRepository;
import ru.kostromin.diary.domain.MaterialsForStudents;

public interface MaterialsRepo extends CrudRepository<MaterialsForStudents,Long> {
    MaterialsForStudents findByDescription(String description);
}
