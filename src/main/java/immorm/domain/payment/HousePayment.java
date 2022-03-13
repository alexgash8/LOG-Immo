package immorm.domain.payment;

import immorm.domain.House;
import immorm.domain.Leaser;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue(value = "house_payment")
public class
HousePayment extends Payment {

    @ManyToOne
    @JoinColumn(name = "FK_Payment_House")
    House house;
}
