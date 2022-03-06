package immorm.domain.meter;

import immorm.domain.history.History;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Set;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "meter_type")
@Table(name = "meters")
public class Meter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "meter_id")
    int id;

    String number;

    @Enumerated(EnumType.STRING)
    MeterType mType;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER)
            @JoinTable(name = "meter_history", joinColumns = @JoinColumn(name = "Meter_ID"),
            inverseJoinColumns = @JoinColumn(name = "History_ID"))
    Set<History> histories;
}
