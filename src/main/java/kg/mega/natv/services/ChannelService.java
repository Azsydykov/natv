package kg.mega.natv.services;

import kg.mega.natv.models.dto.ChannelDto;
import kg.mega.natv.models.entities.Channel;
import kg.mega.natv.models.responses.GetAllChannelResponses;

import java.util.List;

public interface ChannelService extends BaseService<ChannelDto>{


    List<ChannelDto> findAllChannels(int limit, int offset);
    List<GetAllChannelResponses> getAllChannels(int limit, int offset);
}
