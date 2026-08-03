package Day04;

import java.util.Scanner;
import java.util.Arrays;

public class test {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[ ] array = new int [0];     // 0에 저장 가능한 배열
        while(true){
            int ch = scan.nextInt();
            if( ch==1 ){
                int 저장할값 = scan.nextInt();
                //[2] 배열 내 꼬리(마지막인덱스)에 요소 추가,  array.length-1
                int [] newArray = new int[array.length+1];
                for(int index=0 ; index <= array.length -1; index++){
                    newArray[index] = array[index]; // 오른쪽 기존배열 index값
                }
                // [4] [2] 반복
                newArray[ newArray.length-1] = 저장할값;
                // [5] 기존배열변수에 새로운 배열 대입
                array = newArray;
                // [*]
                System.out.println(Arrays.toString(array));
            }
        }
    }
}





















        
//         boolean a = true;
//         int[] arr1 =new int[0]; 
//         int[] newArray = new int[arr1.length+1];

// //  --> 교수님 정답보고 틀린부분 확인. 

//         while(a){
//             String b = "비어있음";
//             System.out.println("---------------------------------");
//             System.out.println("현재 배열[크기 : "+(newArray.length-1)+"] :"+newArray);
//             System.out.println("1. 요소 추가 | 2. 인덱스로 삭제 | 0. 종료");
//             System.out.print("메뉴를 선택하세요: ");
//             int select = sc.nextInt();

//             if(select==1){
//                 System.arraycopy(arr1, 0, newArray, 0, arr1.length);
//                 System.out.print("추가할 정수 값을 입력하세요: ");
//                 int input = sc.nextInt();
//                 newArray[arr1.length] = input;
//                 System.out.println(input +" 값이 성공적으로 추가되었습니다.");
//             }

//             if(select==2){
                
//             }
//         }

// 첫째 : java배열은 편의성언어로 크기를 늘릴 수 없음. 
// 둘째 : 그렇다면 구조를, 새로운 배열을 생성하여 기존 배열보다 + 1 인 크기의 배열을 생성하거나 
// -1 만큼의 배열을 생성하여 덧붙이는 것이 최선. 