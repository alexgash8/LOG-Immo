package immorm.domain;

import immorm.domain.address.Address;
import immorm.domain.payment.Payment;
import immorm.domain.phone.Phone;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Leaser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "leaser_id")
    int id;

    String firstName;

    String lastName;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "leaser")
    List<Phone> phones;

    String email;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    Address lastAddress;

    @OneToOne(mappedBy = "leaser")
    Appartment appartment;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    Address futureAddress;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    BankAccount bankAccount;

    @Column(name = "count_people")
    int countPeople;

}
