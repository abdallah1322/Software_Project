import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("---------------------Information of Garage System---------------------");
        Scanner input = new Scanner(System.in);
        System.out.println("Set your configuration");
        SetConfiguration ss = new SetConfiguration();
        ss.configuration();
        OperationsInSlots sl = new OperationsInSlots();
        sl.allocateslots();
        ParkIn p = new ParkIn();
        p.park_in(ss,sl);
        String type;
        System.out.println("if you want to park out");
        type = input.next();
        while (Objects.equals(type, "yes")) {
            ParkOut pa = new ParkOut();
            pa.payment(sl,p.startoftime);
            System.out.println("if you want to park out again");
            type = input.next();
        }
        String type2;
        System.out.println("if you want to show total income");
        type2 = input.next();
        if (type2.equals("yes")){
            Income in = new Income();
            in.showIncome();
        }
        String type3;
        System.out.println("if you want to show number of vehicles used the garage ");
        type3 = input.next();
        if (type3.equals("yes")) {
            ShowVehiclesUsedGarage s = new ShowVehiclesUsedGarage();
            s.ShowNumberVehicleUsedGarage();
        }
    }
}

