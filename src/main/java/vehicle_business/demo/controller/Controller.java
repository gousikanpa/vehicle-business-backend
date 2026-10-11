package vehicle_business.demo.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import vehicle_business.demo.model.Income;
import vehicle_business.demo.model.Model;
import vehicle_business.demo.service.IncomeService;
import vehicle_business.demo.service.Service;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5174")
//@RequestMapping("/")
public class Controller {

    @Autowired
    private Service service;

    @Autowired
    private IncomeService incservice;


    // ================= VEHICLE =================

    @PostMapping("/number")
    public ResponseEntity<Model> vehical(@Valid @RequestBody Model vehical) {

        return new ResponseEntity<>(
                service.name(vehical),
                HttpStatus.OK
        );
    }


    @GetMapping("/show")
    public ResponseEntity<?> show() {

        List<Model> vehicals = service.show();

        if (vehicals.isEmpty()) {
            return new ResponseEntity<>(
                    "Not found the details",
                    HttpStatus.NOT_FOUND
            );
        }

        return new ResponseEntity<>(
                vehicals,
                HttpStatus.OK
        );
    }


    @PutMapping("/update")
    public ResponseEntity<Model> update(@Valid @RequestBody Model update) {

        return new ResponseEntity<>(
                service.update(update),
                HttpStatus.OK
        );
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {

        service.delete(id);

        return new ResponseEntity<>(
                "Vehicle deleted successfully",
                HttpStatus.OK
        );
    }


    // ================= INCOME =================

    // Add Income
    @PostMapping("/income")
    public ResponseEntity<Income> income(
            @Valid @RequestBody Income inc) {

        return new ResponseEntity<>(
                incservice.income(inc),
                HttpStatus.CREATED
        );
    }

    // Get all Income
    @GetMapping("/alldata")
    public ResponseEntity<?> getdata() {

        List<Income> show = incservice.show();

        if (show.isEmpty()) {

            return new ResponseEntity<>(
                    "Details not found",
                    HttpStatus.NOT_FOUND
            );
        }

        return new ResponseEntity<>(
                show,
                HttpStatus.OK
        );
    }


    // Get Income by ID
    @GetMapping("/seprateitems")
    public ResponseEntity<?> seprate(@RequestParam Long id) {

       Income income = incservice.getbyid(id);

        return new ResponseEntity<>(
                income,
                HttpStatus.OK
        );
    }

    @PutMapping("/updates")
    public ResponseEntity<?> updates(@Valid @RequestBody Income upd) {

        return new ResponseEntity<>(
                incservice.updat(upd),
                HttpStatus.OK
        );
    }
    @DeleteMapping("/income/{id}")
    public ResponseEntity<String> dlt(@PathVariable Long id) {
        incservice.dlt(id);

        return new ResponseEntity<>(
                "Income deleted successfully",
                HttpStatus.OK
        );
    }
}