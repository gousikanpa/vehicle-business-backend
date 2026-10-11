package vehicle_business.demo.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import vehicle_business.demo.model.Model;

public interface Repositary extends JpaRepository<Model, Long> {
}
