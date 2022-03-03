package immorm.domain.address;

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
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    int id;

    String street;

    @Column(name = "house_number")
    int houseNumber;

    @Column(name = "postal_code", length = 5)
    String postalCode;

    @Enumerated(EnumType.STRING)
    AddressType type;
}
