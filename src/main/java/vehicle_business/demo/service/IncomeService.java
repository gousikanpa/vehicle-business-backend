package vehicle_business.demo.service;

import org.springframework.stereotype.Service;
import vehicle_business.demo.repositary.IncomeRepositary;
import vehicle_business.demo.model.Income;

import java.util.List;

@Service
public class IncomeService {

    private final IncomeRepositary incomeRepositary;

    public IncomeService(IncomeRepositary incomeRepositary) {
        this.incomeRepositary = incomeRepositary;
    }

    // Save Income
    public Income income(Income inc) {
        return incomeRepositary.save(inc);
    }

    // Get all Income
    public List<Income> show() {
        return incomeRepositary.findAll();
    }

    // Get Income by ID
    public Income getbyid(Long id) {

        return incomeRepositary.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Income not found: " + id
                        )
                );
    }

    public Income updat(Income income ) {
        Income ext= incomeRepositary.findById(income.getId()).orElseThrow(()-> new RuntimeException("id not found "));

ext.setAmount(income.getAmount());
ext.setDate(income.getDate());
ext.setSource(income.getSource());
ext.setLocation(income.getLocation());


return incomeRepositary.save(ext);


    }

    public void dlt(Long id) {
        if (!incomeRepositary.existsById(id)){
            throw new RuntimeException("vehical not founded");
        }
        incomeRepositary.deleteById(id);
    }
}