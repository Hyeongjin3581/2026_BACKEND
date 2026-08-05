package Day06;

import java.util.Scanner;;

public class OverallController {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        Port[] ports = new Port[100];   // 배열의 크기가 100인 ports 생성.

        // 무한for문 생성.
        for(;;){
            System.out.println("========= My Community ==============");
            System.out.println("1. 게시물 작성 2. 게시물 확인 3.종료");
            System.out.println("=====================================");
            System.out.print("선택 > ");
            // 숫자 scan으로 받기. 
            int ch = scan.nextInt();

            // if 문 생성.
            if(ch==1){
                scan.nextLine();
                System.out.print("내용 : ");
                String content  = scan.nextLine();
                System.out.print("작성자 : ");
                String writer = scan.nextLine();

                // 인스턴스 생성 및 result 초기화
                Port port = new Port(content,writer);
                boolean result = false;

                //for문을 활용하여 null인 배열에 내용과 작성자 값 삽입.
                for(int i=0; i<=ports.length-1;i++){
                    if(ports[i] == null){
                        ports[i] = port;
                        result = true;
                        break;
                    }
                }

                if(result){
                    System.out.println("[안내] 게시물 작성 성공!");
                }else{
                    System.out.println("[안내] 게시물 작성 실패");
                }

            // 2번을 대입 하였을 때, 작성된 게시물 모두 표시.    
            }else if(ch==2){
                // 향상된 for문 사용.
                for(Port port : ports){
                    if(port != null){
                        System.out.printf("내용 : %s , 작성자 : %s\n",port.content, port.writer);
                    }
                }
            }else if(ch==3){
                System.out.println("안뇽히가세요");
                break;
            }

        } // for end
    }
}

// class Port 생성

class Port{
    String content;
    String writer;

    // 기본생성자 생성
    Port(){}

    // 매개변수를 받는 생성자 생성
    Port(String content, String writer){
        this.content = content;
        this.writer = writer;
    }
}
