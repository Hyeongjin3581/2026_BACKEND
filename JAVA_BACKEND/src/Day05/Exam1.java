package Day05;

public class Exam1 {
    public static void main(String[] args) {
        
        /*
            1. 객체 이란? 상태 또는 행위을 정의(추상)하는것. 
                    -> 주체{본인(어떤 행위를 이끄는 대상)/개발자} vs 객체(어떤 행위에 미치는 대상/ 프로그램내 모든 대상) 
                    -> 상태(값/자료) , 행위(함수/메소드)
            2. 객체지향 프로그래밍 : 개발자(주체)가 컴퓨터내 객체 만들기
            3. 객체 정의 : 클래스(설계도) 기반으로 객체 정의한다.
            4. 클래스란? 객체(추상개념)의 상태와 행위 코드로 정의한곳
                1) *******설계클래스(객체정의용도) 2) main함수 클래스(실행목적용도)****** <-- 이 부분 매우중요
            5. 인스턴스란? 추상으로 된 개념을 클래스로(객체가) 정의된 기반으로 메모리 할당 ( 물리적개념 / 컴퓨터에 저장됨. )
                1) new 연산자 이용. 
        */

        // 1] 객체 만들기
        // 1) 클래스 생성 : 1> : Java 새롭게 만들기 , 2> 현재파일 class { } 밖
        // class 클래스명 { 상태;  행위; }
        // 2) 클래스 { } 안에서 상태(멤버변수) 와 행위(메소드) 코드 작성
        // 3) 실행된(MAIN함수) 에서 객체 생성: 타입명 변수명 = new 생성자( 인수, 인수 )
            // 1. class 타입 -> 참조 타입이다.
            // 2. class 타입은 첫글자 대문자, 기본타입 소문자, 변수명 소문자시작 관례
            // 3. new 연산자 : 클래스 기반으로 (heap) 메모리 할당. 

        new Student();  // 객체 생성
        Student s1 = new Student(); // 객체 생성 후 변수 지정에 저장

        //2] 객체 사용 / 참조
        System.out.println( s1 );       // 1) 객체 저장하고 있는 객체변수명 작성, Day5.Student@372f7a8d
        System.out.println(s1.studentName );// 2) 객체 저장하고 있는 변수명.멤버변수명 , null

        //3] 객체내 멤버변수 값 수정, 변수명.멤버변수명 = 새로운값
        s1.studentName = "유재석 ";        System.out.println(s1.studentName);
        s1.studentID = 10;                          System.out.println(s1.studentID);


        // *] 주의할점 : new 연산자 *1개 당* *1개의* 인스턴스 생성
        Student s2 = new Student();     // 인스턴스 생성            Day05.Student@2f92e0f4  101호
        Student s3 = new Student();     // 인스턴스 생성            Day05.Student@28a418fc  102호
        Student s4 = s2;                        // 인스턴스 참조            Day05.Student@2f92e0f4  101호
        System.out.println(s2); System.out.println(s3); System.out.println(s4);
        s2.studentName = "강호동";
        System.out.println(s2.studentName); System.out.println(s4.studentName);     // 만약, 오류가 발생한다면 객체의 주소값을 확인해보길 권장. 

    }   // main end
}

class Student{  // "학생" 추상 개념 -> 코드화
    // 멤버변수(학생의 상태)
    int studentID;  // 타입 변수명       클래스안에서 선언된 변수 -> 멤버/인스턴스 변수
    String studentName ; 



}   // class end
