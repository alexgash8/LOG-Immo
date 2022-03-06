package immorm.domain;

import immorm.domain.address.Address;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Appartment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "apt_id")
    int id;

    int number;

    BigDecimal square;

    @Column(name = "room_count")
    int roomCount;

    BigDecimal price;

    @OneToOne
    @JoinColumn(name = "FK_Apt_Address")
    Address address;

    @Column(name = "oper_cost")
    BigDecimal operatingCosts;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "appartment")
    Set<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "FK_Apt_House")
    House house;

}

/*
* Storage
* item
* count
* price
* sum_item
*
* */
