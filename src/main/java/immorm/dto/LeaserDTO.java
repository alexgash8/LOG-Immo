package immorm.dto;

import immorm.domain.Leaser;
import immorm.domain.phone.Phone;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LeaserDTO {

    int id;

    String firstName;

    String lastName;

    List<String> phones;

    String email;

    public LeaserDTO(Leaser leaser) {
        this.id = leaser.getId();
        this.firstName = leaser.getFirstName();
        this.lastName = leaser.getLastName();
        List<Phone> phones = leaser.getPhones();

        //Function<Phone, String> function = Phone::getNumber;

        List<String> numbers = phones
                .stream()
                .map(Phone::getNumber)
                .collect(Collectors.toList());

        this.phones = numbers;
        this.email = leaser.getEmail();
    }
}
