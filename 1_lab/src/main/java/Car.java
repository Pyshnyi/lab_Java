import java.time.LocalDate;
import java.util.Objects;

/**
 * Інформація про автомобіль для оренди.
 */
public class Car {
    private String brand;
    private String vinCode;
    private String licensePlate;
    private LocalDate manufactureDate;
    private int mileage;

    public Car(String brand, String vinCode, String licensePlate, LocalDate manufactureDate, int mileage) {
        this.brand = brand;
        this.vinCode = vinCode;
        this.licensePlate = licensePlate;
        this.manufactureDate = manufactureDate;
        this.mileage = mileage;
    }

    // Геттери і сеттери
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getVinCode() {
        return vinCode;
    }

    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", vinCode='" + vinCode + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", manufactureDate=" + manufactureDate +
                ", mileage=" + mileage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return mileage == car.mileage && Objects.equals(brand, car.brand) && Objects.equals(vinCode, car.vinCode) && Objects.equals(licensePlate, car.licensePlate) && Objects.equals(manufactureDate, car.manufactureDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, vinCode, licensePlate, manufactureDate, mileage);
    }
}
