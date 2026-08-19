package Day13;

import java.util.Arrays;

public class Exam3 {
    public static void main(String[] args) {
        
        // String 관련된 함수를 사용해볼 예정. 

        // 1. 문자열은 배열이다. 
        char str1 = '유';   // char 타입( ' ' )은 1글자만 가능!
        char[ ] str2 ={ '유' , '재' ,'석'}; //  char타입의 배열
        String str3 = "유재석";     // String 클래스는 배열의 멤버변수를 가짐.

        // 2. 문자를 변환
        char str4 = 65; // A
        System.out.println(str4);
        char[] str5 = {74,65,86,65}; System.out.println(str5);
        char str6 = '유'; System.out.println((int)str6);    // 50976
        // * 정수 -char(규칙)-> 문자 -> 배열 -> 문자열 *

        //3. 문자열 비교
        System.out.println("유재석" == "유재석");
        System.out.println(new String("유재석") == "유재석");
        System.out.println(new String("유재석").equals("유재석"));  // equals는 포장지를 까는 역할이라 보면 됨.

        //4. 문자열A. concat(문자열B) , 문자열 연결
        String str7 = "자바";  String str8 = "프로그래밍";
        System.out.println(str7.concat(str8));  //   자바프로그래밍
        System.out.println( str7 + str8);   // 자바프로그래밍

        //5. StringBuilder , append( ) , 문자열은 불변(수정금지)이다.   ,  빌더주소값 1개지정하여 새로운 문자열들을 연결
        StringBuilder builder = new StringBuilder();    // 새로운 참조변수 builder를 append 하여 사용하는 이유? 메모리 참조를 통해서 메모리 효율을 높이기 위해
        builder.append(str7);   // StringBuilder 는 가변객체이며 ,자바에서 제공하는 유틸 클래스이다.
        builder.append(str8);
        System.out.println(builder);    // 자바프로그래밍

        // 6. .chatAt(인덱스) , 문자 1개 추출
        String str9 = "자바프로그래밍"; System.out.println(str9.charAt(2));

        // 7. .length() : 문자열내 문자 개수 반환
        System.out.println(str9.length());

        // 8. .replace(기존문자 , 새로운문자) : 만일 기존문자가 존재하면 새로운문자로 치환하여 반환
        System.out.println(str9.replace("자바", "Java")); // Java프로그래밍

        // 9. substring() (시작인덱스, [끝인덱스])  ,   시작인덱스 부터 끝인덱스 전까지 문자열 추출
        String str10 = "012345-1230123";
        System.out.println(str10.substring(6)); // -1230123
        System.out.println( str10.substring(0,6)); // 0부터 6까지 , 012345

        // 10 . .split(기존문자) , 기존문자 기준으로 문자열 분해하여 배열 반환
        System.out.println(str10.split("-"));
        String[] strAry = str10.split("-"); System.out.println(strAry[0]);  System.out.println(strAry[1]);
        
        // 11. .indexOf(찾을문자) , 만일 찾을문자가 존재하면 인덱스 , 없으면 -1
        System.out.println("자바 프로그래밍 언어".indexOf("프로")); // 인덱스 반환. 없으면 -1 반환
        System.out.println(("자바 프로그래밍 언어".contains("프로")));  // 있으면 true, 없으면 false 반환

        //12.   .getBytes() , 문자열내 문자들을 바이트 배열 반환 / 파일처리 or 네트워크 등 외부통신
        byte[] strAry2 = "ABC".getBytes();
        System.out.println(strAry2);
        System.out.println( Arrays.toString(strAry2) );    // "ABC" --> [65, 66, 67]
        System.out.println( new String(strAry2));       //  [65, 66, 67] --> "ABC"

    }   // main end
}
