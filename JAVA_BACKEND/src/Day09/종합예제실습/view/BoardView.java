package Day09.종합예제실습.view;

import Day09.종합예제실습.model.dto.BoardDto;
import Day09.종합예제실습.controller.BoardController;

import java.util.*;

public class BoardView {
    private BoardView(){}
    private static final BoardView instance = new BoardView();
    public static BoardView getInstance(){ return instance; }

    private BoardController bc = BoardController.getInstance(); 
    private Scanner scan = new Scanner(System.in); 


    //[*] 메인 입출력  *<2번>*      // 다시 *<8번>*(무한 반복)
    public void run(){
        while(true){
            System.out.print("1.명단 등록 2.명단 전체 조회 3. 명단 개별 수정 4. 개별 명단 삭제 :");
            int ch = scan.nextInt();
            if(ch==1){ save(); } 
            else if(ch==2){ findAll(); }
            else if(ch==3){ update(); }
            else if(ch==4){ delete(); }
        }
    }
    // [1] 명단등록 입출력    *<9번>*
    public void save(){
        // 1. 입력받기 
        System.out.print("고객의연락처: ");     String 전화번호 = scan.next();
        System.out.print("방문인원수: ");   int 사람수 = scan.nextInt();
        
        // 2. 객체화
        BoardDto boardDto = new BoardDto( 전화번호 , 사람수 );
        
        // 3. 컨트롤러에게 요청하고 응답받기
        boolean result = bc.save( boardDto );
        
        // 4. 처리한다
        if( result ){ System.out.println("등록성공"); }
        else{ System.out.println("등록실패"); }
    }

    // [2] 명단 전체 출력  *<9번>*
    public void findAll(){
        // 1. 컨트롤러로부터 모든 명단을 요청하고 받는다 
        ArrayList<BoardDto> result = bc.findAll();
        
        // 2. 컨트롤러로부터 받은 모든 명단을 출력한다.
        for( BoardDto board : result ){
            System.out.println(
                board.getPhone()   +   " : "  +
                board.getNumber() );
        }
    }

    // 3. 대기명단 개별수정 *<9번>*
    public void update() {
        System.out.print("전화번호: ");
        String 전화번호 = scan.next();
        System.out.print("변경할 방문 인원수: ");
        int 사람수 = scan.nextInt();

        // 입력받은 정보로 DTO 생성
        BoardDto boardDto = new BoardDto(전화번호, 사람수);
        // controller에게 요청 후 응답받기.
        boolean result = bc.update(boardDto);
        //코멘트 반환 
        if(result){
            System.out.println("수정성공");
        }else{
            System.out.println("수정실패");
        }
    }
    //[4] 명단 삭제 로직 *<9번>*
    public void delete() {
        // 1. 삭제할 대상의 전화번호를 입력받는다.
        System.out.print("고객의연락처: ");
        String 전화번호 = scan.next();

        // 3. 컨트롤러에 요청 후 값 반환
        boolean result = bc.delete(전화번호);
        // 코멘트 반환
        if(result){
            System.out.println("삭제성공");
        }else{
            System.out.println("삭제실패");
        }
    }
}   // class end