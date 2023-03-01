package kg.mega.natv.mappers;

import kg.mega.natv.models.dto.PriceDto;
import kg.mega.natv.models.entities.Price;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface PriceMapper extends BaseMapper<Price, PriceDto>{
    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);

}
