package kg.mega.natv.dao;

import kg.mega.natv.models.dto.ChannelDto;
import kg.mega.natv.models.entities.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChannelRep extends JpaRepository<Channel, Long> {

    @Query(value = "SELECT * FROM tb_channel LIMIT :limit OFFSET :offset", nativeQuery = true)
    List<Channel> findAllChannel(int limit, int offset);
}
