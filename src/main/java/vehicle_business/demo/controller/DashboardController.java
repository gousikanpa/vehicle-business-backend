package vehicle_business.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vehicle_business.demo.service.DashboardService;

import java.util.Map;
import java.util.Objects;

@RestController

@CrossOrigin(origins = "http://localhost:5174")
@RequestMapping("/dashboard")
public class DashboardController {
private  final DashboardService dashboardService;

public DashboardController(DashboardService dashboardService){
    this.dashboardService=dashboardService;
}

@GetMapping

    public ResponseEntity<Map<String, Object>> getDash(){
    Map<String,Object> dashboard= dashboardService.getDashboard();

    return new ResponseEntity<>(dashboard, HttpStatus.OK);
}
}
