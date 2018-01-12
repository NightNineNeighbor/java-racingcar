package car;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Race {

    private List<Car> cars;
    private int tryNumber;
    private final int MOVABLES_RANGE = 9;
    private final int MOVABLES_STANDARD_NUMBER = 4;

    public Race(List<Car> cars, int tryNumber) {
        this.cars = cars;
        this.tryNumber = tryNumber;
    }

    private void moveCars(List<Car> cars){
        cars.forEach(car -> car.move(MOVABLES_RANGE, MOVABLES_STANDARD_NUMBER));
    }

    public void startRacing() {
        IntStream.range(0, this.tryNumber).forEach(i -> moveCars(cars));
    }

    public List<Car> calCulateWinners(List<Car> cars){
        int maxPosition = getMaxPositionCar(cars).getPosition();
        return cars.stream().filter(car->car.getPosition() == maxPosition).collect(Collectors.toList());
    }

    private Car getMaxPositionCar(List<Car> cars) {
        return cars.stream().max(Car::compareTo).orElse(new Car("",0));
    }

    public List<Car> getCars() {
        return cars;
    }
}
