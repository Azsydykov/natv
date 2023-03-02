package kg.mega.natv.services.impl;

import kg.mega.natv.dao.PriceRep;
import kg.mega.natv.mappers.PriceMapper;
import kg.mega.natv.models.dto.PriceDto;
import kg.mega.natv.models.entities.Channel;
import kg.mega.natv.models.entities.Price;
import kg.mega.natv.services.PriceService;
import kg.mega.natv.util.DateUtil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {
    PriceMapper priceMapper = PriceMapper.INSTANCE;

//    private final PriceMapper priceMapper;
    private final PriceRep priceRep;

    public PriceServiceImpl( PriceRep priceRep) {

        this.priceRep = priceRep;
    }

    @Override
    public void create(double pricePerLetter, Channel channel) {
        Price price = toPrice(pricePerLetter, channel);
        priceRep.save(price);
    }

    @Override
    public Price toPrice(double price, Channel channel) {

        Price newPrice = new Price();
        newPrice.setPricePerSymbol(price);
        newPrice.setChannel(channel);
        newPrice.setStartDate(new Date());
        newPrice.setEndDate(DateUtil.getInstance().getEndDate());
        return newPrice;
    }

    @Override
    public PriceDto save(PriceDto priceDto) {
        return priceMapper.toDto(priceRep.save(priceMapper.toEntity(priceDto)));
    }

    @Override
    public PriceDto findById(Long id) {
        return priceMapper.toDto(priceRep.findById(id).orElseThrow(()->new RuntimeException("Price not found!")));
    }

    @Override
    public PriceDto delete(Long id) {
        PriceDto priceDto = new PriceDto();
        priceDto.setActive(false);
        return save(priceDto);
    }

    @Override
    public List<PriceDto> findAll() {
        return priceMapper.toDtos(priceRep.findAll());
    }
}
