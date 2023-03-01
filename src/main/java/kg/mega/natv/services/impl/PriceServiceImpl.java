package kg.mega.natv.services.impl;

import kg.mega.natv.dao.PriceRep;
import kg.mega.natv.mappers.PriceMapper;
import kg.mega.natv.models.entities.Channel;
import kg.mega.natv.models.entities.Price;
import kg.mega.natv.services.PriceService;
import kg.mega.natv.util.DateUtil;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PriceServiceImpl implements PriceService {
    PriceMapper priceMapper = PriceMapper.INSTANCE;

//    private final PriceMapper priceMapper;
    private final PriceRep priceRep;

    public PriceServiceImpl( PriceRep priceRep) {

        this.priceRep = priceRep;
    }

    @Override
    public void save(double pricePerLetter, Channel channel) {
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
}
