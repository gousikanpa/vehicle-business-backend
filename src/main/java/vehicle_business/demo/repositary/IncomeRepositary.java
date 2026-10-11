package vehicle_business.demo.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vehicle_business.demo.model.Income;

public interface IncomeRepositary extends JpaRepository<Income,Long> {

    @Query("SELECT COALESCE(SUM(i.amount),0) FROM Income i")
    Double getTotalIncome();

    @Query("SELECT COALESCE(SUM(i.amount), 0) FROM Income i WHERE i.date = :date")
    Double getIncomeByDate(@Param("date") String date);
}
