package vehicle_business.demo.service;

import org.springframework.stereotype.Service;
import vehicle_business.demo.repositary.IncomeRepositary;
import vehicle_business.demo.repositary.ExpanseRepositary;

import java.util.HashMap;
import java.util.Map;

@Service
public class ReportService {

    private final IncomeRepositary incomeRepositary;
    private final ExpanseRepositary expanseRepositary;

    public ReportService(
            IncomeRepositary incomeRepositary,
            ExpanseRepositary expanseRepositary) {
        this.incomeRepositary = incomeRepositary;
        this.expanseRepositary = expanseRepositary;
    }

    public Map<String, Object> getReport(String date) {

        Double income =
                incomeRepositary.getIncomeByDate(date);

        Double expense =
                expanseRepositary.getExpenseByDate(date);

        Map<String, Object> report = new HashMap<>();

        report.put("date", date);
        report.put("totalIncome", income);
        report.put("totalExpense", expense);
        report.put("profit", income - expense);

        return report;
    }
}