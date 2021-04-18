package app.Application.test;

import app.Application.Classes.Phone;
import app.Application.Classes.Manufacture;
import app.Application.Interfaces.ManufactureRepository;
import app.Application.Services.ManufactureService;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class ManufactureServiceImplTest {
    @Mock
    private ManufactureRepository manufactureRepository;

    @Test
    public void getGame() {
        manufactureRepository=mock(ManufactureRepository.class);
        Manufacture manufacture = new Manufacture();
        manufacture.setName("SASUNG");
        Manufacture manufacture1 = new Manufacture();
        manufacture1.setName("HUEMI");
        Mockito.when(manufactureRepository.findAll()).thenReturn(List.of(manufacture,manufacture1));
        ManufactureService userService = new ManufactureService(manufactureRepository);
        Assertions.assertEquals(2, userService.getManufactures().size());
        Assertions.assertEquals("EBLOVOZ",
                userService.getManufactures().get(0).getName());
    }
}
