import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    
    public static void main(String[] args) {
    	ArrayList<User> consumers = new ArrayList<User>();
    	
    }

    public Map<Integer, User> requestConsumer(User dist, ArrayList<User> consumers) {
    	Map<Integer, User> rankedConsumers = new HashMap<Integer, User>(consumers.size());
    	
    	for (User c : consumers) {
            int rank = dist.compareTo(c);
            if (rank >= 0) {
            	while(rankedConsumers.containsKey(rank)) {
            		rank++;
            	}

            	rankedConsumers.put(rank, c);
            }
        }
        
        return rankedConsumers;
    }
}
