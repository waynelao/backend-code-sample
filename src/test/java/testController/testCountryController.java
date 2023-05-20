package testController;

import com.usc.beans.Country;
import com.usc.beans.State;
import com.usc.controller.CountryController;
import com.usc.dao.CountryDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class testCountryController {

    @InjectMocks
    CountryController countryController;

    @Mock
    CountryDao countryDao;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getCountriesTest() {
        Country ca = new Country(1, "CA", "Canada");
        Country us = new Country(2, "US", "America");
        List<Country> list = Arrays.asList(new Country[]{ca, us});
        when(countryDao.findAll()).thenReturn(list);
        assertEquals(2, countryController.getCountries().size());
        verify(countryDao, times(1)).findAll();
    }

    @Test
    public void getCountryStatesTest() {
        Country us = new Country(2, "US", "America");
        State state1 = new State(1, "michigan", us);
        Set<State> set = new HashSet<>();
        set.add(state1);
        us.setStates(set);
        when(countryDao.findByCode("us")).thenReturn(us);
        // System.out.println(countryController.getCountryStates("ca").size());
        assertEquals(1, countryController.getCountryStates("us").size());
        verify(countryDao, times(1)).findByCode("us");

    }

}
