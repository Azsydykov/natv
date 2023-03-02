package kg.mega.natv.mappers;

import kg.mega.natv.models.dto.OrderDatesDto;
import kg.mega.natv.models.dto.OrderDto;
import kg.mega.natv.models.entities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper extends BaseMapper<Order, OrderDto> {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
}
