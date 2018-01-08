package designPattern.observer;

/**
 * This is the interface that all observers have to implement
 * This defines a common method which will called for observers once the notifier receives an event
 */
public interface WeatherObserver {
    public void update(WeatherType weatherType);
}
