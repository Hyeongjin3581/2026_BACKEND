package Day10;

public class Exam2 {
    public static void main(String[] args) {

        // 자바는 100% oop 이다.
        // superClass인 Object Class로부터 모든 클래스는 상속관계 

        // [1] 상속관계
        A a = new A();  // 총 2개 , A --> Object
        B b = new B();  // 총 3개 , B -->A --> Object
        C c = new C();  // 총 3개   C --> A --> Object
        D d = new D() ; // 총 4개 D --> B --> A --> Object
        E e = new E();  // 총 4개 E --> C --> A --> Object

        // [2] 자동타입변환
        A a2 = b;   //  B --> A [가능]
        Object o1 = a2; // A --> Object [가능]
        B b2 = (B)o1;   // Object --> B (다운캐스팅) [가능]
        // C c2 = (C)b2;   // cannot cast 형제간의 타입변환은 안된다. 
        // [4] 타입 확인, * instanceOf *    --> 인스턴스 instanceOf 타입명  // true , false로 산출됨. 
        System.out.println(e instanceof Object);
        System.out.println(e instanceof C);
        // System.out.println(e instanceof D); // false로 산출되기 전에 그냥 컴파일오류 발생. 
        // 즉 ,타입변환 전에 instanceof 를 활용하여 타입 확인 후 타입변환

        }   //main end
    }


class A{
    A(){
        System.out.println("[1] A객체 생성");
    }
}

class B extends A{
    B(){System.out.println("[2] B객체 생성");}
}

class C extends A{
    C(){System.out.println("[3] C객체 생성");}
}

class D extends B{
    D(){System.out.println("[4] D객체 생성");}
}

class E extends C{
    E(){System.out.println("[5] E객체 생성");}
}