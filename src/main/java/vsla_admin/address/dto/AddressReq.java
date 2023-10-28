package vsla_admin.address.dto;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import vsla_admin.exceptions.customExceptions.BadRequestException;

import java.util.Set;
import java.util.stream.Collectors;

@Data
public class AddressReq {
    @NotBlank(message = "Country is required")
    private String country;

    @NotBlank(message = "Region is required")
    private String region;

    @NotBlank(message = "Zone/Sub-City is required")
    private String zone;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "Woreda is required")
    private String woreda;

    @NotBlank(message = "Kebele is required")
    private String kebele;

    private String houseNumber;

    public static void validateAddressReq(AddressReq request) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<AddressReq>> violations = validator.validate(request);

        if (!violations.isEmpty()) {
            String missingFields = violations.stream()
                    .map(violation -> violation.getPropertyPath().toString())
                    .collect(Collectors.joining(", "));
            throw new BadRequestException("Address Required fields: " + missingFields + ".");
        }
    }
}