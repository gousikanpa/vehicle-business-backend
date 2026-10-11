package vehicle_business.demo.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import vehicle_business.demo.model.Expense;
import vehicle_business.demo.repositary.ExpanseRepositary;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpanseService {

    private final ExpanseRepositary expanseRepositary;


    public ExpanseService(ExpanseRepositary expanseRepositary) {
        this.expanseRepositary = expanseRepositary;
    }

    public Expense expe(Expense mod) {
        return expanseRepositary.save(mod);
    }

    public List<Expense> shown() {
        return expanseRepositary.findAll();
    }

    public Expense getbyid(Long id) {
        return expanseRepositary.findById(id).orElseThrow(()->
                new RuntimeException());
    }

    public Expense urt(Expense ede) {

        Expense eir= expanseRepositary.findById(ede.getId()).orElseThrow(()->new RuntimeException("not founded"));


     eir.setAmount(ede.getAmount());
     eir.setDate(ede.getDate());
     eir.setCategory(ede.getCategory());
     eir.setLocation(ede.getLocation());
     eir.setId(ede.getId());
     eir.setDescription(ede.getDescription());
     eir.setVehicleId(ede.getVehicleId());

     return expanseRepositary.save(eir);
    }


    public void del(Long id) {
        if (!expanseRepositary.existsById(id)) {
            throw new RuntimeException("id not founded " + id);
        }

        expanseRepositary.deleteById(id);
    }
}