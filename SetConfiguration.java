import java.util.Scanner;

public class SetConfiguration {
    protected String way;
    public void configuration () {
        System.out.println("Enter the way do you want use in parking (first come OR best fit)");
        Scanner scanner = new Scanner(System.in);
        way = scanner.nextLine();
    }
}
