package vehicle_business.demo.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vehicle_business.demo.service.ReportService;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5174")
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }
        @GetMapping
                public ResponseEntity<Map<String,Object>>getreport(@RequestParam("date") String data){

Map<String,Object> report = reportService.getReport(data);

return new ResponseEntity<>(report, HttpStatus.OK);
        }

}
