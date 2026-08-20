package Day14;

import java.util.ArrayList;

import javax.swing.Box;

public class Exam1 {
    public static void main(String[] args) {
        
        /*  
            제네릭 타입 : 
                정의 : 여러가지 타입에서 동작할 수 있도록 만든 타입
                목적 : 클래스를 정의할 때 타입을 정하지 않고 사용할 때 직접 타입을 정한다.
                사용법: 
                    1) 제네릭타입은 영 대문자로 한다.
                    2) 여러개 가능하다.
                    3) 기본타입은 불가능하므로 래퍼클래스를 사용한다.
        */
       // 1] 클래스내 객체 멤버변수 동일한 타입으로 값 대입. 
       Box1 box1 = new Box1();
       box1.content = "안뇽하숑";
       //2] String 대신에 int 타입으로 값 대입???? 새로운 클래스를 만든다.
       Box2 box2 = new Box2();
       box2.content = 123;  // 동일한 멤버변수간 서로다른 타입은 불가능할까???
       // 3] 해결방안? 제네릭 이용한 동일한 멤버변수간 서로다른 타입 사용.

       Box3<String> box3 = new Box3<String>(); 
       box3.content = "하이용";
       Box3<Integer> box33 = new Box3<>();   //  생성자 뒤에 제네릭 생략 가능
       box33.content = 10;
       // Object 타입으로 사용시에는 타입변환 필요하지만, 제네릭 타입은 사용자가 쓸 때 따로 정의하여 쓸 수 있어 편의성이 좋다. 

       ArrayList<String> list1 = new ArrayList<>(); // <>에 String를 넣었다는 거 자체가 이미 제네릭 표현을 사용하고 있었다는 뜻. 
       // ??? : 왜 ArrayList는 클래스로 지정하지 않고 바로 사용되나요? --> import java.util.ArrayList 에 지정되어 있는 내부 클래스로 사용하기 때문. 
       String[] list2 = new String[10];

       // 4] 2개 이상의 제네릭 타입 가능.
       Box4<String , Integer> box4 = new Box4<>();
       box4.value1 = "안녕하시오";
       box4.value2 = 123;

       // 5] 중첩 가능
        Box4<String , ArrayList<Integer>> box44 = new Box4<>();
        box44.value1 = "안녕하세요";    box44.value2 = new ArrayList<>();

        // *] 활용처 : **** 컬렉션 프레임워크(제네릭타입을 반드시 씀! (ArrayList)) **** 
        // 벡엔드 포폴은 중간중간 과제로 문법 문제를 드리는데, 그것을 취합하는 과정에서 발생하는 나만의 문법결과물이 더 경쟁력있는 포폴이 될 것임.
      
        //6] 메소드 제네릭 사용
        Box3<String> box333 = Util.boxing("사과");
        System.out.println(box333.content);

        // 7] 상속 관계 제약 , <타입 extends 상위타입> 
        // Box5<String> box5 = new Box5<>();    String 타입은 Number 타입의 자식이 아니라서 불가능함. 
        Box5<Integer> box5 = new Box5<>(); 
        box5.content = 123;
    }
}

class Box1{String content;} // 박스1 클래스내 문자열 content 대입 가능. (멤버변수 아닝?) 
class Box2{int content;}    // 박스2 클래스내 정수형 content 대입
class Box3<제네릭타입>{제네릭타입 content;}
class Box4<T,E>{T value1 ; E value2;}   // 두 개의 멤버변수 생성. 
class Util{
    public static <T> Box3<T> boxing(T 매개변수){   // 제네릭 유틸 클래스. TIP : 타입또한 매개변수로 활용 가능하니깐, 염두해두면 좋음.
        Box3<T> box = new Box3<>();
        box.content = 매개변수;
        return box;
    }
}
class Box5<T extends Number>{T content;}    // T<제네릭> 타입에는 Number 자식타입만 가능하도록 제약함. 