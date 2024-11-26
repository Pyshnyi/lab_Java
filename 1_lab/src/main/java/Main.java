import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Створюємо автомобіль
        Car car = new Car("Toyota", "1HGCM82633A123456", "AB1234CD", LocalDate.of(2020, 1, 15), 25000);

        // Створюємо орендаря
        Renter renter = new Renter("Doe", "John", "ID123456", "DL123456");

        // Використовуємо будівельник для створення оренди
        Rental rental = new RentalBuilder()
                .setVehicle(car)
                .setClient(renter)
                .setPickupLocation("Kyiv")
                .setDropoffLocation("Lviv")
                .setStartDate(LocalDate.of(2024, 10, 1))
                .setEndDate(LocalDate.of(2024, 10, 10))
                .setDailyRate(50.0)
                .setTotalCost(500.0)
                .build();

        // Виводимо інформацію про оренду
        System.out.println(rental);
    }
}
