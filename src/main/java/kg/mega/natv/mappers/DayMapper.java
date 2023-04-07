package kg.mega.natv.mappers;

import kg.mega.natv.models.dto.DayDto;
import kg.mega.natv.models.entities.Day;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DayMapper extends BaseMapper<Day, DayDto> {

    DayMapper INSTANCE = Mappers.getMapper(DayMapper.class);
}
