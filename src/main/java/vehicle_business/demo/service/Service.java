package vehicle_business.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import vehicle_business.demo.repositary.IncomeRepositary;
import vehicle_business.demo.model.Model;
import vehicle_business.demo.repositary.Repositary;

import java.util.List;

@org.springframework.stereotype.Service


public class Service {

    @Autowired
    private Repositary repositary;
    private IncomeRepositary incomeRepositary;


    public Model name(Model vehicle) {
        return repositary.save(vehicle);
    }

    public List<Model> show() {

        return  repositary.findAll();
    }

    public Model update(Model update) {

    Model exit = repositary.findById(update.getId()).orElseThrow(()->new RuntimeException("Vehical not founded !!"));


    exit.setVehicleName(update.getVehicleName());
    exit.setDriverName(update.getDriverName());
    exit.setStatus(update.getStatus());
    exit.setVehicleNumber(update.getVehicleNumber());

    return repositary.save(exit);
    }
    public void delete(Long id) {

        if (!repositary.existsById(id)) {
            throw new RuntimeException("Vehicle not found with id: " + id);
        }

        repositary.deleteById(id);
    }


}
