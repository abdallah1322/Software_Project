import java.util.*;

public class ParkIn extends OperationsInSlots {
    protected String startoftime;
    protected Time calculatetime;
    public void park_in (SetConfiguration setcon, OperationsInSlots sl) {
        calculatetime = new Time();
        System.out.println("Type (yes) if you want to see available slots before parking.");
        Scanner scanner = new Scanner(System.in);
        String ans1 = scanner.nextLine();
        if (Objects.equals(ans1, "yes")) {
            sl.displayavailable();
        }
        String ans2;
        System.out.println("Would you like to park in for new car?");
        ans2 = scanner.nextLine();
        while (Objects.equals(ans2, "yes")) {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter the information of your car\nCar width: ");
            double width = input.nextDouble();
            System.out.print("Car depth: ");
            double depth = input.nextDouble();
            System.out.print("Car model name: ");
            String model = input.next();
            System.out.print("Car model year: ");
            int year = input.nextInt();
            System.out.print("Car identification number: ");
            int id = input.nextInt();
            Vehicle c = new Vehicle(model, id, year, width, depth);
            System.out.println("Car info saved successfully.");
            if (Objects.equals(setcon.way, "first come")) {
                int flag = 0;
                if (sl.busy == sl.sizeofslots) {
                    System.out.println("We are sorry garage is busy, There is no available slot right now.");
                } else {
                    for (int i = 0; i < sl.sizeofslots; i++) {
                        if (c.widthVehicle == sl.v.get(i).widthSlot && c.depthVehicle == sl.v.get(i).depthSlot && sl.light.get(i) == 0 ||
                                c.widthVehicle < sl.v.get(i).widthSlot || c.depthVehicle < sl.v.get(i).depthSlot && sl.light.get(i) == 0) {
                            sl.light.add(i, 1);
                            busy++;
                            flag = 1;
                            c.parkSlotId = sl.v.get(i).SlotId;
                            System.out.println("Enjoy parking.");
                            startoftime = calculatetime.timee();
                            break;
                        }
                    }
                    if (flag == 0) {
                        System.out.println("Unsuccessful parking.");
                    }
                    System.out.println("\nType (yes) if you want to see available slots now.");
                    String s1 = scanner.nextLine();
                    if (Objects.equals(s1, "yes")) {
                        sl.displayavailable();
                    }
                }
            }
            else
            {
                int index = 0;
                int flag = 0;
                Vector<Double> v2 = new Vector<>();
                for (int j = 0; j < sl.sizeofslots; j++) {
                    v2.add(sl.v.get(j).depthSlot * sl.v.get(j).widthSlot);
                }
                for (int i = 0; i < sl.sizeofslots - 1; ++i) {
                    for (int j = sl.sizeofslots - 1; j > i; --j) {
                        if (v2.get(j) < v2.get(j - 1)) {
                            Collections.swap(v2, j - 1, j);
                            Collections.swap(sl.v, j - 1, j);
                        }
                    }
                }
                for (int i = 0; i < sl.sizeofslots; i++) {
                    if (v2.get(i) == c.depthVehicle * c.widthVehicle && sl.light.get(i) == 0 || v2.get(i) > c.depthVehicle * c.widthVehicle && sl.light.get(i) == 0) {
                        flag = 1;
                        index = i;
                        break;
                    }
                }
                if (flag == 0) {
                    System.out.println("Unsuccessful parking.");
                } else {
                    busy++;
                    sl.light.add(index, 1);
                    c.id_number = sl.v.get(index).SlotId;
                    System.out.println("Please go park your car in slot number (" + (index + 1) + ") With dimensions: " + sl.v.get(index).widthSlot + " x " + sl.v.get(index).depthSlot);
                    startoftime = calculatetime.timee();
                }
                System.out.println("\nType (yes) if you want to see available slots now.");
                String s2 = scanner.nextLine();
                if (Objects.equals(s2, "yes")) {
                    sl.displayavailable();
                }
            }
            System.out.println("Would you like to park in for new car again?");
            ans2 = scanner.nextLine();
        }
    }
}