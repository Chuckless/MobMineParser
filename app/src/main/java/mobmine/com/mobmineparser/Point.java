package mobmine.com.mobmineparser;

/**
 * Created by lucas on 19/04/16.
 */
public class Point {

    private float Xcord, Ycord, Zcord;
    private int id;
    private String type;

    public float getXcord() {
        return Xcord;
    }

    public void setXcord(float xcord) {
        Xcord = xcord;
    }

    public float getYcord() {
        return Ycord;
    }

    public void setYcord(float ycord) {
        Ycord = ycord;
    }

    public float getZcord() {
        return Zcord;
    }

    public void setZcord(float zcord) {
        Zcord = zcord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Point{" +
                "id=" + id +
                ", Xcord=" + Xcord +
                ", Ycord=" + Ycord +
                ", Zcord=" + Zcord +
                ", type='" + type + '\'' +
                '}';
    }
}
