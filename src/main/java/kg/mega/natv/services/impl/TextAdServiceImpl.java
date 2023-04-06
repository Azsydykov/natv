package kg.mega.natv.services.impl;

import kg.mega.natv.dao.TextAdRep;
import kg.mega.natv.mappers.OrderMapper;
import kg.mega.natv.mappers.TextAdMapper;
import kg.mega.natv.models.dto.TextAdDto;
import kg.mega.natv.services.TextAdService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TextAdServiceImpl implements TextAdService {
    TextAdMapper orderMapper = TextAdMapper.INSTANCE;
    private final TextAdRep textAdRep;


    @Override
    public TextAdDto save(TextAdDto textAdDto) {
        return orderMapper.toDto(textAdRep.save(orderMapper.toEntity(textAdDto)));
    }

    @Override
    public TextAdDto findById(Long id) {
        return orderMapper.toDto(textAdRep.findById(id).orElseThrow(()->new RuntimeException("Text not found!")));
    }

    @Override
    public TextAdDto delete(Long id) {
        return null;
    }

    @Override
    public List<TextAdDto> findAll() {
        return orderMapper.toDtos(textAdRep.findAll());
    }
}
