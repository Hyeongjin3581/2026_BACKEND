package day01;

import java.util.Scanner;
public class Exam3 {
    public static void main(String[] args) {
        // [1] 출력함수
        // System(클래스).out(출력객체).print(출력함수)
        // 1. println() 출력 후 자동 줄바꿈.
        System.out.println("자바");
        System.out.print("자바안녕");
        // [3] 이스케이프/제어 문자
        // \n줄바꿈 ,  \t들여쓰기,   \" \'\\""
        System.out.println("\n자바안녕3\t자바안녕4\" \'\\");

        // 3. System.out.printf("형식" , "자료")
        // %s : 문자열이 들어갈 자리 , %c : 문자가 들어갈 자리
        // %d : 정수가 들어갈 자리,  %f : 실수가 들어갈 자리
            // %자릿수d: 자릿수 만큼 자리 차지. 만일 비어있으면 공백 / 오른쪽정렬
            // %-자릿수d: 자릿수 만큼 자리 차지. 만일 비어있으면 공백 / 왼쪽정렬
            // %0자릿수d: 자릿수 만큼 자리 차지. 만일 비어있으면 0으로 채움.  
            // %전체자릿수.소수자릿수f
        System.out.printf("저는 %s 이고 나이는 %d입니다.", "유재석", 40);
        System.out.printf("\n 저는 %s이고 나이는 %6d입니다.\n","유재석",40);
        System.out.printf("\n 저는 %s이고 나이는 %-6d입니다.\n","유재석",40);
        System.out.printf("\n 저는 %s이고 나이는 %06d입니다.\n","유재석",40);
        System.out.printf("\n 저는 %-6s이고 점수는 %5.2f입니다.\n","유재석",123.45678);
    
        // [3] 입력객체/함수
        // 1. Scanner  : SC + 엔터 , *코드파일 상단에 import java.util.Scanner; 자동추가 확인*
        // 2. Scanner : 관례적으로 변수명은 클래스명의 소문자
        // 3.  = 대입
        // 4.  new : 인스턴스화, 해당 클래스로 객체 만든다는 뜻
        // 5. Scanner(System.in) : 생성자(클래스명과 동일)안에 시스템입력(System.in)  객체
        // * 클래스 수업 전까지는 해당 코드 복붙하자.
        Scanner sc = new Scanner(System.in);
        
        // [입력함수]
        // 6. scanner.next();
        sc.next(); // 터미널(콘솔) 창에서 아무거나 입력후 엔터 기준으로 입력 마침.
    
    }
}
