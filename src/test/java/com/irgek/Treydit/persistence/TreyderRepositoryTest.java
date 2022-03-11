package com.irgek.Treydit.persistence;


import com.irgek.Treydit.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class TreyderRepositoryTest {
    @Autowired
    private  TreyderRepository treyderRepository;

   @Test
    void ensureSavingWorksProperly(){

       Address address = Address.builder()
               .street("Pernerstorfergasse 60")
               .blocknumber(3)
               .doornumber(18)
               .zipcode(1100)
               .build();
       Phonenumber phonenumber = Phonenumber.builder()
               .country_code("43")
               .serialnumber("6641840791")
               .build();
       City vienna = City.builder()
               .name("Vienna")
               .build();

       Treyder treyder = Treyder.builder()
               .firstname("Cemil")
               .lastname("Aslan")
               .gender(Gender.MALE)
               .username("Turkikaze")
               .email("aslancemil09@gmail.com")
               .birthDate(LocalDate.of(2002,3,20))
               .address(address)
               .phonenumber("436641840791")
               .password("Cemilaslan2002")
               .role(Role.Treyder)
               .city(vienna)
               .build();

       var saved = treyderRepository.save(treyder);
       assertThat(saved).isSameAs(treyder);
       assertThat(saved.getFirstname()).isNotBlank().isNotEmpty().isNotNull();
   }
}
