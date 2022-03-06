package immorm.domain;

import immorm.domain.address.Address;
import immorm.domain.phone.Phone;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

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
    @JoinColumn(name = "FK_Leaser_LAddress")
    Address lastAddress;

    @OneToOne
    @JoinColumn(name = "FK_Leaser_Apt")
    Appartment appartment;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    @JoinColumn(name = "FK_Leaser_FAddress")
    Address futureAddress;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    @JoinColumn(name = "FK_Leaser_Account")
    BankAccount bankAccount;

    @Column(name = "count_people")
    int countPeople;

}
