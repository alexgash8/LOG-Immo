package immorm;

import immorm.domain.*;
import immorm.domain.address.Address;
import immorm.domain.address.AddressType;
import immorm.domain.history.History;
import immorm.domain.meter.*;
import immorm.domain.payment.AptPayment;
import immorm.domain.payment.HousePayment;
import immorm.domain.phone.Phone;
import immorm.domain.phone.PhoneType;
import immorm.service.impl.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class ImmoCRMApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ImmoCRMApplication.class, args);

        /*HouseService houseService = context.getBean(HouseService.class);
        AppartmentService appartmentService = context.getBean(AppartmentService.class);
        LeaserService leaserService = context.getBean(LeaserService.class);
        HistoryInOutService historyInOutService = context.getBean(HistoryInOutService.class);
        PaymentService paymentService = context.getBean(PaymentService.class);
        MeterService meterService = context.getBean(MeterService.class);

        Address addressHouse = Address
                .builder()
                .houseNumber(10)
                .postalCode("51273")
                .street("First")
                .type(AddressType.HOUSE)
                .build();

        House house = House
                .builder()
                .address(addressHouse)
                .countAppartments(3)
                .insuranceNumber("1113514474161")
                .build();

//        houseService.save(house);

        House house1 = houseService.findById(1);

        Address address = house1.getAddress();

        Appartment app2 = Appartment
                .builder()
                .number(2)
                .operatingCosts(new BigDecimal("300.4"))
                .roomCount(4)
                .square(BigDecimal.valueOf(100))
                .house(house1)
                .address(address)
                .price(BigDecimal.valueOf(950))
                .build();

        //appartmentService.save(app2);

        BankAccount bankAccount = BankAccount.builder()
                .bankName("Postbank")
                .BIC("123151346 1454361346")
                .IBAN("DE 11231335135335")
                .build();

        Phone phone1 = Phone.builder()
                .type(PhoneType.HOME)
                .number("0967475398")
                .build();

        Appartment app3 = appartmentService.findById(5);
        Leaser leaser = Leaser.builder()
                .appartment(app3)
                .bankAccount(bankAccount)
                .countPeople(4)
                .email("alexgash8@gmail.com")
                .firstName("Alex")
                .lastName("GASH")
                .phones(List.of(phone1))
                .build();

        phone1.setLeaser(leaser);

//        leaserService.save(leaser);

        Leaser leaser1 = leaserService.findById(10);
        HistoryInOut historyInOut = HistoryInOut.builder()
                .dateIncome(LocalDate.now())
                .dateOutcome(LocalDate.of(2022, Month.APRIL, 25))
                .leaser(leaser1)
                .build();

//        historyInOutService.save(historyInOut);

        AptPayment aptPayment = AptPayment.builder()
                .leaser(leaser1)
                .ammount(BigDecimal.valueOf(5605))
                .name("gaz")
                .date(LocalDate.now())
                .build();

//        paymentService.save(aptPayment);

        HousePayment housePayment = HousePayment.builder()
                .house(house1)
                .name("electro")
                .ammount(BigDecimal.valueOf(11100))
                .date(LocalDate.now())
                .build();

//        paymentService.save(housePayment);

        History history1 = History.builder()
                .ammount(BigDecimal.valueOf(567))
                .date(LocalDate.now())
                .build();

        History history2 = History.builder()
                .ammount(BigDecimal.valueOf(888))
                .date(LocalDate.now())
                .build();

        History history3 = History.builder()
                .ammount(BigDecimal.valueOf(2000))
                .date(LocalDate.now())
                .build();

        HouseMeter houseMeter = HouseMeter.builder()
                .house(house1)
                .mType(MeterType.WATER)
                .number("ggg13214131")
                .histories(Set.of(history1, history2))
                .build();

        AppartmentMeter appartmentMeter = AppartmentMeter.builder()
                .appartment(app3)
                .mType(MeterType.WATER)
                .aType(AmountType.INCOME)
                .number("ttt132546547")
                .histories(Set.of(history3))
                .build();

       meterService.save(houseMeter);
        meterService.save(appartmentMeter);*/

    }
}
