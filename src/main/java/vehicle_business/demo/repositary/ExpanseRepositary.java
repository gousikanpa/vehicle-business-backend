package vehicle_business.demo.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vehicle_business.demo.model.Expense;

public interface ExpanseRepositary extends JpaRepository<Expense, Long> {

    @Query("SELECT COALESCE(SUM(e.amount),0)FROM Expense e")
    Double getTotalExpanse();

    @Query("SELECT COALESCE(SUM(e.amount), 0) FROM Expense e WHERE e.date = :date")
    Double getExpenseByDate(@Param("date") String date);
}