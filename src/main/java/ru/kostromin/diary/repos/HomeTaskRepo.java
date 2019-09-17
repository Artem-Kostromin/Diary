package ru.kostromin.diary.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kostromin.diary.domain.HomeTask;

import java.util.List;


public interface HomeTaskRepo extends JpaRepository<HomeTask,Long> {
    List<HomeTask> findAllByUserId(Long userId);
}
