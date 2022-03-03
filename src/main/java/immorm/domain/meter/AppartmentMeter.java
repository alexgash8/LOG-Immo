package immorm.domain.meter;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import immorm.domain.Appartment;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public class AppartmentMeter extends Meter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "apt_meter_id")
    int id;

    @Enumerated(EnumType.STRING)
    AmountType aType;

    @ManyToOne
    @JoinColumn(name = "FK_Meter_Apt")
    Appartment appartment;

}
