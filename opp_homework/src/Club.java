import java.util.Comparator;

public class Club implements Comparator<Club>{
    private String name ;
    private String time;
    private String manager_name;

    private String manager_tel;
    private String manager_mail;
    private String members;
    private String acts;

    public String getActs() {
        return acts;
    }

    public void setActs(String acts) {
        this.acts = acts;
    }

    private Picture[] pictures;

    public Picture[] getPictures() {
        return pictures;
    }

    public void setPictures(Picture[] pictures) {
        this.pictures = pictures;
    }

    public Club() {
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public Club(String name, String time, String manager_name, String manager_tel, String manager_mail,String members) {
        this.name = name;
        this.time = time;
        this.manager_name = manager_name;
        this.manager_tel = manager_tel;
        this.manager_mail = manager_mail;
        this.members=members;
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

    public String getManager_name() {
        return manager_name;
    }

    public void setManager_name(String manager_name) {
        this.manager_name = manager_name;
    }

    public String getManager_tel() {
        return manager_tel;
    }

    public void setManager_tel(String manager_tel) {
        this.manager_tel = manager_tel;
    }

    public String getManager_mail() {
        return manager_mail;
    }

    public void setManager_mail(String manager_mail) {
        this.manager_mail = manager_mail;
    }

    @Override
    public String toString() {
        return "Club{" +
                "name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", manager_name='" + manager_name + '\'' +
                ", manager_tel='" + manager_tel + '\'' +
                ", manager_mail='" + manager_mail + '\'' +
                ", members='" + members + '\'' +
                '}';
    }

    @Override
    public int compare(Club o1, Club o2) {
        return o1.getActs().split("、").length-o2.getActs().split("、").length;

    }

//    public abstract class NumComparator implements Comparator{
//
//    }
}
