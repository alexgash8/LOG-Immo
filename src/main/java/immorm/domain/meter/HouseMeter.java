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
@MappedSuperclass
public class HouseMeter extends Meter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "house_meter_id")
    int id;

    @ManyToOne
    @JoinColumn(name = "FK_Meter_House")
    House house;

}
