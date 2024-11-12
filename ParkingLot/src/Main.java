import entity.ParkingLot;
import enums.Command;
import enums.DisplayType;
import enums.VehicleType;
import service.ParkingLotService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


//https://workat.tech/machine-coding/practice/design-parking-lot-qm6hwq4wkhp8

public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        Map<String, Command> stringToCommand = new HashMap<>();
        Map<String, DisplayType> stringToDisplay = new HashMap<>();
        Map<String, VehicleType> stringVehicleTypeMap = new HashMap<>();
        stringToCommand.put("create_parking_lot", Command.CREATE_PARKING_LOT);
        stringToCommand.put("display", Command.DISPLAY);
        stringToCommand.put("park_vehicle", Command.PARK_VEHICLE);
        stringToCommand.put("unpark_vehicle", Command.UNPARK_VEHICLE);
        stringToCommand.put("exit", Command.EXIT);

        stringToDisplay.put("free_count", DisplayType.FREE_COUNT);
        stringToDisplay.put("free_slots", DisplayType.FREE_SLOTS);
        stringToDisplay.put("occupied_slots", DisplayType.OCCUPIED_SLOTS);

        stringVehicleTypeMap.put("CAR", VehicleType.CAR);
        stringVehicleTypeMap.put("BIKE", VehicleType.BIKE);
        stringVehicleTypeMap.put("TRUCK", VehicleType.TRUCK);

        ParkingLotService parkingLotService = new ParkingLotService();


        while(true) {

            Command type = stringToCommand.get(sc.next());
            switch (type) {
                case CREATE_PARKING_LOT :
                    parkingLotService.createParkingLot(new ParkingLot(sc.next(), sc.nextInt(), sc.nextInt()));
                    break;
                case PARK_VEHICLE:
                    parkingLotService.parkVehicle(stringVehicleTypeMap.get(sc.next()),sc.next(), sc.next());
                    break;
                case UNPARK_VEHICLE:
                    parkingLotService.unParkVehicle(sc.next());
                case DISPLAY:
                    parkingLotService.display(stringToDisplay.get(sc.next()), stringVehicleTypeMap.get(sc.next()));
                    break;
                case EXIT:
                    return;

            }
        }
    }
}