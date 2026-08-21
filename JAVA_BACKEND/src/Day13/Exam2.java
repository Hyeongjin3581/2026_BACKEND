package Day13;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Exam2 {
    public static void main(String[] args) {
        
        //  [1] 래퍼 클래스 : 사용목적 --> 기본 타입을 참조타입으로 변환 , 참조타입은 상태와 기능을 갖기 때문. 
        int value1 = 100;   // 자료가 100이고 ,타입이 int 
        Integer value2 = 100;  
        // System.out.println(value1.toString);  안됨 / 기본타입에는 메서드가 없다.
        System.out.println(value2.toString());  // 리터럴 값들도 매핑하여 기능을 활용할려고 사용. 

        // 1. 언박싱 과 오토박싱
        int value3 = value2; // Integer --> int(기본) 변환  <언박싱>
        Integer value4 = value1;  // int(기본) --> Integer(참조)    <오토박싱>
        // DTO : 포장(래퍼), 정보가 많으니깐    

        // 2. 타입변환(csv, excel, api, python, json,xml 등등)
        // xxxx.parseXXX( 문자열 )  ,   유사(JDBC) : rs.getXXX( )
        int value5 = Integer.parseInt("100");  //   "100" --> 100 스프링에서 자동
        double value6 = Double.parseDouble("3.14"); // "3.14" --> 3.14
        boolean value7 = Boolean.parseBoolean("true"); // "true" --> true로 변환.
        // 기본타입 --> 문자열 변환

        // [2] 날짜

        //1. 현재 날짜 가져오기
        LocalDate localDate = LocalDate.now();
        System.out.println( localDate);
        //2. 현재 시간 가져오기
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        // 3. 현재 날짜/시간 가져오기
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        //4. 정해진 날짜/시간 객체 생성 LocalDateTime.of(연도,월,일,시,분,초) : 오버로딩
        LocalDateTime localDateTime2 = LocalDateTime.of(2026,8,19,11,10,1);
        System.out.println(localDateTime2);
        //5.정해진 형식으로 날짜/시간 표현  ,  DateTimeFormatter.ofPattern(패턴);
        // 패턴 : y연도 m월 d일 h시 m분 s초 , 날짜/시간객체.format( 패턴객체 );
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("y년M월d일 h시m분s초");
        System.out.println( localDateTime2.format(formatter));
        //6. 날짜 계산  ,   날짜/ 시각객체.plusXXX( 수 )
        LocalDateTime result1 = localDateTime2.plusDays(20);    // 기존 localDateTime2값에 +20일
        System.out.println( result1);   // 2026-09-08T11:10:01
        LocalDateTime result2 = localDateTime2.minusDays(20);   // 기존 localDateTime2값에 -20일
        System.out.println(result2);    // 2026-07-30T11:10:01
        // 7. 특정한 날짜/시간 추출
        System.out.println(localDateTime2.getYear());               // 연도(숫자)
        System.out.println(localDateTime2.getMonth());           // 달(영문)
        System.out.println(localDateTime2.getMonthValue());  //  달(숫자)
        System.out.println(localDateTime2.getDayOfMonth()); // 일(숫자)
        System.out.println(localDateTime2.getHour());              // 시간
        System.out.println(localDateTime2.getMinute());          // 분
        System.out.println((localDateTime2.getSecond()));         // 초 
    }   // main end
}
