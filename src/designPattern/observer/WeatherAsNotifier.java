package designPattern.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherAsNotifier {

    private WeatherType currentWeather;
    private List<WeatherObserver> observerList;     //List of notifiers

    public WeatherAsNotifier() {
        observerList = new ArrayList<>();
        currentWeather = WeatherType.SUNNY;
    }

    public void addObserver(WeatherObserver weatherObserver) {
        observerList.add(weatherObserver);
    }

    public void removeObserver(WeatherObserver weatherObserver) {
        observerList.remove(weatherObserver);
    }

    /**
     * This is the function that receives events in notifier and calls the function
     * responsible for notification
     */
    public void timePasses() {
        WeatherType[] enumValues = WeatherType.values();
        System.out.println("Ordinal Value > "+currentWeather.ordinal());
        currentWeather = enumValues[(currentWeather.ordinal() + 1) % enumValues.length];
        System.out.println("The weather has changed to "+ currentWeather);
        notifyObservers();
    }

    /**
     * This is how the notifiers are notified.
     * A common method is called that serves the purpose.
     */
    private void notifyObservers() {
        for(WeatherObserver weatherObserver : observerList) {
            weatherObserver.update(currentWeather);
        }
    }
}
