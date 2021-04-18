package app.Application.test;

import app.Application.Classes.Phone;
import app.Application.Interfaces.PhoneRepository;
import app.Application.Interfaces.ManufactureRepository;
import app.Application.Services.PhoneService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.mockito.Mockito.mock;


@ExtendWith(MockitoExtension.class)
public class PhoneServiceImplTest {

    @Mock
    private PhoneRepository phoneRepository;
    @Test
    public void getGame() {
        phoneRepository=mock(PhoneRepository .class);
        Phone phone = new Phone();
        phone.setName("JX-1");
        Phone phone1 = new Phone();
        phone1.setName("JX-2");
        Mockito.when(phoneRepository.findAll()).thenReturn(List.of(phone,phone1));
        PhoneService userService = new PhoneService(phoneRepository);
        Assertions.assertEquals(2, userService.getPhones().size());
        Assertions.assertEquals("XJ-01",
                userService.getPhones().get(0).getName());
    }
}
