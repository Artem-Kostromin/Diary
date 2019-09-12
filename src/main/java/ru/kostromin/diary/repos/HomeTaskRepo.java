package ru.kostromin.diary.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kostromin.diary.domain.HomeTask;


public interface HomeTaskRepo extends JpaRepository<HomeTask,Long> {

}
