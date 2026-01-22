package es.upm.grise.profundizacion.cruiseControl;

public class SpeedSetAboveSpeedLimitException extends Exception {

    public SpeedSetAboveSpeedLimitException(String message) {
        super(message);
    }
}