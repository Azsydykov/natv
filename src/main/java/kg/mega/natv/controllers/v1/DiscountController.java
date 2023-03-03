package kg.mega.natv.controllers.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.mega.natv.models.dto.DiscountDto;
import kg.mega.natv.models.dto.PriceDto;
import kg.mega.natv.services.DiscountService;
import kg.mega.natv.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Скидка")
@RestController
@RequestMapping("/discount")
public class DiscountController {

    private final DiscountService discountService;

    @Autowired
    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @PostMapping("/save")
    @ApiOperation("Сохранение")
    ResponseEntity<?> save(@RequestBody DiscountDto discountDto) {
        return new ResponseEntity<>(discountService.save(discountDto), HttpStatus.CREATED);
    }

    @GetMapping("/findById")
    @ApiOperation("Поиск скидки по id")
    ResponseEntity<?> findById(@RequestParam Long id) {
        return ResponseEntity.ok(discountService.findById(id));
    }

    @GetMapping("/findAll")
    @ApiOperation("Вывод всех скидок")
    ResponseEntity<List<DiscountDto>> findAll() {
        return ResponseEntity.ok(discountService.findAll());
    }

    @DeleteMapping("/delete")
    @ApiOperation("Удаление скидки")
    ResponseEntity<?> delete(@RequestParam Long id) {
        return ResponseEntity.ok(discountService.delete(id));
    }


}
