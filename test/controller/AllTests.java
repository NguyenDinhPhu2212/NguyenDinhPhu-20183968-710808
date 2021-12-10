package controller;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
/**
 * 
 * @author Nguyen Dinh Phu 20183968
 *
 */
@RunWith(Suite.class)
@SuiteClasses({
	ValidateNameTest.class, 
	ValidateAddressTest.class, 
	ValidatePhoneNumberTest.class, 
	ValidateReceiveTimeTest.class,
	ValidateRushOrderInfoTest.class,
	ValidateRushOrderInstructionTest.class,
	ValidateRushOrderItemsTest.class,
	ValidateRushOrderLocationTest.class})
public class AllTests {

}
