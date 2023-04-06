package kg.mega.natv.dao;

import kg.mega.natv.models.entities.Text;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextAdRep extends JpaRepository<Text, Long> {

}
