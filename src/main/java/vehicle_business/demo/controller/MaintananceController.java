package vehicle_business.demo.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vehicle_business.demo.model.Maintanance;
import vehicle_business.demo.service.MaintananceService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5174")
@RequestMapping("/")
public class MaintananceController {

    @Autowired
    private MaintananceService maintananceService;
    @PostMapping("/post")

    public ResponseEntity<Maintanance> post (@Valid  @RequestBody Maintanance maint){

        return new ResponseEntity<>(maintananceService.posy(maint), HttpStatus.CREATED);
    }

@GetMapping("/getvalue")

    public ResponseEntity<?> getmap(){

        List<Maintanance> mait =maintananceService.hey();

        if (mait.isEmpty()){
            return new ResponseEntity<>("not found ", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(mait, HttpStatus.OK);
}

/// / get by id

    @GetMapping("/val/{id}")

    public ResponseEntity<?> gt(@PathVariable Long id){

        Maintanance maint = maintananceService.gt(id);

    return new ResponseEntity<>(maint,HttpStatus.OK);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> upd(
            @Valid @PathVariable Long id,
            @RequestBody Maintanance mainta) {

        return ResponseEntity.ok(
                maintananceService.upd(id, mainta)
        );
    }

@DeleteMapping("/delete-maintanance")

    public ResponseEntity<?> dele(){
  maintananceService.sel();
  return new ResponseEntity<>("All maintenance records deleted successfully", HttpStatus.OK);
}


    @DeleteMapping("/del/{id}")
    public ResponseEntity<String> dlee(@PathVariable Long id) {

        maintananceService.ser(id);

        return new ResponseEntity<>(
                "Maintenance deleted successfully. ID: " + id,
                HttpStatus.OK
        );
    }

}
