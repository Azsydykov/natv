package kg.mega.natv.services.impl;

import kg.mega.natv.dao.DiscountRep;
import kg.mega.natv.mappers.DiscountMapper;
import kg.mega.natv.models.dto.DiscountDto;
import kg.mega.natv.models.entities.Channel;
import kg.mega.natv.models.entities.Discount;
import kg.mega.natv.models.responses.DiscountResponse;
import kg.mega.natv.services.DiscountService;
import kg.mega.natv.util.DateUtil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiscountServiceImpl implements DiscountService {

    DiscountMapper discountMapper = DiscountMapper.INSTANCE;

    private final DiscountRep discountRep;

    public DiscountServiceImpl( DiscountRep discountRep) {
        this.discountRep = discountRep;
    }

    @Override
    public DiscountDto save(DiscountDto discountDto) {
        return discountMapper.toDto(discountRep.save(discountMapper.toEntity(discountDto)));
    }

    @Override
    public DiscountDto findById(Long id) {
        return discountMapper.toDto(discountRep.findById(id).orElseThrow(()->new RuntimeException("Discount not found!")));
    }

    @Override
    public DiscountDto delete(Long id) {
        DiscountDto discountDto = new DiscountDto();
        discountDto.setActive(false);
        return save(discountDto);
    }

    @Override
    public List<DiscountDto> findAll() {
        return discountMapper.toDtos(discountRep.findAll());
    }


    @Override
    public List<DiscountDto> saveAll(List<DiscountDto> discounts, Channel channel) {
        List<Discount> discountList = toDiscountList(discounts,channel);
       discountList = discountRep.saveAll(discountList);


        return discountMapper.toDtos(discountList);
    }

    @Override
    public List<Discount> toDiscountList(List<DiscountDto> discounts, Channel channel) {

        List<Discount> discountList = discounts.stream()
                .map(item -> getNewDiscount(item, channel))
                .collect(Collectors.toList());

        return discountList;
    }

    private Discount getNewDiscount(DiscountDto item, Channel channel) {
        Discount discount = new Discount();
        discount.setId(item.getId());
        discount.setDiscountDays(item.getDiscountDays());
        discount.setChannel(channel);
        discount.setDiscount(item.getDiscount());

        discount.setStartDate(new Date());
        discount.setEndDate(DateUtil.getInstance().getEndDate());
        return discount;
    }

    @Override
    public List<DiscountDto> findAllDiscount(Long id) {
        return discountMapper.toDtos(discountRep.findAllDiscount(id));
    }
}
