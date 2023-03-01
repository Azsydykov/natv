package kg.mega.natv.dao;

import kg.mega.natv.models.entities.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRep extends JpaRepository<Price, Long> {
}
