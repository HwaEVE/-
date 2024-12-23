package Placement_Package;

public class User {

    private String name;
    private int preferredZone;
    private int assignedSeat = -1;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPreferredZone() {
        return preferredZone;
    }

    public void setPreferredZone(int preferredZone) {
        this.preferredZone = preferredZone;
    }

    public int getAssignedSeat() {
        return assignedSeat;
    }

    public void setAssignedSeat(int assignedSeat) {
        this.assignedSeat = assignedSeat;
    }
}
