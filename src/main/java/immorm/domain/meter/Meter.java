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
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode
@MappedSuperclass
public abstract class Meter {

    String number;

    @Enumerated(EnumType.STRING)
    MeterType mType;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER)
            @JoinTable(name = "meter_history", joinColumns = @JoinColumn(name = "Meter_ID"),
            inverseJoinColumns = @JoinColumn(name = "History_ID"))
    Set<History> histories;
}
