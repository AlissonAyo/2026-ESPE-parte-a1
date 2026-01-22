package es.upm.grise.profundizacion.cruiseControl;

public class CruiseControl {
	
	@SuppressWarnings("unused")
	private Speedometer speedometer;
	private Integer speedSet;
	private Integer speedLimit;

	/*
	 * Constructor
	 */
	public CruiseControl(Speedometer speedometer) {
        this.speedometer = speedometer;
        this.speedSet = null;
        this.speedLimit = null;
    }

	
	/*
	 * Method to code / test
	 */
	public void setSpeedSet(int speedSet) throws IncorrectSpeedSetException, SpeedSetAboveSpeedLimitException {
		if (speedSet <= 0) {
            throw new IncorrectSpeedSetException("Speed set must be positive");
        }

        if (this.speedLimit != null && speedSet > this.speedLimit) {
            throw new SpeedSetAboveSpeedLimitException("Speed set cannot exceed speed limit");
        }

        this.speedSet = speedSet;
	}
	
	

	/*
	 * Other setters & getters
	 */
	public Integer getSpeedLimit() {
		
		return speedLimit;
		
	}

	public void setSpeedLimit(Integer speedLimit) {
		
		this.speedLimit = speedLimit;
		
	}

	public Integer getSpeedSet() {
		
		return speedSet;
		
	}

}
