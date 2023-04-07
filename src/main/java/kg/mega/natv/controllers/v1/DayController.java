package kg.mega.natv.controllers.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.mega.natv.models.dto.DayDto;
import kg.mega.natv.services.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Даты заказа")
@RestController
@RequestMapping("/dayController")
public class DayController {

    private final DayService orderDatesService;

    @Autowired
    public DayController(DayService orderDatesService) {
        this.orderDatesService = orderDatesService;
    }


    @PostMapping("/save")
    @ApiOperation("Сохранение")
    ResponseEntity<?> save(@RequestBody DayDto orderDatesDto) {
        return new ResponseEntity<>(orderDatesService.save(orderDatesDto), HttpStatus.CREATED);
    }

    @GetMapping("/findById")
    @ApiOperation("Поиск по id")
    ResponseEntity<?> findById(@RequestParam Long id) {
        return ResponseEntity.ok(orderDatesService.findById(id));
    }

    @GetMapping("/findAll")
    @ApiOperation("Вывод всех")
    ResponseEntity<List<DayDto>> findAll() {
        return ResponseEntity.ok(orderDatesService.findAll());
    }

    @DeleteMapping("/delete")
    @ApiOperation("Удаление")
    ResponseEntity<?> delete(@RequestParam Long id) {
        return ResponseEntity.ok(orderDatesService.delete(id));
    }


}
