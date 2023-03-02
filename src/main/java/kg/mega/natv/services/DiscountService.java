package kg.mega.natv.services;

import kg.mega.natv.models.dto.DiscountDto;
import kg.mega.natv.models.entities.Channel;
import kg.mega.natv.models.entities.Discount;
import kg.mega.natv.models.responses.DiscountResponse;

import java.util.List;

public interface DiscountService extends BaseService<DiscountDto>{

    List<DiscountDto> saveAll(List<DiscountDto> discounts, Channel channel);
    List<Discount> toDiscountList(List<DiscountDto> discounts, Channel channel);
    List<DiscountDto> findAllDiscount(Long id);
}
