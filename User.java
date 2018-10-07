abstract class User implements Comparable<User> {
    private boolean[] foodType;
    private double locationX;
    private double locationY;
    private int time;
    private int size;

    public User () {
        foodType = new boolean[4];
        locationX = 0.0;
        locationY = 0,0
        time = 0;
        size = 0;
    }

    public User(boolean[] foodType, double locationX, double locationY, int time, int size) {
        this.foodType = foodType;
        this.locationX = locationX;
        this.locationY = locationY;
        this.time = time;
        this.size = size;
    }

    public boolean[] getFoodType()
    {
        return foodType;
    }

    public double getX() {
        return locationX;
    }

    public double getY() {
        return locationY;
    }

    public int getTime() {
        return time;
    }

    public int getSize() {
        return size;
    }

    public int compareTo(User other) {
        
    }
}
