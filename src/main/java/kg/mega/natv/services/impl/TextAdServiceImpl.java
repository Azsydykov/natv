package kg.mega.natv.services.impl;

import kg.mega.natv.mappers.OrderMapper;
import kg.mega.natv.mappers.TextAdMapper;
import kg.mega.natv.services.TextAdService;
import org.springframework.stereotype.Service;

@Service
public class TextAdServiceImpl implements TextAdService {
    TextAdMapper orderMapper = TextAdMapper.INSTANCE;
}
