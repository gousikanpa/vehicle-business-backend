package vehicle_business.demo.service;


import org.springframework.stereotype.Service;
import vehicle_business.demo.repositary.ExpanseRepositary;
import vehicle_business.demo.repositary.IncomeRepositary;
import vehicle_business.demo.repositary.MaintananceRepositary;
import vehicle_business.demo.repositary.Repositary;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class DashboardService {

    private  final IncomeRepositary incomeRepositary;
    private final ExpanseRepositary expanseRepositary;

    private Repositary repositary;
    private final MaintananceRepositary maintananceRepositary;

    public DashboardService(
            IncomeRepositary incomeRepositary,
            ExpanseRepositary expanseRepositary,
            Repositary repositary,
            MaintananceRepositary maintananceRepositary) {

        this.incomeRepositary = incomeRepositary;
        this.expanseRepositary = expanseRepositary;
        this.repositary = repositary;
        this.maintananceRepositary = maintananceRepositary;
    }

    public Map<String, Object> getDashboard() {

        Double income = incomeRepositary.getTotalIncome();
        Double expense = expanseRepositary.getTotalExpanse();

        Double profit = income - expense;

        long totalVehicles = repositary.count();
        long totalMaintenance = maintananceRepositary.count();

        Map<String, Object> dashboard = new HashMap<>();

        dashboard.put("totalIncome", income);
        dashboard.put("totalExpense", expense);
        dashboard.put("totalProfit", profit);
        dashboard.put("totalVehicles", totalVehicles);
        dashboard.put("totalMaintenance", totalMaintenance);

        return dashboard;
    }
}
