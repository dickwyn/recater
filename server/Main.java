import java.util.ArrayList;

public class Main {

    ArrayList<Consumer> consumers;
    public static void main(String[] args) {
        consumers = new ArrayList<Consumer>();
    }

    public void Request (Distributor dist)
    {
        for ( Consumer i : consumers) {
            dist.compareTo(consumers); // this is not right, need fixing in syntax
        }
    }
}
