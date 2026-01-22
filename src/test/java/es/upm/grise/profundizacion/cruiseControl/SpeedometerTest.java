package es.upm.grise.profundizacion.cruiseControl;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SpeedometerTest {
	
	@Test
	public void testSetAndGetCurrentSpeed() {
		Speedometer speedometer = new Speedometer();
		speedometer.setCurrentSpeed(60);
		assertEquals(60, speedometer.getCurrentSpeed());
	}
	
	@Test
	public void testInitialCurrentSpeed() {
		Speedometer speedometer = new Speedometer();
		// Since int default is 0
		assertEquals(0, speedometer.getCurrentSpeed());
	}
	
	@Test
	public void testSetNegativeSpeed() {
		Speedometer speedometer = new Speedometer();
		speedometer.setCurrentSpeed(-10);
		assertEquals(-10, speedometer.getCurrentSpeed());
	}
	
}