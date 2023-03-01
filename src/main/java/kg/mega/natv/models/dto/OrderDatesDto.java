package kg.mega.natv.models.dto;

import kg.mega.natv.models.entities.Order;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDatesDto {
    Long id;
    Date date;
    Order order;
}