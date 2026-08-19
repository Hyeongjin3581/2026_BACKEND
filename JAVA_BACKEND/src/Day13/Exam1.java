package Day13;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import 종합예제.model.dto.BoardDto;

public class Exam1 {
    public static void main(String[] args) {
        // 라이브러리 : 다른 사람들이 만든 클래스/메소드 집합
        // [1] Object 클래스 : 자바의 최상위 클래스 *다형성*
        Object o1 = 3; Object o2 = 3.14; Object o3 = "유재석" ; Object o4 = true; Object o5 = new int[3];
        // 모든 자료들은 Object 타입 변수에 대입 가능. 

        // 1). toString()  : 객체의 주소값 반환함수  /   생략가능 / 활용처 : 오버라이딩을 이용한 멤버변수 확인.
        System.out.println(o5.toString());
        System.out.println(o5); // toString()은 생략가능함.
        Object o6 = new BoardDto();
        System.out.println(o6.toString());
        System.out.println(o6);

        //2) equals() : 객체가 참조하는 값 비교 함수, 활용처 : 객체비교 , 문자열비교 (원래는 Object꺼인데, 이거를 @Override 하여 equals가 사용.)
        Object o7= new BoardDto();
        System.out.println(o6 == o7);   // 주소가 다르므로 false 
        System.out.println(o6.equals(o7));  // false        / equals --> 동등한, 평등한의 뜻
        String str1 = "유재석"; String str2 = new String("유재석");
        System.out.println(str1 == str2);   // false    (주소값(참조값)비교)
        System.out.println(str1.equals(str2));  // true (문자열비교) / 본디 equals는 단순비교 , / String는 문자열비교로 나뉘어짐.
        System.out.println( str1 =="유재석");   // 본디 그대로의 것. ex) 포카칩    /   리터럴문자열  == 리터럴문자열   / true
        System.out.println( str2 =="유재석");   // 그대로의 것을 한번 포장함.  ex) 포카칩 포장한 상자  / 객체(리터럴문자열) == 리터럴문자열 / false

        // 3) hashCode( ) : 객체를 식별하는 값을 정수로 반환 *주소값은16(0~9abcdef)진수 * 사람은10(0~9)진수
        // 활용처 : 객체 탐지하는 경우에 주소값이 아닌 정수로된 값(키) 비교하여 속도 향상
        System.out.println(o6.hashCode());
        System.out.println(o7.hashCode());
        System.out.println(str1.hashCode());    // 값만을 빈환?
        System.out.println(str2.hashCode());

        // [2] Class : 클래스의 정보를(멤버변수,생성자,메소드) 담는 클래스
        // 1. getClass()
        String obj1 = new String(); Class c1 = obj1.getClass();
        System.out.println(c1); //  패키지명과 클래스명 확인

        // 2. Class.forName("패키지명.클래스명"), *일반예외 필수*
        // *** 리플렉션 *** :   // 결론 : 스프링에서 많이 사용하니, 미리 숙지
        // 최초실행(컴파일) 할 때 해당 클래스의 객체 로드/생성하지 않고, 실행도중에 객체 로드/생성 한다.
        // 활용처 : JDBC(프로그램시작이 아닌 DB연동시 MYSQL관련 클래스로드) , 스프링프레임워크( IOC )   
        try{ Class.forName("java.lang.String");}
        catch( ClassNotFoundException e){System.out.println( e );}

        // 3. .getFields() : 클래스내 멤버변수 정보 반환 
        Field[ ] fields = c1.getFields();
        for(Field field : fields){System.out.println(field);}

        //4. .getConstructor() : 클래스내 생성자 반환 
        Constructor[] constructors = c1.getConstructors();
        for(Constructor constructor : constructors){System.out.println( constructor );}

        //5. 클래스내 메소드 정보 반환
        Method[] methods = c1.getMethods();
        for(Method method : methods){System.out.println(method);}

        // 리터럴로 정의한 문자열과 new String으로 정의한 문자열은 다르다.

    } // main end
}

/*
    기본타입    : byte , short , int ,  long, float , double, boolean, char , String
        -   리터럴 = 상수
    참조타입    : 클래스(String,Scanner,~Dto 등등) , 인터페이스(Connection 등등) , 배열[ ]
        -   참조 = 주소 ,   기본타입 여러개를 하나로 만들 때 사용.
*/
