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
class ValidateNameTest {
	//NguyenDinhPhu-20183968
	private PlaceOrderController placeOrderController;
	@BeforeEach
	void setUp() throws Exception {
		placeOrderController = new PlaceOrderController();
	}
	@ParameterizedTest
	@CsvSource({
		"nguyendphu,true",
		"nguyen1234,false",
		"$#nguyen,false",
		",false"
	})
	public void test(String name, boolean expected) {
		//when
		boolean isValid = placeOrderController.validateName(name);
		//then
		assertEquals(expected, isValid);
	}

}
