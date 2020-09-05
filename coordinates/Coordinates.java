package coordinates;

public class Coordinates {
    public int longitude;
    public int height;
    public int latitude;

    public Coordinates (int longitude, int latitude, int height) {
        this.height = height;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getLongitude() {
        return longitude;
    }
    public int getLatitude() {
        return latitude;
    }
    public int getHeight() {
        return height;
    }
}