package kg.mega.natv.dao;

import kg.mega.natv.models.entities.OrderDates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDatesRep extends JpaRepository<OrderDates, Long> {

}
