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
class ValidateAddressTest {
	//NguyenDinhPhu-20183968
	private PlaceOrderController placeOrderController;
	@BeforeEach
	void setUp() throws Exception {
		placeOrderController = new PlaceOrderController();
	}
	@ParameterizedTest
	@CsvSource({
		"Hanoi,true",
		"so 15 Hai Ba Trung Ha Noi,true",
		"$# Hanoi,false",
		",false"
	})
	public void test(String address, boolean expected) {
		//when
		boolean isValid = placeOrderController.validateAddress(address);
		//then
		assertEquals(expected, isValid);
	}

}
