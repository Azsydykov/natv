package kg.mega.natv.services.impl;

import kg.mega.natv.dao.DayRep;
import kg.mega.natv.mappers.DayMapper;
import kg.mega.natv.models.dto.DayDto;
import kg.mega.natv.services.DayService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DayServiceImpl implements DayService {
    DayMapper orderDatesMapper = DayMapper.INSTANCE;
    private final DayRep orderDatesRep;

    @Override
    public DayDto save(DayDto orderDatesDto) {
        return orderDatesMapper.toDto(orderDatesRep.save(orderDatesMapper.toEntity(orderDatesDto)));
    }

    @Override
    public DayDto findById(Long id) {
        return orderDatesMapper.toDto(orderDatesRep.findById(id).orElseThrow(()->new RuntimeException("OrderDates not found!")));
    }

    @Override
    public DayDto delete(Long id) {
        return null;
    }

    @Override
    public List<DayDto> findAll() {
        return orderDatesMapper.toDtos(orderDatesRep.findAll());
    }
}
