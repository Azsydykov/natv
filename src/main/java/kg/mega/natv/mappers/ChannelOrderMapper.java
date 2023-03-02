package kg.mega.natv.mappers;

import kg.mega.natv.models.dto.ChannelOrderDto;
import kg.mega.natv.models.entities.ChannelOrder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ChannelOrderMapper extends BaseMapper<ChannelOrder, ChannelOrderDto> {

    ChannelOrderMapper INSTANCE = Mappers.getMapper(ChannelOrderMapper.class);
}
