package Placement_Package;

public class Application {
    public static void main(String[] args) {

        // SeatAssignment 객체 생성
        SeatAssignment seatAssignment = new SeatAssignment();

        // 사용자 정보 입력
        seatAssignment.inputUsers();

        // 선호 구역 입력 받기 및 좌석 배정
        seatAssignment.inputPreferredZones();

        // 배정된 좌석 결과를 출력
        seatAssignment.printSeatAssignments();
    }
}
