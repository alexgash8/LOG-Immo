package immorm.domain.payment;

import immorm.domain.Leaser;
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
@DiscriminatorValue(value = "apt_payment")
public class AptPayment extends Payment {

    @ManyToOne
    @JoinColumn(name = "FK_Payment_Leaser")
    Leaser leaser;

}
