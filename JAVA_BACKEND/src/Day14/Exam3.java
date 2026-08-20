package Day14;

import java.util.*;

public class Exam3 {
    public static void main(String[] args) {
        
        // Set 인터페이스 : 저장된 순서(인덱스) 없이 주소값으로 데이터 관리하므로 중복을 허용하지 않는다.(중복제거)
        // 1. Set 구현
        Set <String> set1 = new HashSet<>();
        //2. Set . add (추가할 값);
        set1.add("유재석"); set1.add("강호동");
        set1.add("유재석");     // List 중복허용 , Set중복 허용안함
        set1.add(new String("유재석")); // 중복 방지한다.
        System.out.println(set1);   //  [유재석 ,강호동]
        //3. .get(인덱스); 지원불가, 인덱스가 없으니까.
        // set1.get(0);
        //4. .size();   : 항목 개수 반환
        System.out.println(set1.size());
        //6. .remove(자료); 인덱스가 아닌 자료 삭제.
        set1.remove("강호동");
        //7. .indexOf( 찾을값 ); 지원불가 , contains( 찾을값 ) 지원
        set1.contains("강호동");    // false
        //8. clear() : 항목 전체삭제
        set1.clear();
        //9. isEmpty() : 항목이 하나도 없으면 true / false
        set1.isEmpty();
        //10. set 컬렉션과 반복문 관게
        // 1] 일반 for문 사용불가. (인덱스가 없기 때문.) , 
        // 2] 향상된 for문 지원 
        for(String str: set1){
            System.out.println(str);    // list처럼 출력가능. 단, set 컬렉션은 중복을 방지하고 인덱스를 사용하지 않는다. / 아까 clear() 해서 출력문으로 나오는건 없어용
        }
        // 3] forEach문 지원
        set1.forEach((str) -> {System.out.println(str);});  // 아까 clear() 해서 출력문으로 나오는건 없어용
        set1.add("기무링");
        // - 활용처 : Set ( JDBC ReasultSet )
        Iterator<String> 순회자 = set1.iterator();    // 인덱스가 아닌 자료들을 순회하는 인터페이스 반환
        while (순회자.hasNext()){  // hasNext() : 목록(컬렉션)에서 자료 하나씩 이동 꺼내기 (저장된 순서)
            System.out.println(순회자.next());  // 다음 자료 꺼내기 지원 
        }
        // 11. TreeSet : 이진트리 / 이것을 활용한 자동 정렬
        TreeSet < Integer >set2 = new TreeSet<>();
        set2.add(50);   set2.add(70);   set2.add(60);
        System.out.println(set2);   // 자동 오름차순 정렬이 됨. 
        System.out.println(set2.descendingSet());   //내림차순 (부모타입이 TreeSet일 때 가능.)  [set인터페이스내 추상메소드가 없다.]

    }   // main end
}
