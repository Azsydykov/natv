package kg.mega.natv.controllers.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.mega.natv.models.dto.PriceDto;
import kg.mega.natv.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Цена")
@RestController
@RequestMapping("/price")
public class PriceController {

    private final PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @PostMapping("/save")
    @ApiOperation("Сохранение")
    ResponseEntity<?> save(@RequestBody PriceDto priceDto) {
        return new ResponseEntity<>(priceService.save(priceDto), HttpStatus.CREATED);
    }

    @GetMapping("/findById")
    @ApiOperation("Поиск цены по id")
    ResponseEntity<?> findById(@RequestParam Long id) {
        return ResponseEntity.ok(priceService.findById(id));
    }

    @GetMapping("/findAll")
    @ApiOperation("Вывод всех цен")
    ResponseEntity<List<PriceDto>> findAll(){
        return ResponseEntity.ok(priceService.findAll());
    }

@DeleteMapping("/delete")
    @ApiOperation("Удаление цены")
    ResponseEntity<?> delete(@RequestParam Long id){
        return ResponseEntity.ok(priceService.delete(id));
}





}
