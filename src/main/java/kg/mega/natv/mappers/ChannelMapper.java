package kg.mega.natv.mappers;

import kg.mega.natv.models.dto.ChannelDto;
import kg.mega.natv.models.entities.Channel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ChannelMapper extends BaseMapper<Channel,ChannelDto> {

    ChannelMapper INSTANCE = Mappers.getMapper(ChannelMapper.class);
}
