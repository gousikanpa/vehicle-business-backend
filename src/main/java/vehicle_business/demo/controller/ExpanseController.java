package vehicle_business.demo.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import vehicle_business.demo.model.Expense;
import vehicle_business.demo.service.ExpanseService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5174")
@RequestMapping("/")
public class ExpanseController {

    private final ExpanseService expanseService;

    public ExpanseController(ExpanseService expanseService) {
        this.expanseService = expanseService;
    }

    @PostMapping("/expanse")
    public ResponseEntity<Expense> post( @Valid @RequestBody Expense expanse) {

        return new ResponseEntity<>(
                expanseService.expe(expanse),
                HttpStatus.OK
        );



    }
    @GetMapping("/shw")
    public ResponseEntity<?> shown (){
        List<Expense> expens= expanseService.shown();

        if (expens.isEmpty()){
            return new ResponseEntity<>("Not found Exception ", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(expens,HttpStatus.OK);
    }

@GetMapping("/shm/{id}")

    public ResponseEntity<Expense> getbyid(@PathVariable Long id){
        Expense expense= expanseService.getbyid(id);
return new ResponseEntity<>(expense, HttpStatus.OK);
}

@PutMapping("/upd")
    public ResponseEntity<Expense> update(@RequestBody Expense ede){

return new ResponseEntity<>(expanseService.urt(ede),HttpStatus.OK);
}
@DeleteMapping("/delete")

    public ResponseEntity<?> del(@RequestParam Long id){
        expanseService.del(id);
        return new ResponseEntity<>(HttpStatus.OK);
}
}