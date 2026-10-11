package vehicle_business.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vehicle_business.demo.service.ProfitService;

@RestController
@CrossOrigin(origins = "http://localhost:5174")
@RequestMapping("/profit")
public class ProfitController {
    private final ProfitService profitService;

    public  ProfitController (ProfitService profitService){
        this.profitService=profitService;
    }

    @GetMapping
    public ResponseEntity<Double> getprofit(){
        Double profit = profitService.calculateProfit();
        return new ResponseEntity<>(profit, HttpStatus.OK);
    }
}
