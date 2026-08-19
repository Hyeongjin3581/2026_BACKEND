package Day13;

import java.util.Random;
import java.util.UUID;

public class Exam4 {
    public static void main(String[] args) {
        
        // [1] 난수 클래스
        // 1. 랜덤 객체
        Random random = new Random();
        //2. 랜덤 생성, .nextXXX
        int value1 = random.nextInt(); System.out.println(value1);
        int value2 = random.nextInt(10); System.out.println(value2);    // 0~ 9사이로 출력됨.(10개)
        int value3 = random.nextInt(10) + 10;    System.out.println(value3); // 10~ 19사이로 출력됨 (10개)
        boolean value4 = random.nextBoolean(); System.out.println(value4);  // true , false 랜덤 반환
        // [2] UUID  , 범용 고유 식별자, 절대 중복없는 난수 생성. 
        String uuid = UUID.randomUUID().toString(); System.out.println(uuid); // 30448ab3-8cd9-4554-8096-b6b6f2145c74
        // 위에 구문이 new를 사용하지 않는 이유는 randomUUID자체가 정적 팩토리 메서드이기 때문.
        // 직접 난수 바이트 배열을 복잡하게 계산할 필요없이, Java설계자들이 클래스에 정의된 static 메서드를 통해 객체를 생성하여 반환받음. 
        // 이러한 디자인 패턴을 정적 팩토리 메서드라고 부름.
        // new를 안 쓰는 것처럼 보이지만, randomUUID() 메서드 내부에서 대신 new를 써서 객체를 만들어 반환해 주는 것입니다.
        
    } // main end
}
