package kg.mega.natv.controllers.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.mega.natv.models.dto.OrderDto;
import kg.mega.natv.models.dto.TextAdDto;
import kg.mega.natv.services.OrderService;
import kg.mega.natv.services.TextAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Текст")
@RestController
@RequestMapping("/text")
public class TextAdController {

    private final TextAdService textAdService;

    @Autowired
    public TextAdController(TextAdService textAdService) {
        this.textAdService = textAdService;
    }


    @PostMapping("/save")
    @ApiOperation("Сохранение")
    ResponseEntity<?> save(@RequestBody TextAdDto textAdDto) {
        return new ResponseEntity<>(textAdService.save(textAdDto), HttpStatus.CREATED);
    }

    @GetMapping("/findById")
    @ApiOperation("Поиск по id")
    ResponseEntity<?> findById(@RequestParam Long id) {
        return ResponseEntity.ok(textAdService.findById(id));
    }

    @GetMapping("/findAll")
    @ApiOperation("Вывод всех")
    ResponseEntity<List<TextAdDto>> findAll() {
        return ResponseEntity.ok(textAdService.findAll());
    }

    @DeleteMapping("/delete")
    @ApiOperation("Удаление")
    ResponseEntity<?> delete(@RequestParam Long id) {
        return ResponseEntity.ok(textAdService.delete(id));
    }


}
