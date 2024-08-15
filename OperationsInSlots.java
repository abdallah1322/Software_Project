import java.util.Scanner;
import java.util.Vector;

public class OperationsInSlots extends Slot implements SLotInterface{
    protected int sizeofslots;
    protected static int busy;
    public Vector<Slot> v = new Vector<>();
    public Vector<Integer> light = new Vector<>();
    public void allocateslots() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of slots");
        sizeofslots = input.nextInt();
        System.out.println("Enter the width and depth for each slot");
        for (int i = 0; i < sizeofslots; i++) {
            System.out.print("SlotID (" + (i + 1) + "): ");
            int id = input.nextInt();
            System.out.print("Slot (" + (i + 1) + ") Width: ");
            double width = input.nextDouble();
            System.out.print("Slot (" + (i + 1) + ") Depth: ");
            double depth = input.nextDouble();
            Slot s = new Slot(id,width, depth);
            v.add(s);
            light.add(0);
        }
        System.out.println("---------------------Garage info set successfully---------------------\n");
    }
    public void displayavailable(){
        if (sizeofslots - busy == 0){
            System.out.println("\n the Garage is full now");
        }
        else {
            System.out.println("\nNumber of available slots: " + (sizeofslots - busy) + "\nDetails of Slots");
            for (int i = 0; i < sizeofslots; i++) {
                if (light.get(i) == 0) {
                    System.out.println("Slot (" + (i + 1) + ")\tDimensions: " + v.get(i).widthSlot + " x " + v.get(i).depthSlot);
                }
            }
        }
    }
    public int getAvailable(){
        return sizeofslots - busy;
    }
}