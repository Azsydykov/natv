package kg.mega.natv.services.impl;

import kg.mega.natv.dao.ChannelRep;
import kg.mega.natv.mappers.ChannelMapper;
import kg.mega.natv.models.dto.ChannelDto;
import kg.mega.natv.models.entities.Channel;
import kg.mega.natv.models.responses.GetAllChannelResponses;
import kg.mega.natv.services.ChannelService;
import kg.mega.natv.services.DiscountService;
import kg.mega.natv.services.PriceService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChannelServiceImpl implements ChannelService {

    ChannelMapper channelMapper = ChannelMapper.INSTANCE;

//    private final ChannelMapper channelMapper;
    private final ChannelRep channelRep;
    private final DiscountService discountService;
    private final PriceService priceService;

    public ChannelServiceImpl( ChannelRep channelRep,
                              DiscountService discountService, PriceService priceService) {
        this.channelRep = channelRep;
        this.discountService = discountService;
        this.priceService = priceService;
    }

    @Override
    public ChannelDto save(ChannelDto channelDto) {

        Channel channel = channelMapper.toEntity(channelDto);
        channel = channelRep.save(channel);
        channelDto.setId(channel.getId());

        //создаем цену
        priceService.create(channelDto.getPricePerLetter(), channel);

        channelDto.setDiscounts(discountService.saveAll(channelDto.getDiscounts(), channel));


        return channelDto;
    }

    @Override
    public List<ChannelDto> findAllChannels(int limit, int offset) {
        return channelMapper.toDtos(channelRep.findAllChannel(limit, offset));
    }

    @Override
    public List<GetAllChannelResponses> getAllChannels(int limit, int offset) {
        List<ChannelDto> channelsList = findAllChannels(limit, offset);

        List<GetAllChannelResponses> channelResponseList = channelsList.stream()
                .map(x -> getChannelResponse(x))
                .collect(Collectors.toList());

        Collections.sort(channelResponseList);
        return channelResponseList;
    }

    private GetAllChannelResponses getChannelResponse(ChannelDto x) {
        GetAllChannelResponses channelResponses = new GetAllChannelResponses();
        channelResponses.setId(x.getId());
        channelResponses.setChannelName(x.getChannelName());
        channelResponses.setActive(x.isActive());
        channelResponses.setCreatedDate(new Date());
        channelResponses.setLogoPath(x.getLogoPath());

        return channelResponses;
    }

    @Override
    public ChannelDto findById(Long id) {
        return channelMapper.toDto(channelRep.findById(id).orElseThrow(()-> new RuntimeException("Channel not found!")));
    }

    @Override
    public ChannelDto delete(Long id) {
        ChannelDto channelDto = new ChannelDto();
        channelDto.setActive(false);
        return save(channelDto);
    }

    @Override
    public List<ChannelDto> findAll() {
        return channelMapper.toDtos(channelRep.findAll());
    }
}
