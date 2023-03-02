package kg.mega.natv.services.impl;

import kg.mega.natv.mappers.OrderDatesMapper;
import kg.mega.natv.models.dto.ChannelDto;
import kg.mega.natv.services.OrderDatesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDatesServiceImpl implements OrderDatesService {
    OrderDatesMapper orderDatesMapper = OrderDatesMapper.INSTANCE;

    @Override
    public ChannelDto save(ChannelDto t) {
        return null;
    }

    @Override
    public ChannelDto findById(Long id) {
        return null;
    }

    @Override
    public ChannelDto delete(Long id) {
        return null;
    }

    @Override
    public List<ChannelDto> findAll() {
        return null;
    }
}
