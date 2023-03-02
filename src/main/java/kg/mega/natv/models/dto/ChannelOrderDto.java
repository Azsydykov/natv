package kg.mega.natv.models.dto;

import kg.mega.natv.models.entities.Channel;
import kg.mega.natv.models.entities.Order;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.ManyToOne;
import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChannelOrderDto {
    Long id;
    Channel channel;
    Order order;
    int daysCount;

}
