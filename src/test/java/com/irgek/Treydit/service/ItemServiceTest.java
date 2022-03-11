package com.irgek.Treydit.service;

import com.irgek.Treydit.domain.*;
import com.irgek.Treydit.persistence.ItemRepository;
import com.irgek.Treydit.service.Exception.ServiceException;
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
public class ItemServiceTest {
    @Autowired
    private ItemRepository itemRepository;
    private ItemService itemService;

     @BeforeEach
    void setup(){
         itemRepository = mock(ItemRepository.class);
         itemService = new ItemService(itemRepository);
     }

     @Test
    void ensureCreatingItemWithExceptionHandlingIsRight(){
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

         Item mouse = Item.builder().name("Razer mouse")
                 .cost(20.00)
                 .description("AKshdkjlsahd")
                 .itemCondition(Condition.GOD)
                 .category(Category.COMPUTER)
                 .treyder(treyder)
                 .build();

         Exception pEx = new PersistenceException("connection lost");
         when(itemRepository.findItemByName(mouse.getName())).thenReturn(Optional.empty());
         when(itemRepository.save(any())).thenThrow(pEx);

         var ex = assertThrows(ServiceException.class, ()-> itemService.createItem(mouse.getName(),mouse.getCost(),mouse.getDescription(),mouse.getItemCondition(),mouse.getCategory(),treyder));

         assertThat(ex).hasMessageContaining("Item")
                 .hasMessageContaining(mouse.getName(),mouse.getCost(),mouse.getDescription(),mouse.getItemCondition(),mouse.getCategory(),treyder)
                 .hasMessageContaining("database problem")
                 .hasRootCause(pEx);
     }
}
