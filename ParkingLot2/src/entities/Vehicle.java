package entities;

public class Vehicle {
    String type;

    public Vehicle(String _type, String _number) {
        this.type = _type;
        this.number = _number;
    }

    public Vehicle() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    String number;
}
