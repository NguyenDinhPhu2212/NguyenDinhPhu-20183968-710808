package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
/**
 * 
 * @author NguyenDinhPhu-20183968
 *
 */
class ValidateReceiveTimeTest {

	private PlaceRushOrderController placeRushOrderController;
	@BeforeEach
	void setUp() throws Exception {
		placeRushOrderController = new PlaceRushOrderController();
	}

	@ParameterizedTest
    @CsvSource({
    	"08-08-2020 14:00,true",
        "08/08/2020 14:00,false",
        "08-13-2020 14:00,false",
        "08-09-2020 14:00,true",
        "08-08-2020 25:00,false"
    })
	void test(String time, boolean expected) {
		//when
		boolean isValid = placeRushOrderController.validateReceiveTime(time);
		//then
		assertEquals(expected, isValid);
	}

}
