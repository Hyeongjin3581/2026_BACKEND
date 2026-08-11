package Day10;

public class Exam3 {
    public static void main(String[] args) {
        
        //1.  상위객체
        상위클래스 obj1 = new 상위클래스();     // obj1 -> 지역변수/스택메모리에서 new 상위클래스() 인스턴스를 참조.  new 상위클래스() ->힙 메모리에 인스턴스 할당, 생성자 호출하여 인스턴스 초기화.
        obj1.show();

        // 2. 하위객체
        하위클래스 obj2 = new 하위클래스();
        obj2.show();

        //3. *타입반환*
        상위클래스 obj3 = obj2; // 하위메소드가 재정의
        obj3.show();


    }   // main end
}
/*
    오버로딩 : 생성자명 또는 메소드명을 동일하게 여러개 선언
    오버라이딩 :  상속관계에서 물려받은 메소드를 재정의
*/

class 상위클래스{
    int value1 = 10;
    int value2 = 20;
    상위클래스(){System.out.println("상위클래스 탄생");}
    void show(){System.out.println("상위메소드 실행\n");}
}
class 하위클래스 extends 상위클래스{
    int value3 = 30 ; int value4 = 40;
    하위클래스(){System.out.println("하위클래스 탄생");}
    //  주의할점 : 오버로딩 vs 오버라이딩
    void show(int a){}  // 오버로딩의 전제조건 : 매개변수 개수 , 타입 , 순서가 다른 경우 생성가능 (메소드명은 같지만, 매개변수는 다른)

    @Override   // 오버라이드는 함수 메소드 위에 작성. (자동완성은 컨트롤 + 스페이스바)
    void show(){
        System.out.println("하위메소드가 재정의하여 실행\n");
    }   // 상위클래스의 메소드 선언부와 모두 동일하면 (타입까지 일치하다면) 오버라이딩(재정의)
}