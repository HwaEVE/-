package Placement_Package;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SeatAssignment {

    private Scanner scanner = new Scanner(System.in);
    private List<User> users = new ArrayList<>();
    private Seat seat = new Seat();


    public void inputUsers() {
        String[] names = {
                "윤찬영", "정해준", "권상윤", "문인혁", "허재", "이호연", "윤태우",
                "김성락", "전지예", "황승혁", "이채현", "황효진", "김민성", "박현지",
                "문성희", "추민영"
        };

        for (String name : names) {
            users.add(new User(name));
        }
    }


    public void inputPreferredZones() {
        for (User user : users) {
            System.out.println("\n" + user.getName() + "님, 선호하는 구역을 선택해 주세요.");
            int zoneChoice = -1;


            while (zoneChoice < 1 || zoneChoice > 3 || seat.isZoneFull(zoneChoice)) {
                if (seat.isZoneFull(1) && seat.isZoneFull(2) && seat.isZoneFull(3)) {
                    System.out.println("모든 구역의 좌석이 다 찼습니다. 좌석 배정을 종료합니다.");
                    return;
                }

                System.out.println("1. 앞 구역 (1~8번) - " + seat.getRemainingSeatsCount(1) + " 좌석 남음");
                System.out.println("2. 중간 구역 (9~12번) - " + seat.getRemainingSeatsCount(2) + " 좌석 남음");
                System.out.println("3. 뒤 구역 (13~16번) - " + seat.getRemainingSeatsCount(3) + " 좌석 남음");
                System.out.print("구역 번호를 입력하세요 (1, 2, 3 중 선택): ");

                if (scanner.hasNextInt()) {
                    zoneChoice = scanner.nextInt();
                    if (zoneChoice < 1 || zoneChoice > 3) {
                        System.out.println("잘못된 입력입니다. 1, 2, 3 중에서 선택해 주세요.");
                    } else if (seat.isZoneFull(zoneChoice)) {
                        System.out.println("선택하신 구역은 이미 좌석이 모두 찼습니다. 다른 구역을 선택해 주세요.");
                    }
                } else {
                    System.out.println("잘못된 입력입니다. 숫자를 입력해 주세요.");
                    scanner.next();
                }
            }

            user.setPreferredZone(zoneChoice);

            int seatNumber = seat.assignSeat(user.getPreferredZone());
            if (seatNumber != -1) {
                user.setAssignedSeat(seatNumber);
            } else {
                System.out.println(user.getName() + "님에게 좌석을 배정할 수 없습니다.");
            }

        }
    }

    public void printSeatAssignments() {
        System.out.println("\n=== 전체 좌석 배정 결과 ===");
        for (User user : users) {
            if (user.getAssignedSeat() != -1) {
                System.out.println(user.getName() + "님은 구역 " + user.getPreferredZone() + "에서 좌석 " + user.getAssignedSeat() + "번을 선택했습니다.");
            } else {
                System.out.println(user.getName() + "님은 좌석을 배정받지 못했습니다.");
            }
        }
        System.out.println("남은 좌석 수: " + seat.getTotalRemainingSeats());
    }
}
