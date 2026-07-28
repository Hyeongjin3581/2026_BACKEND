package day01;

public class Exam2 {
    public static void main(String[] args) {
        System.out.println( 3);
        System.out.println( 3.14);
        System.out.println("유");
        System.out.println("유재석");
        System.out.println(true);

        // 1) boolean : true 또는 false 저장하는 타입 ,1byte (8bit -> 1byte)
        boolean bool1 = true;
        System.out.println(bool1);

        // 2) char : ''작은따옴표로 감싼 문자. 1개 저장하는 타입. 2byte
        char ch1 = 'A';
        System.out.println(ch1);

        // 3) String : ""큰따옴표로 감싼 문자 n에 저장하는 타입. N*2byte , 객체(문자열)
        String str1 = "ABC";
        System.out.println(str1);

        // === 정수 ===
        // 4) byte : -128 ~ 128 저장하는타입. 
        byte b1 = 100; System.out.println(b1);
        // 5) short : +-3만정도  ,2byte
        short sh1 = 30000; System.out.println(sh1);
        // 6) int : +-21억 정도 , 4byte
        int i1 = 2000000000; System.out.println(i1);
        // 7) long : +- 21억 정도 , 8byte
        long l1 = 2000000000; System.out.println(l1);
        // === 실수 ===
        // 8) Float : 소수점 8자리 표현. 4byte
        float f1 = 0.0000123F; System.out.println(f1); 
        // 9) double : 소수점 17자리 표현. 8byte * 실수(리터럴) 타입 *
        double d1 = 0.12345567889; System.out.println(d1);

        // 8가지 타입( 기본타입, 리터럴 저장)
        // vs 그 외 타입(참조타입 ,객체/배열/인터페이스 등등)
    }
}
