package vehicle_business.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Maintanance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Please enter the vehicle ID")
    private String vehicleId;

    @NotBlank(message = "Please enter the date")
    private String date;

    @NotBlank(message = "Please enter the maintenance type")
    private String type;

    @NotNull(message = "Please enter the amount")
    @Positive(message = "Amount must be greater than zero")
    private Double amount;

    private String description;
}
