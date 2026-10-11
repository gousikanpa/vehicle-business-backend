package vehicle_business.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vehicle_business.demo.model.Maintanance;
import vehicle_business.demo.repositary.MaintananceRepositary;

import java.util.List;

@Service
public class MaintananceService {


    @Autowired
private MaintananceRepositary maintananceRepositary;


    public Maintanance posy(Maintanance maina) {
        return maintananceRepositary.save(maina);
    }


    public List<Maintanance> hey() {
        return maintananceRepositary.findAll();
    }


    public Maintanance gt(Long id) {
        return maintananceRepositary.findById(id).orElseThrow(()->new RuntimeException("id not founded "+id));
    }

    public Object upd(Long id, Maintanance maint) {

        Maintanance ma=maintananceRepositary.findById(id).orElseThrow(()->new RuntimeException("not founded"));

        ma.setAmount(maint.getAmount());
        ma.setDate(maint.getDate());
        ma.setType(maint.getType());
        ma.setDescription(maint.getDescription());
        ma.setVehicleId(maint.getVehicleId());


        return maintananceRepositary.save(ma);
    }

    public void sel() {
        maintananceRepositary.deleteAll();
    }

    public void ser(Long id) {

        if (!maintananceRepositary.existsById(id)){
            throw new RuntimeException("id not founded "+id);
        }
        maintananceRepositary.deleteById(id);


    }
}
