package kg.mega.natv.services.impl;

import kg.mega.natv.dao.OrderDatesRep;
import kg.mega.natv.mappers.OrderDatesMapper;
import kg.mega.natv.models.dto.OrderDatesDto;
import kg.mega.natv.services.OrderDatesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDatesServiceImpl implements OrderDatesService {
    OrderDatesMapper orderDatesMapper = OrderDatesMapper.INSTANCE;
    private final OrderDatesRep orderDatesRep;

    public OrderDatesServiceImpl(OrderDatesRep orderDatesRep) {
        this.orderDatesRep = orderDatesRep;
    }

    @Override
    public OrderDatesDto save(OrderDatesDto orderDatesDto) {
        return orderDatesMapper.toDto(orderDatesRep.save(orderDatesMapper.toEntity(orderDatesDto)));
    }

    @Override
    public OrderDatesDto findById(Long id) {
        return orderDatesMapper.toDto(orderDatesRep.findById(id).orElseThrow(()->new RuntimeException("OrderDates not found!")));
    }

    @Override
    public OrderDatesDto delete(Long id) {
        return null;
    }

    @Override
    public List<OrderDatesDto> findAll() {
        return orderDatesMapper.toDtos(orderDatesRep.findAll());
    }
}
