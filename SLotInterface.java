import java.io.IOException;

public interface SLotInterface {
    void allocateslots() throws IOException;
    void displayavailable();
    int getAvailable();
}