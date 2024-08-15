import java.util.Scanner;

public class ParkOut extends ParkIn {
    public int hourRate=5;
    public int fees;
    public static int totalincome;
    public void payment(OperationsInSlots sl , String starttime) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter parkSlotId");
        int idpark = input.nextInt();
        calculatetime = new Time();
        String endtime;
        endtime = calculatetime.timee();
        int flagg=0;
        for (int i = 0; i < sl.sizeofslots; i++) {
            if (idpark == sl.v.get(i).SlotId && sl.light.get(i) == 1){
                fees = hourRate * calculatetime.findDifference(starttime,endtime);
                sl.light.add(i, 0);
                totalincome+=fees;
                if (busy > 0)
                    busy--;
                flagg=1;
                System.out.println("fees here is " + fees);
            }
        }
        if (flagg == 0){
            System.out.println("there is no slot with this id");
        }
    }
}
