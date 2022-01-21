package entity;

public class Driver extends Person{
    private int id;
    private String drivingSkill;

    public Driver(String name, String address, String phone, int id, String drivingSkill) {
        super(name, address, phone);
        this.id = id;
        this.drivingSkill = drivingSkill;
    }

    public Driver(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDrivingSkill() {
        return drivingSkill;
    }

    public void setDrivingSkill(String drivingSkill) {
        this.drivingSkill = drivingSkill;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", drivingSkill='" + drivingSkill + '\'' +
                "} " + super.toString();
    }
}
