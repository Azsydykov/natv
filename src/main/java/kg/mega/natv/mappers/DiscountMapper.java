package kg.mega.natv.mappers;

import kg.mega.natv.models.dto.DiscountDto;
import kg.mega.natv.models.entities.Discount;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface DiscountMapper extends BaseMapper<Discount,DiscountDto>{
    DiscountMapper INSTANCE = Mappers.getMapper(DiscountMapper.class);
}
