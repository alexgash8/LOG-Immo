package immorm.domain.meter;

import immorm.domain.Appartment;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue(value = "apt_meter")
public class AppartmentMeter extends Meter {

    @Enumerated(EnumType.STRING)
    AmountType aType;

    @ManyToOne
    @JoinColumn(name = "FK_Meter_Apt")
    Appartment appartment;

}
