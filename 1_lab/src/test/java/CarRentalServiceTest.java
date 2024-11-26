import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class CarRentalServiceTest {

    private List<Car> cars;
    private List<Rental> rentals;

    @BeforeMethod
    public void setUp() {
        // Створення дат виробництва автомобілів
        LocalDate manufactureDate1 = LocalDate.of(2010, 5, 20);
        LocalDate manufactureDate2 = LocalDate.of(2015, 8, 15);
        LocalDate manufactureDate3 = LocalDate.of(2008, 3, 10);

        // Створення автомобілів із зазначеними датами
        cars = new ArrayList<>();
        cars.add(new Car("Toyota", "VIN12345", "AA1234BB", manufactureDate1, 150000));
        cars.add(new Car("Honda", "VIN67890", "BB5678CC", manufactureDate2, 90000));
        cars.add(new Car("Ford", "VIN11223", "CC9101DD", manufactureDate3, 200000));

        // Створення дат початку та закінчення оренди
        LocalDate rentalStartDate1 = LocalDate.of(2023, 1, 1);
        LocalDate rentalEndDate1 = LocalDate.of(2023, 1, 10);
        LocalDate rentalStartDate2 = LocalDate.of(2023, 2, 5);
        LocalDate rentalEndDate2 = LocalDate.of(2023, 2, 12);

        // Створення орендаря
        Renter renter = new Renter("Іванов", "Петро", "ID123456", "DL789012");

        // Створення оренд із використанням зазначених дат
        rentals = new ArrayList<>();
        rentals.add(new Rental(cars.get(0), renter, "Київ", "Львів", rentalStartDate1, rentalEndDate1, 50.0, 500.0));
        rentals.add(new Rental(cars.get(1), renter, "Одеса", "Харків", rentalStartDate2, rentalEndDate2, 70.0, 490.0));
    }

    @Test
    public void testSortCarsByMileage() {
        List<Car> sortedCars = CarRentalService.sortCarsByMileage(cars);
        assertEquals(90000, sortedCars.get(0).getMileage());
        assertEquals(150000, sortedCars.get(1).getMileage());
        assertEquals(200000, sortedCars.get(2).getMileage());
    }

    @Test
    public void testSortRentalsByStartDate() {
        List<Rental> sortedRentals = CarRentalService.sortRentalsByStartDate(rentals);
        assertEquals(LocalDate.of(2023, 1, 1), sortedRentals.get(0).getStartDate());
        assertEquals(LocalDate.of(2023, 2, 5), sortedRentals.get(1).getStartDate());
    }

    @Test
    public void testFilterCarsOlderThan() {
        List<Car> filteredCars = CarRentalService.filterCarsOlderThan(cars, 2012);
        assertEquals(2, filteredCars.size());
        assertTrue(filteredCars.stream().anyMatch(car -> car.getBrand().equals("Toyota")));
        assertTrue(filteredCars.stream().anyMatch(car -> car.getBrand().equals("Ford")));
    }

    @Test
    public void testCalculateTotalRentalIncome() {
        double totalIncome = CarRentalService.calculateTotalRentalIncome(rentals);
        assertEquals(totalIncome, 990.0);
    }
}
