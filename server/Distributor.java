

public class Distributor extends User{
	private int time;
	
    public Distributor(String name, boolean[] foodType, double latitude, double longitude, int size, int time) {
    	super(name, foodType, latitude, longitude, size);
    	this.time = time;
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

    public int getTime() {
        return time;
    }

    public int getSize() {
        return super.getSize();
    }


}
