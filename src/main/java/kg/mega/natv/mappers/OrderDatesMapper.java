package kg.mega.natv.mappers;

import kg.mega.natv.models.dto.OrderDatesDto;
import kg.mega.natv.models.entities.OrderDates;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderDatesMapper extends BaseMapper<OrderDates, OrderDatesDto> {

    OrderDatesMapper INSTANCE = Mappers.getMapper(OrderDatesMapper.class);
}
