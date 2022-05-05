package immorm.domain.meter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
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
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
//@JsonSubTypes({
//        @JsonSubTypes.Type(value = AppartmentMeter.class, name = "AptMeter"),
//        @JsonSubTypes.Type(value = HouseMeter.class, name = "HMeter")}
//)
public abstract class Meter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meter_id")
    int id;

    String number;

    @Enumerated(EnumType.STRING)
    @JsonProperty(value = "meter_type")
    MeterType mType;

    @Enumerated(EnumType.STRING)
    @JsonProperty(value = "strategy_type")
    MeterStrategy sType;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    @JoinTable(name = "meter_history", joinColumns = @JoinColumn(name = "Meter_ID"),
            inverseJoinColumns = @JoinColumn(name = "History_ID"))
    Set<History> histories;
}
