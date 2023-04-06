package kg.mega.natv.services.impl;

import kg.mega.natv.dao.OrderRep;
import kg.mega.natv.mappers.OrderMapper;
import kg.mega.natv.models.dto.OrderDto;
import kg.mega.natv.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    OrderMapper orderMapper = OrderMapper.INSTANCE;
    private final OrderRep orderRep;



    @Override
    public OrderDto save(OrderDto orderDto) {
        return orderMapper.toDto(orderRep.save(orderMapper.toEntity(orderDto)));
    }

    @Override
    public OrderDto findById(Long id) {
        return orderMapper.toDto(orderRep.findById(id).orElseThrow(()->new RuntimeException("Order not found!")));
    }

    @Override
    public OrderDto delete(Long id) {
        return null;
    }

    @Override
    public List<OrderDto> findAll() {
        return orderMapper.toDtos(orderRep.findAll());
    }
}
