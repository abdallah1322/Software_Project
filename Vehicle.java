public class Vehicle {
    protected String model_name;
    protected int id_number;
    protected int model_year;
    protected double widthVehicle;
    protected double depthVehicle;
    protected int parkSlotId;
    public Vehicle(String model_name, int id_number, int model_year, double widthVehicle, double depthVehicle){
        this.model_name = model_name;
        this.id_number = id_number;
        this.model_year = model_year;
        this.widthVehicle = widthVehicle;
        this.depthVehicle = depthVehicle;
    }
}
