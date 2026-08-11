package Day10;

public class Example2 {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.tire = new Tire(); 
        myCar.run(); 


        myCar.tire = new HankookTire();    
        myCar.run(); 

        myCar.tire = new KumhoTire();       // myCar.tire 참조값 변경.  / 다형성을 활용한 필드값 변경(대입)
        myCar.run(); 
        
        System.out.println( myCar.tire instanceof Tire ); // true
        System.out.println( myCar.tire instanceof KumhoTire ); // true
        System.out.println( myCar.tire instanceof HankookTire ); // false   --> myCar.tire가 가리키는 힙 영역의 인스턴스가 KumhoTire로 바꼈기 때문
      
    } // main
} // class end


class Car{ // 자동차
 Tire tire;
 void run() { this.tire.roll(); }
}
class Tire{ // 타이어
 void roll(){
 System.out.println("[일반] 타이어가 회전");
 }
}
class HankookTire extends Tire{
 void roll(){ System.out.println("[한국] 타이어가 회전(업그레이드)"); }
}
class KumhoTire extends Tire{ 
 void roll(){ System.out.println("[금호] 타이어가 회전(업그레이드)"); }
}