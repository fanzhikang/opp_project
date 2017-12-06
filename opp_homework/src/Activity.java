import java.util.Comparator;

public class Activity implements Comparator<Activity> {
    private String name;
    private String time;
    private String place;
    private String holder;
    private String slogan;
    private String note;
    private String scale;

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public Activity(){

    }

    public Activity(String name, String time, String place, String holder, String slogan) {
        this.name = name;
        this.time = time;
        this.place = place;
        this.holder = holder;
        this.slogan = slogan;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", place='" + place + '\'' +
                ", holder='" + holder + '\'' +
                ", slogan='" + slogan + '\'' +
                '}';
    }


    @Override
    public int compare(Activity o1, Activity o2) {
        return o1.getTime().compareTo(o2.getTime());
    }
}
