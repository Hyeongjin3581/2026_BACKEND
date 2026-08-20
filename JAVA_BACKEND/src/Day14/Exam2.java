package Day14;

import java.util.*;

public class Exam2 {
    public static void main(String[] args) {
        
        // 제네릭 : 클래스내 타입들을 인스턴스 생성 시 정한다.
        /*
            컬렉션(수집)프레임(틀)워크(일)
                - 정의 : 데이터 수집(목록)하는 자료구조(방법), 미리 만들어둔 인터페이스/클래스들
                - 목적 : 복잡한 자료들을 편리하게 제공받아서 사용하기 위함. 
                - 종류 : 
                    List 인터페이스 :   구현체 > ArrayList, Vector, LinkedList, Stack 등 
                    Set 인터페이스 :    구현체 > HashSet, TreeSet 등 
                    Map 인터페이스 :  구현체 > HashMap, HashTable, TreeMap 등
                * 인터페이스란? 서로 다른 클래스들을 하나의 타입으로 조작
                * 구현체란? 인터페이스내 추상메소드 구현한 클래스들
                *  다형성이란? (캐스팅) 하나의 자료가 서로 다른 타입으로 반환
        */
       // [1] List 인터페이스
       ArrayList<String> list1 = new ArrayList<>();
       List<String> list2 = new ArrayList<>();
       list2 = new LinkedList<>();  // List는 LinkedList의 상위이기 때문(다형성.)
       //    list1 = new (ArrayList)List<>()   // 문법적 오류 발생. 그리고 다운캐스팅은 이미 만들어진 객체를 대상으로 하는 것.
       
       //[2] List 인터페이스 타입으로 구현체 메소드 사용가능 <Day09 Exam1> , 구현체들이 오버라이딩!
       list2.add("유재석");
       System.out.println(list2.get(0));    // index 반환 ,배열로 출력을 원하면 list2 그대로 사용하면 됨. 
       list2.add("강호동");
       //[3] 리스트/배열과 반복문 관계 // 리스트(목록) 내 항목(값)들을 한번에 꺼낼 수 없음(고로, 반복문 사용.)

       // 향상된 for문
       for(String str : list2){System.out.println(str);}
       // forEach문   -->  스트림/람다식에서 활용할 예정.
       list2.forEach((str) -> { System.out.println(str);});

        int i = 0;
        while (i < list2.size()) {
            System.out.println(list2.get(i));
            i++;
        }

        if (!list2.isEmpty()) {
            do {
                System.out.println(list2.get(i));
                i++;
            } while (i < list2.size());
        }   

        // [4] List 구현체의 차이 : 사용법(함수/메소드) 동일, 구조적 차이

        // ArrayList : 인덱스 기반의 배열 구조 + 동기화 지원x
        //                  [A] [B] [C] [D]     // E 저장한 경우 마지막 뒤에 E 저장.
        //                   0    1   2    3      // B 삭제한 경우 삭제된 B 이후로 C D 한칸씩앞으로 이동.
        // LinkedList : 링크[h헤더][d본문][t꼬리] = 노드 기반의 리스트 구조
        //                  [][A][B주소]     [A주소][B][C주소]    [B주소][C][D주소]     [C주소][D][]     
        //                     0                                1                             2                               3
        //                   B노드를 삭제한 경우, A주소 꼬리에 C노드를, C노드의 해더노드에 A노드를 대입한다. 
        // Vector:  ArrayList 동일한 구조 + 동기화(스레드)지원


    }   // main end
}
