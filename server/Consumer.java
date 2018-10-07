
public class Consumer extends User {
	
	public Consumer(String name, boolean[] foodType, double latitude, double longitude, int size) {
		super(name, foodType, latitude, longitude, size);
	}
	
	public String getName() {
		return super.getName();
	}
	
    public boolean[] getFoodType() {
        return super.getFoodType();
    }

    public double getLatitude() {
        return super.getLatitude();
    }

    public double getLongitude() {
        return super.getLongitude();
    }
    
    public int getSize() {
        return super.getSize();
    }

}
