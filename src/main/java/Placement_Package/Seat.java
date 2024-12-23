package Placement_Package;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Seat {

    private List<Integer> frontSeats = new ArrayList<>(List.of(1, 2, 3, 4));
    private List<Integer> middleSeats = new ArrayList<>(List.of(5, 6, 7, 8, 9, 10, 11, 12));
    private List<Integer> backSeats = new ArrayList<>(List.of(13, 14, 15, 16));
    private Random random = new Random();

    public int getRemainingSeatsCount(int zone) {
        if (zone == 1) {
            return frontSeats.size();
        } else if (zone == 2) {
            return middleSeats.size();
        } else if (zone == 3) {
            return backSeats.size();
        }
        return 0;
    }

    public int getTotalRemainingSeats() {
        return frontSeats.size() + middleSeats.size() + backSeats.size();
    }

    // 선호 구역에서 랜덤으로 좌석을 배정
    public int assignSeat(int preferredZone) {
        int assignedSeat = -1;

        if (preferredZone == 1 && !frontSeats.isEmpty()) {

            int randomIndex = random.nextInt(frontSeats.size());
            assignedSeat = frontSeats.remove(randomIndex);
        } else if (preferredZone == 2 && !middleSeats.isEmpty()) {

            int randomIndex = random.nextInt(middleSeats.size());
            assignedSeat = middleSeats.remove(randomIndex);
        } else if (preferredZone == 3 && !backSeats.isEmpty()) {

            int randomIndex = random.nextInt(backSeats.size());
            assignedSeat = backSeats.remove(randomIndex);
        }

        return assignedSeat;
    }

    public boolean isZoneFull(int zone) {
        if (zone == 1) {
            return frontSeats.isEmpty();
        } else if (zone == 2) {
            return middleSeats.isEmpty();
        } else if (zone == 3) {
            return backSeats.isEmpty();
        }
        return true;
    }

    public boolean areAllSeatsAssigned() {
        return frontSeats.isEmpty() && middleSeats.isEmpty() && backSeats.isEmpty();
    }
}