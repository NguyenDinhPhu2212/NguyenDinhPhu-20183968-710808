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
class ValidateRushOrderInfoTest {

	private PlaceRushOrderController placeRushOrderController;
	@BeforeEach
	void setUp() throws Exception {
		placeRushOrderController = new PlaceRushOrderController();
	}

	@ParameterizedTest
    @CsvSource({
    	"Giao dung han nha ban,true",
        "Thank you,true",
        "S# abc,false",
        ",false"
    })
	void test(String info, boolean expected) {
		//when
		boolean isValid = placeRushOrderController.validateRushOrderInfo(info);
		//then
		assertEquals(expected, isValid);
	}

}
