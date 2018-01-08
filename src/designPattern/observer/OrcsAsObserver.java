package designPattern.observer;

/**
 * This is a Observer for Weather and this will be updated by Weather using update method
 */
public class OrcsAsObserver implements WeatherObserver {

    @Override
    public void update(WeatherType weatherType) {
        switch (weatherType) {
            case COLD:
                System.out.println("The orcs are freezing cold.");
                break;
            case RAINY:
                System.out.println("The orcs are dripping wet.");
                break;
            case SUNNY:
                System.out.println("The sun hurts the orcs' eyes.");
                break;
            case WINDY:
                System.out.println("The orc smell almost vanishes in the wind.");
                break;
            default:
                break;
        }
    }
}
