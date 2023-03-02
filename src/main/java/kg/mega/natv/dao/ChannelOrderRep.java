package kg.mega.natv.dao;

import kg.mega.natv.models.entities.ChannelOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelOrderRep extends JpaRepository<ChannelOrder, Long> {

}
