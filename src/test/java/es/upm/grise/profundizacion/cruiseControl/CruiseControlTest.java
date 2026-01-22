package es.upm.grise.profundizacion.cruiseControl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CruiseControlTest {
	
	private CruiseControl cruiseControl;
	private Speedometer speedometer;
	
	@BeforeEach
	void setUp() {
		speedometer = mock(Speedometer.class);
		cruiseControl = new CruiseControl(speedometer);
	}
	
	@Test
    public void smokeTest() {
		// Basic test to ensure setup works
		assertNotNull(cruiseControl);
	}
	
	@Test
	public void testSetSpeedSetValid() throws IncorrectSpeedSetException, SpeedSetAboveSpeedLimitException {
		cruiseControl.setSpeedSet(50);
		assertEquals(50, cruiseControl.getSpeedSet());
	}
	
	@Test
	public void testSetSpeedSetZeroThrowsException() {
		assertThrows(IncorrectSpeedSetException.class, () -> {
			cruiseControl.setSpeedSet(0);
		});
	}
	
	@Test
	public void testSetSpeedSetNegativeThrowsException() {
		assertThrows(IncorrectSpeedSetException.class, () -> {
			cruiseControl.setSpeedSet(-10);
		});
	}
	
	@Test
	public void testSetSpeedSetAboveLimitThrowsException() {
		cruiseControl.setSpeedLimit(100);
		assertThrows(SpeedSetAboveSpeedLimitException.class, () -> {
			cruiseControl.setSpeedSet(150);
		});
	}
	
	@Test
	public void testSetSpeedSetAtLimit() throws IncorrectSpeedSetException, SpeedSetAboveSpeedLimitException {
		cruiseControl.setSpeedLimit(100);
		cruiseControl.setSpeedSet(100);
		assertEquals(100, cruiseControl.getSpeedSet());
	}
	
	@Test
	public void testGetSpeedLimit() {
		cruiseControl.setSpeedLimit(80);
		assertEquals(80, cruiseControl.getSpeedLimit());
	}
	
	@Test
	public void testGetSpeedSetInitiallyNull() {
		assertNull(cruiseControl.getSpeedSet());
	}
	
}