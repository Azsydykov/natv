package kg.mega.natv.dao;

import kg.mega.natv.models.entities.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayRep extends JpaRepository<Day, Long> {

}
