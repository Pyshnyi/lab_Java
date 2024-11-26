import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.Comparator;

public class CarRentalService {

    private final List<Rental> rentals;

    /**
     * Конструктор для CarRentalService, приймає список оренд.
     *
     * @param rentals список оренд, які керують процесом оренди.
     * @throws IllegalArgumentException якщо список оренд є null
     */
    public CarRentalService(List<Rental> rentals) {
        if (rentals == null) {
            throw new IllegalArgumentException("Rental list cannot be null");
        }
        this.rentals = rentals;
    }

    /**
     * Повертає список усіх оренд.
     *
     * @return список оренд.
     */
    public List<Rental> getRentals() {
        return rentals;
    }

    /**
     * Додає оренду до списку оренд.
     *
     * @param rental оренда, яку потрібно додати.
     * @throws IllegalArgumentException якщо оренда є null
     */
    public void addRental(Rental rental) {
        if (rental != null) {
            this.rentals.add(rental);
        } else {
            throw new IllegalArgumentException("Rental cannot be null");
        }
    }

    /**
     * Видаляє оренду зі списку оренд.
     *
     * @param rental оренда, яку потрібно видалити.
     * @throws IllegalArgumentException якщо оренда є null
     */
    public void removeRental(Rental rental) {
        if (rental != null) {
            this.rentals.remove(rental);
        } else {
            throw new IllegalArgumentException("Rental cannot be null");
        }
    }

    // 1. Метод для сортування автомобілів за пробігом (Comparable)
    public static List<Car> sortCarsByMileage(List<Car> cars) {
        Collections.sort(cars, Comparator.comparingInt(Car::getMileage));
        return cars;
    }

    // 2. Метод для сортування оренд за датою початку (Comparator)
    public static List<Rental> sortRentalsByStartDate(List<Rental> rentals) {
        return rentals.stream()
                .sorted(Comparator.comparing(Rental::getStartDate))
                .collect(Collectors.toList());
    }

    // 3. Метод для фільтрації автомобілів, які старші заданого року (Stream API)
    public static List<Car> filterCarsOlderThan(List<Car> cars, int year) {
        return cars.stream()
                .filter(car -> car.getManufactureDate().getYear() < year)
                .collect(Collectors.toList());
    }

    // 4. Метод для підрахунку загальної вартості всіх оренд
    public static double calculateTotalRentalIncome(List<Rental> rentals) {
        return rentals.stream()
                .mapToDouble(Rental::getTotalCost)
                .sum();
    }
}
