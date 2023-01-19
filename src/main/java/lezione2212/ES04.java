package lezione2212;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ES04 {

    public static Car findCarByPlate(List<Car> cars, String licencePlate) {
        for (Car car : cars) {
            if (car.getLicencePlate().equals(licencePlate)) {
                return car;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Fiat", "Punto", "AA333GG"));
        cars.add(new Car("Fiat", "Panda", "AA334AA"));
        cars.add(new Car("Fiat", "Doblo", "AA333BB"));
        cars.add(new Car("Fiat", "Brava", "ZZ888GG"));
        System.out.println(findCarByPlate(cars, "AA333BB"));

        Map<String, Car> map = new HashMap<>();
        map.put("AA333GG", new Car("Fiat", "Punto", "AA333GG"));
        map.put("AA334AA", new Car("Fiat", "Panda", "AA334AA"));
        map.put("AA333BB", new Car("Fiat", "Doblo", "AA333BB"));
        map.put("ZZ888GG", new Car("Fiat", "Brava", "ZZ888GG"));
        System.out.println(map.get("AA334AA"));
    }
}
