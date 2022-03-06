package immorm.domain.meter;

import immorm.domain.House;
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
@DiscriminatorValue(value = "house_meter")
public class HouseMeter extends Meter {

    @ManyToOne
    @JoinColumn(name = "FK_Meter_House")
    House house;

}
