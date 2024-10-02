interface Vehicle {
    void create();
}

class Car implements Vehicle {
    @Override
    public void create() {
        System.out.println("Car created");
    }
}

class Bike implements Vehicle {
    @Override
    public void create() {
        System.out.println("Bike created");
    }
}

class VehicleFactory {
    public Vehicle getVehicle(String type) {
        if (type.equals("Car")) {
            return new Car();
        } else if (type.equals("Bike")) {
            return new Bike();
        }
        return null;
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        VehicleFactory factory = new VehicleFactory();
        Vehicle vehicle1 = factory.getVehicle("Car");
        vehicle1.create();
        
        Vehicle vehicle2 = factory.getVehicle("Bike");
        vehicle2.create();
    }
}
