package Day06;

public class Exam1 {
    public static void main(String[] args) {

        /*
            생성자 : 인스턴스 (객체) 생성할 때 사용되는 키워드 , new 
            선언하는 방법
                1) 클래스 내부
                2) 클래스명과 동일 , 만일 다르면 메소드 취급
                3) 오버로딩 지원 : 동일한 이름으로 여러개 선언 , 조건
            목적 : 1) 빠른 초기화 , 객체생성 규칙/ 유효성 검사
            종류 : 1) 기본생성자(매개변수없는) 2) 매개변수있는생성자
        */

        // [ 1 ] 기본생성자로 객체 생성, new 생성자명 ( )
        Phone p1 = new Phone();
        p1.model = "갤럭시";
        
        // [2] 정의생성자로 객체 생성, new 생성자명( 값1 , 값2);
        Phone p2 = new Phone("Lg","white");

        // [3] 정의생성자로 객체 생성
        Phone p3 = new Phone("갤럭시", "파란색",500000);


    }   //main end
}

class Phone{
    /*  **클래스 가족(멤버들)**  */
    // 1. 멤버변수
    String model;
    String color;
    int price;
    //2. 생성자

    Phone(){}

    Phone(String model, String color){
        this.model = model;
        this.color = color;
    }

    Phone(String model, String color, int 가격){
        this.model = model;
        this.color = color;
        price = 가격;
    }

    //3. 메소드/함수
}