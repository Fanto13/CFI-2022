package lezione2212;

import java.util.Objects;

public class Car {
    String brand;
    String model;
    String licencePlate;

    public Car(String brand, String model, String licencePlate) {
        this.brand = brand;
        this.model = model;
        this.licencePlate = licencePlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Car car = (Car) o;
        return Objects.equals(brand, car.brand) && Objects.equals(model, car.model) && Objects.equals(licencePlate, car.licencePlate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, licencePlate);
    }

    @Override
    public String toString() {
        return "Car{" + "brand='" + brand + '\'' + ", model='" + model + '\'' + ", licencePlate='" + licencePlate + '\'' + '}';
    }
}
