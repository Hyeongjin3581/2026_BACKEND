package Day07;

public class Exam1 {
    public static void main(String[] args) {
        
        계산기 나만의계산기 = new 계산기();
        double pi = 나만의계산기.getPI();
        나만의계산기.powerOn();
        나만의계산기.printSum(10, 5);

        사람타입 p1 = new 사람타입("강호동");
        사람타입 p2 = new 사람타입("유재석");

        p1.취업성공("개발자");

        System.out.println(p1.job);
        System.out.println(p2.job);

    } // main end
}

class 계산기 {
    // 1. 매개변수 x, 반환값 o
    
    double getPI() {
        // 1. 멤버변수
        // 2. 생성자
        // 3. 메소드/함수
        // 4. 매개변수 x 반환값 o 
        return 3.14;
    }

    // 2. 매개변수 x, 반환값 x
    void powerOn() {
        System.out.println("ON");
        return;
    }

    // 3. 매개변수 o, 반환값 x
    void printSum(int x, int y) {
        System.out.println(x + y);
    }

    // 4. 매개변수 o, 반환값 o
    int add(int x, int y) {
        printSum(x, y);
        return (x + y);
    }
} 

class 사람타입 {
    String name;
    int age;
    String job;

    사람타입(String name){
        this.name = name;
        age =1;
    }

    void 취업성공(String 취업한직업){
        this.job = 취업한직업;
        return;
    }
}