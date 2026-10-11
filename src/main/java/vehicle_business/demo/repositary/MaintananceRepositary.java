package vehicle_business.demo.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import vehicle_business.demo.model.Maintanance;

public interface MaintananceRepositary extends JpaRepository<Maintanance,Long> {
}
