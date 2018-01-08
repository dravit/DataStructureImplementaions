package designPattern.observer;

/**
 * This is a Observer for Weather and this will be updated by Weather using update method
 */
public class HobbitsAsObserver implements WeatherObserver {

    @Override
    public void update(WeatherType weatherType) {
        switch (weatherType) {
            case COLD:
                System.out.println("The hobbits are shivering in the cold weather.");
                break;
            case RAINY:
                System.out.println("The hobbits look for cover from the rain.");
                break;
            case SUNNY:
                System.out.println("The happy hobbits bade in the warm sun.");
                break;
            case WINDY:
                System.out.println("The hobbits hold their hats tightly in the windy weather.");
                break;
            default:
                break;
        }
    }
}
