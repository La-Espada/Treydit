package com.irgek.Treydit.service;

import com.irgek.Treydit.domain.*;
import com.irgek.Treydit.persistence.TreyderRepository;
import com.irgek.Treydit.service.Exception.ServiceException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.PersistenceException;
import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DataJpaTest
public class TreyderServiceTest {
    @Autowired
    private TreyderRepository treyderRepository;
    private TreyderService treyderService;

    @BeforeEach
    void setup(){
        treyderRepository = mock(TreyderRepository.class);
        treyderService = new TreyderService(treyderRepository);
    }

    @Test
    void ensureCreatingTreyderWithExceptionHandlingIsRight(){

        Address address = Address.builder()
                .street("Pernerstorfergasse 60")
                .blocknumber(3)
                .doornumber(18)
                .zipcode(1100)
                .build();
        Phonenumber phonenumber = Phonenumber.builder()
                .country_code(43)
                .serialnumber("6641840791")
                .build();
        City vienna = City.builder()
                .name("Vienna")
                .build();

        Treyder treyder = Treyder.builder()
                .firstname("Cemil")
                .lastname("Lastname")
                .gender(Gender.MALE)
                .username("Turkikaze")
                .email("aslancemil09@gmail.com")
                .birthDate(LocalDate.of(2002,3,20))
                .address(address)
                .phonenumber(phonenumber)
                .password("Cemilaslan2002")
                .role(Role.Treyder)
                .city(vienna)
                .build();

        Exception pEx = new PersistenceException("connection lost");
        when(treyderRepository.findTreyderByUsername(treyder.getUsername())).thenReturn(Optional.empty());
        when(treyderRepository.save(any())).thenThrow(pEx);

        var ex = assertThrows(ServiceException.class, ()-> treyderService.createTreyder(treyder.getFirstname(),treyder.getLastname(),treyder.getGender(),treyder.getUsername(),treyder.getEmail(),treyder.getBirthDate(),address,phonenumber,treyder.getPassword(),treyder.getRole(),vienna));

        assertThat(ex).hasMessageContaining("Treyder")
                .hasMessageContaining(treyder.getFirstname(),treyder.getLastname(),treyder.getUsername(),treyder.getGender(),treyder.getEmail(),treyder.getBirthDate(),address,phonenumber,treyder.getPassword(),treyder.getRole(),vienna)
                .hasMessageContaining("database problem")
                .hasRootCause(pEx);
    }
}
