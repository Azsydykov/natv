package kg.mega.natv.controllers.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.mega.natv.models.dto.ChannelOrderDto;
import kg.mega.natv.models.dto.DiscountDto;
import kg.mega.natv.services.ChannelOrderService;
import kg.mega.natv.services.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "ChannelOrder")
@RestController
@RequestMapping("/channelOrder")
public class ChannelOrderController {

    private final ChannelOrderService channelOrderService;

    @Autowired
    public ChannelOrderController(ChannelOrderService channelOrderService) {
        this.channelOrderService = channelOrderService;
    }

    @PostMapping("/save")
    @ApiOperation("Сохранение")
    ResponseEntity<?> save(@RequestBody ChannelOrderDto channelOrderDto) {
        return new ResponseEntity<>(channelOrderService.save(channelOrderDto), HttpStatus.CREATED);
    }

    @GetMapping("/findById")
    @ApiOperation("Поиск по id")
    ResponseEntity<?> findById(@RequestParam Long id) {
        return ResponseEntity.ok(channelOrderService.findById(id));
    }

    @GetMapping("/findAll")
    @ApiOperation("Вывод всех")
    ResponseEntity<List<ChannelOrderDto>> findAll() {
        return ResponseEntity.ok(channelOrderService.findAll());
    }

    @DeleteMapping("/delete")
    @ApiOperation("Удаление")
    ResponseEntity<?> delete(@RequestParam Long id) {
        return ResponseEntity.ok(channelOrderService.delete(id));
    }


}
