package kg.mega.natv.dao;

import kg.mega.natv.models.entities.Channel;
import kg.mega.natv.models.entities.Discount;
import kg.mega.natv.models.entities.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscountRep extends JpaRepository<Discount, Long> {

    @Query(value = "select * from tb_discount WHERE channel_id=:id", nativeQuery = true)
    List<Discount> findAllDiscount(Long id);


}
