package aircrafts;

public class Coordinates {
    private int longitude;
    private int height;
    private int latitude;

    Coordinates (int longitude, int latitude, int height) {
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

    public void setHeight(int height) {
        this.height = height;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }
}