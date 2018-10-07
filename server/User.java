public class User implements Comparable<User> {
    protected boolean[] foodType;
    protected double latitude;
    protected double longitude;
    protected int size;

    public User () {
        foodType = new boolean[4];
        latitude = 0.0;
        longitude = 0.0;
        size = 0;
    }

    public User(boolean[] foodType, double latitude, double longitude, int size) {
        this.foodType = foodType;
        this.latitude = latitude;
        this.longitude = longitude;
        this.size = size;
    }

    public boolean[] getFoodType()
    {
        return foodType;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getSize() {
        return size;
    }

    public int compareTo(User other) {
    	int rank = 0;
    	for (int i = 0; i < foodType.length; i++) {
    		if (this.getFoodType()[i] != other.getFoodType()[i]) {
    			rank = -1;
    			return rank;
    		}
    	}
    	
    	if (this.getSize() - other.getSize() > 0) {
    		rank = -1;
    		return rank;
    	}
    	
    	rank = (int) distance(this.getLatitude(), other.getLatitude(), this.getLongitude(), other.getLongitude());
    	return rank;
    }
    
    private static double distance(double lat1, double lat2, double lon1, double lon2) {

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        distance = Math.pow(distance, 2);

        return Math.round(Math.sqrt(distance) * 100);
    }
}
