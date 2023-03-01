package kg.mega.natv.controllers.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.mega.natv.models.dto.ChannelDto;
import kg.mega.natv.models.responses.GetAllChannelResponses;
import kg.mega.natv.services.ChannelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Канал")
@RestController
@RequestMapping("/channel")
public class ChannelController {

    private final ChannelService channelService;

    public ChannelController(ChannelService channelService) {
        this.channelService = channelService;
    }

    @PostMapping("/save")
    public ChannelDto save(@RequestBody ChannelDto channelDto) {
        return channelService.save(channelDto);
    }

    @GetMapping("/getAllChannels")
    @ApiOperation("Вывод всех каналов")
    ResponseEntity<List<GetAllChannelResponses>> getAllChannels(@RequestParam int limit, @RequestParam int offset) {
        return ResponseEntity.ok(channelService.getAllChannels(limit, offset));
    }

}
