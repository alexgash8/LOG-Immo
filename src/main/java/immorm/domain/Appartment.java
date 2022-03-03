package immorm.domain;

import immorm.domain.address.Address;
import immorm.domain.meter.Meter;
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

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    Address address;

    int number;

    BigDecimal square;

    @Column(name = "room_count")
    int roomCount;

    BigDecimal price;

    @Column(name = "oper_cost")
    BigDecimal operatingCosts;

    boolean free;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "appartment")
    Set<Comment> comments;

}

/*
* Storage
* item
* count
* price
* sum_item
*
* */
