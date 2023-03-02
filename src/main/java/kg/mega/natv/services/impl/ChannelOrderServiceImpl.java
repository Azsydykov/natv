package kg.mega.natv.services.impl;

import kg.mega.natv.dao.ChannelOrderRep;
import kg.mega.natv.mappers.ChannelOrderMapper;
import kg.mega.natv.models.dto.ChannelOrderDto;
import kg.mega.natv.services.ChannelOrderService;

import java.util.List;

public class ChannelOrderServiceImpl implements ChannelOrderService {

    ChannelOrderMapper channelOrderMapper = ChannelOrderMapper.INSTANCE;
    private final ChannelOrderRep channelOrderRep;

    public ChannelOrderServiceImpl(ChannelOrderRep channelOrderRep) {
        this.channelOrderRep = channelOrderRep;
    }

    @Override
    public ChannelOrderDto save(ChannelOrderDto channelOrderDto) {
        return channelOrderMapper.toDto(channelOrderRep.save(channelOrderMapper.toEntity(channelOrderDto)));
    }

    @Override
    public ChannelOrderDto findById(Long id) {
        return channelOrderMapper.toDto(channelOrderRep.findById(id).orElseThrow(()->new RuntimeException("ChannelOrder not found!")));
    }

    @Override
    public ChannelOrderDto delete(Long id) {
        return null;
    }

    @Override
    public List<ChannelOrderDto> findAll() {
        return channelOrderMapper.toDtos(channelOrderRep.findAll());
    }
}
