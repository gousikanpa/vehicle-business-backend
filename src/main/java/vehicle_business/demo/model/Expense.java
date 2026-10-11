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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Expense {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Vehicle ID is required")
    private String vehicleId;

    @NotBlank(message = "Date is required")
    private String date;
    @NotNull(message = "Please enter the amount")
    @Positive(message = "Amount must be greater than zero")
    private Double amount;

    @NotBlank(message = "Category is required")
    private String category;

    private String description;

    @NotBlank(message = "Location is required")
    private String location;
}
