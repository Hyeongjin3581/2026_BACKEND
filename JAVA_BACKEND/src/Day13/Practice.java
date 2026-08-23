package Day13;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        
        String carParkingList = "3,211가6231,202608190930\n8,452하1234,202608171227\n";
        
        // 1. 데이터 초기화: 줄바꿈(\n) 기준으로 분할하여 ArrayList에 저장
        String[] strAry1 = carParkingList.split("\n");
        ArrayList<String> strAry2 = new ArrayList<>();
        for (int i = 0; i < strAry1.length; i++) {
            strAry2.add(strAry1[i]);
        }
        System.out.println(strAry2);
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print("\n1.위치찾기 2.입차 3.출차 4.종료 선택 : ");
            int ch = scan.nextInt();
            
            // 1. 위치 찾기 구현
            if (ch == 1) { 
                System.out.print("차량 번호를 입력: ");
                String carNumber = scan.next();
                boolean isFound = false;

                for (int i = 0; i < strAry2.size(); i++) {
                    String[] info = strAry2.get(i).split(","); 
                    
                    if (info[1].equals(carNumber)) { 
                        System.out.println("주차 위치 번호 : " + info[0]); 
                        isFound = true;
                        break;
                    }
                }

                if (!isFound) {
                    System.out.println("미등록 차량.");
                }
            } 
            
            // 2. 입차 구현
            else if (ch == 2) { 
                System.out.print("차량 위치번호 입력 : ");
                String location = scan.next();
                boolean 검사 = false;

                // 중복 위치 검사 (유효성 검사)
                for (int i = 0; i < strAry2.size(); i++) {
                    String[] info = strAry2.get(i).split(",");
                    if (info[0].equals(location)) {
                        검사 = true;
                        break;
                    }
                }

                if (검사) {
                    System.out.println("중복 주차할 수 없습니다.");
                } else {
                    System.out.print("차량번호 입력 : ");
                    String carNumber = scan.next();
                    System.out.print("입차일시 입력(YYYYMMDDhhmm) : ");
                    String dateTime = scan.next();

                    // 신규 차량 행 데이터 생성 후 리스트에 추가
                    String newRecord = location + "," + carNumber + "," + dateTime;
                    strAry2.add(newRecord);

                    // carParkingList 문자열 동기화
                    carParkingList += newRecord + "\n";
                    
                    System.out.println("입차 성공");
                    System.out.println("[현재 주차 목록]\n" + carParkingList);
                }
            }

            // 3. 출차 구현
            else if (ch == 3) { 
                System.out.print("출차할 차량번호를 입력 : ");
                String carNumber = scan.next();
                boolean isFound = false;

                // ConcurrentModificationException 방지를 위해 일반 인덱스 for문 사용
                for (int i = 0; i < strAry2.size(); i++) {
                    String car = strAry2.get(i);
                    String[] info = car.split(",");
                    
                    if (info[1].equals(carNumber)) {
                        isFound = true;

                        int year = Integer.parseInt(info[2].substring(0, 4));      
                        int month = Integer.parseInt(info[2].substring(4, 6));     
                        int day = Integer.parseInt(info[2].substring(6, 8));       
                        int hur = Integer.parseInt(info[2].substring(8, 10));      
                        int min = Integer.parseInt(info[2].substring(10, 12));      
                        
                        LocalDateTime inTime = LocalDateTime.of(year, month, day, hur, min); 
                        LocalDateTime now = LocalDateTime.now(); 
                        
                        // Duration을 이용해 정확한 총 차이 분(minute) 계산
                        long totalMinutes = Duration.between(inTime, now).toMinutes();
                        if (totalMinutes < 0) totalMinutes = 0;
                        
                        // 요금 계산 (일자 단위 + 잔여 분)
                        long days = totalMinutes / (24 * 60);          // 일수
                        long remainMinutes = totalMinutes % (24 * 60); // 일수 제외한 남은 분
                        long remainFee = 0;

                        if (remainMinutes > 30) {
                            long billableMinutes = remainMinutes - 30;
                            remainFee = ((billableMinutes + 9) / 10) * 1000; // 10분 단위 올림
                        }
                        if (remainFee > 20000) {
                            remainFee = 20000; // 1일 최대 20,000원 제한
                        }
                        long totalFee = (days * 20000) + remainFee;
                        
                        System.out.println("\n====== 출차 안내 ======");
                        System.out.println("차량번호: " + carNumber);
                        System.out.println("입차시간: " + inTime); 
                        System.out.println("출차시간: " + now);    
                        System.out.println("주차시간: " + totalMinutes + "분 (" + days + "일 " + remainMinutes + "분)");
                        System.out.println("주차요금: " + totalFee + "원");
                        System.out.println("=====================");
                        
                        // 1) 전체 문자열에서 해당 차량 정보 제거
                        carParkingList = carParkingList.replace(info[0] + "," + info[1] + "," + info[2] + "\n", "");
                        
                        // 2) 리스트(strAry2)에서도 함께 제거 (동기화)
                        strAry2.remove(i);

                        break;
                    } 
                }

                if (!isFound) {
                    System.out.println("차량을 찾지 못했습니다.");
                }
            } 

            // 4. 종료
            else if (ch == 4) {
                System.out.println("프로그램 종료.");
                break;
            }
        }
    }
}