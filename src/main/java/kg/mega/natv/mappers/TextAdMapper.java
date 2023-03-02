package kg.mega.natv.mappers;

import kg.mega.natv.models.dto.TextAdDto;
import kg.mega.natv.models.entities.TextAd;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TextAdMapper extends BaseMapper<TextAd, TextAdDto> {

    TextAdMapper INSTANCE = Mappers.getMapper(TextAdMapper.class);
}
