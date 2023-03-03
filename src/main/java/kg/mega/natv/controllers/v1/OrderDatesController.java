package kg.mega.natv.controllers.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.mega.natv.models.dto.ChannelOrderDto;
import kg.mega.natv.models.dto.OrderDatesDto;
import kg.mega.natv.services.ChannelOrderService;
import kg.mega.natv.services.OrderDatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Даты заказа")
@RestController
@RequestMapping("/orderDates")
public class OrderDatesController {

    private final OrderDatesService orderDatesService;

    @Autowired
    public OrderDatesController(OrderDatesService orderDatesService) {
        this.orderDatesService = orderDatesService;
    }


    @PostMapping("/save")
    @ApiOperation("Сохранение")
    ResponseEntity<?> save(@RequestBody OrderDatesDto orderDatesDto) {
        return new ResponseEntity<>(orderDatesService.save(orderDatesDto), HttpStatus.CREATED);
    }

    @GetMapping("/findById")
    @ApiOperation("Поиск по id")
    ResponseEntity<?> findById(@RequestParam Long id) {
        return ResponseEntity.ok(orderDatesService.findById(id));
    }

    @GetMapping("/findAll")
    @ApiOperation("Вывод всех")
    ResponseEntity<List<OrderDatesDto>> findAll() {
        return ResponseEntity.ok(orderDatesService.findAll());
    }

    @DeleteMapping("/delete")
    @ApiOperation("Удаление")
    ResponseEntity<?> delete(@RequestParam Long id) {
        return ResponseEntity.ok(orderDatesService.delete(id));
    }


}
