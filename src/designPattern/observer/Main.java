package designPattern.observer;

public class Main {

    public static void main(String[] args) {
        WeatherAsNotifier notifier = new WeatherAsNotifier();
        notifier.addObserver(new OrcsAsObserver());
        notifier.addObserver(new HobbitsAsObserver());

        notifier.timePasses();
        notifier.timePasses();
        notifier.timePasses();
        notifier.timePasses();
        notifier.timePasses();
    }
}
