package vehicle_business.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vehicle_business.demo.repositary.ExpanseRepositary;
import vehicle_business.demo.repositary.IncomeRepositary;

@Service
public class ProfitService {


    private  final IncomeRepositary incomeRepositary;
    private final ExpanseRepositary expanseRepositary;


    public ProfitService(
            IncomeRepositary incomeRepositary, ExpanseRepositary expanseRepositary
    ){
        this.expanseRepositary=expanseRepositary;
        this.incomeRepositary=incomeRepositary;
    }

    public Double calculateProfit(){
        Double income = incomeRepositary.getTotalIncome();
        Double expence = expanseRepositary.getTotalExpanse();

        return income-expence;
    }

}
