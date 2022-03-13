package immorm.domain.phone;

import immorm.domain.Leaser;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phone_id")
    int id;

    String number;

    @Enumerated(EnumType.STRING)
    PhoneType type;

    @ManyToOne
    @JoinColumn(name = "FK_Phone_Leaser")
    Leaser leaser;

}
