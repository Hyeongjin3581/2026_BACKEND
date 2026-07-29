package Day02;

import java.util.Scanner;

public class Practice3 {
    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);     

    //1.
    // System.out.print("국어점수: ");
    // int a1 = scan.nextInt();
    // System.out.print("영어점수: ");
    // int b1 = scan.nextInt();
    // System.out.print("수학점수: ");
    // int c1 = scan.nextInt();
    // int 총점 = (a1+b1+c1);
    // float 평균 = 총점/3;
    // System.out.println("총점:"+총점);
    // System.out.println("평균:"+평균); 

    //2.
    // System.out.print("반지름을 입력하세요:");
    // double 반지름 = scan.nextDouble();
    // double 원의넓이 = 반지름*반지름*3.14;
    // System.out.println("원의 넓이:"+원의넓이);  

    //3.
    // System.out.print("첫 번째 실수:");
    // double a3 = scan.nextDouble();
    // System.out.print("두 번째 실수:");
    // double b3= scan.nextDouble();
    // double c3 = (a3/b3) * 100;
    // System.out.println("출력예시:"+c3+"%");

/*[문제 4] Scanner를 이용해 정수 하나를 입력받아, 그 수가 홀수이면 true, 짝수이면 false를 출력하시오.
입력 예시:
정수를 입력하세요: 17
출력 예시:
결과: true */

    // System.out.print("정수를 입력하세요:");
    // int a4 = scan.nextInt();
    // int b4 = a4 % 2;
    // boolean c4 = b4 >= 1;
    // System.out.println("결과:"+c4);

/*[문제 5] Scanner를 이용해 정수 하나를 입력받아, 그 수가 7의 배수이면 true, 아니면 false를 출력하시오.
입력 예시:
정수를 입력하세요: 28
출력 예시:
결과: true */

    // System.out.print("정수를 입력하세요:");
    // int a5 = scan.nextInt();
    // int b5 = a5 % 7;
    // boolean c5 = b5 == 0;
    // System.out.println("결과: "+c5);

/*[문제 6] Scanner를 이용해 아이디와 비밀번호를 String으로 입력받아, 아이디가 
"admin"이고 비밀번호가 "1234"와 모두 일치하면 true, 아니면 false를 출력하시오.
요구 조건:문자열 비교는 .equals() 메소드를 사용해야 합니다.
입력 예시:
아이디: admin
비밀번호: 1234
출력 예시:
결과: true */

    // System.out.print("아이디:");
    // String a6 = scan.next();
    // System.out.print("비밀번호:");
    // String b6 =scan.next();
    // System.out.println(a6.equals("admin")&&(b6.equals("1234")));

/*[문제 7] Scanner를 이용해 정수 하나를 입력받아, 그 수가 홀수이면서 7의 배수이면 true, 아니면 false를 출력하시오.
입력 예시:
정수를 입력하세요: 21
출력 예시:
결과: true */

    // System.out.print("정수를 입력하세요:");
    // int a7 = scan.nextInt();
    // boolean c7 = (a7 % 7 == 0) && (a7 % 2 == 1 ) ;
    // System.out.println("결과: "+c7);
    
/*[문제 8] Scanner를 이용해 1차 점수와 2차 점수를 각각 int로 입력받아, 두 점수의 총점이 150점 이상이면 "합격", 아니면 "불합격"을 출력하시오.
입력 예시:
1차 점수: 80
2차 점수: 75
출력 예시:
결과: 합격 */

    // System.out.print("1차 점수:");
    // int a8 = scan.nextInt();
    // System.out.print("2차 점수:");
    // int b8 = scan.nextInt();

    // if(a8+b8>=150){System.out.println("결과: 합격");}
    // else{System.out.println("결과: 불합격");};


/*[문제 9] Scanner를 이용해 이름을 String으로 입력받아, 만약 이름이 "유재석"과 일치하면 이름 뒤에 "(방장)"을 붙여서 출력하고, 
아니면 입력받은 이름만 출력하시오.
입력 예시 1:
이름을 입력하세요: 유재석
출력 예시 1:
유재석(방장)
입력 예시 2:
이름을 입력하세요: 강호동
출력 예시 2:
강호동 */

    // System.out.print("이름을 입력하세요:");
    // String a9 = scan.next();
    // if(a9.equals("유재석")){System.out.println(a9+"(방장)");}
    // else{System.out.println(a9);};

/*[문제 10] Scanner를 이용해 삼각형의 밑변과 높이를 각각 double로 입력받아, 삼각형의 넓이를 계산하여 출력하시오.
요구 조건: 공식: 밑변 * 높이 / 2.0
입력 예시:
밑변: 10.0
높이: 5.5
출력 예시:
삼각형의 넓이: 27.5*/

    // System.out.print("밑변: ");
    // double 밑변 = scan.nextDouble();
    // System.out.print("높이: ");
    // double 높이 = scan.nextDouble();
    // double 넓이 = 밑변 * 높이 / 2.0;
    // System.out.println("삼각형의 넓이:"+넓이);
    

/* [문제 11] Scanner를 이용해 섭씨 온도를 double로 입력받아, 화씨 온도로 변환하여 출력하시오.
요구 조건:
공식: (섭씨 * 9.0 / 5.0) + 32
입력 예시:
섭씨 온도: 30.0
출력 예시:
화씨 온도: 86.0 */

    // System.out.print("섭씨 온도: ");
    // double 섭씨 = scan.nextDouble();
    // double 화씨 = (섭씨*9.0/5.0) +32;
    // System.out.println("화씨 온도: "+화씨);

/*[문제 12] Scanner를 이용해 태어난 년도(int)를 입력받아, 2025년 기준 현재 나이를 계산하여 출력하시오.
요구 조건:
공식: 2025 - 태어난 년도
입력 예시:
태어난 년도: 1998
출력 예시:
2025년 기준 나이: 27세 */

    // System.out.print("태어난 년도: ");
    // int 태어난년도 = scan.nextInt();
    // int 나이 = 2025-태어난년도;
    // System.out.println("2025년 기준 나이: " + 나이);

/*[문제 13] Scanner를 이용해 키(cm)와 몸무게(kg)를 각각 double로 입력받아, BMI 지수를 계산하여 출력하시오.
요구 조건:
BMI 공식: 몸무게(kg) / (키(m) * 키(m))
키는 cm로 입력받지만, 공식에는 m 단위가 사용되므로 키(cm) / 100.0으로 단위를 변환해야 합니다.
입력 예시:
키(cm): 175.5
몸무게(kg): 68.8
출력 예시:
BMI 지수: 22.34... */

    // System.out.print("키(cm): ");
    // double 키 = scan.nextDouble();
    // System.out.print("몸무게(kg): ");
    // double 몸무게 = scan.nextDouble();
    // double BMI = 몸무게 / (키/100.0 * 키/100.0);
    // System.out.println("BMI 지수: "+BMI);

/*[문제 14] Scanner를 이용해 아이디와 이메일을 String으로 입력받습니다. 아이디가 "admin"이거나 
또는 이메일이 "admin@test.com"이면 "관리자", 그렇지 않으면 "일반 사용자"를 출력하시오.
입력 예시:
아이디: user1
이메일: admin@test.com
출력 예시:
결과: 관리자 */

    // System.out.print("아이디: ");
    // String 아이디 = scan.next();
    // System.out.print("이메일: ");
    // String 이메일 = scan.next();
    // if(아이디.equals("admin") || 이메일.equals("admin@test.com")){System.out.println("관리자");}
    // else{System.out.println("일반 사용자");};

/*[문제 15] Scanner를 이용해 100점 만점의 점수(int)를 입력받아, 점수에 따라 아래와 같이 등급을 부여하고 출력하시오.
90점 이상: 'A'
80점 이상 90점 미만: 'B'
70점 미만: 'C'
입력 예시:
점수를 입력하세요: 88
출력 예시:
등급:B */

    System.out.print("점수를 입력하세요: ");
    int 점수 = scan.nextInt();
    if(점수>=90){
        System.out.println("등급: A");
    }else if(점수 >=80){
        System.out.println("등급: B");
    }else{
        System.out.println("등급: C");
    }

/*[문제 16] Scanner를 이용해 나이(int)를 입력받아, 20대(20세 이상 29세 이하)에 해당하는 경우 "이벤트 대상입니다."를, 
그렇지 않으면 "이벤트 대상이 아닙니다."를 출력하시오.
입력 예시:
나이를 입력하세요: 25
출력 예시:
이벤트 대상입니다. */


    


    }
}




