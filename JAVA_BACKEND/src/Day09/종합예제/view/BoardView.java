package Day09.종합예제.view;

import Day09.종합예제.model.dto.BoardDto;
import Day09.종합예제.controller.BoardController;

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
            System.out.print("1 : 등록  2 : 전체조회 ) ");
            int ch = scan.nextInt();
            if(ch==1){ save(); } 
            else if(ch==2){ findAll(); }
        }
    }
    // [1] 게시물 작성 입출력    *<7번>*
    public void save(){
        // 1. 입력받기 
        System.out.print("내용: ");     String 내용 = scan.next();
        System.out.print("작성자: ");   String 작성자 = scan.next();
        
        // 2. 객체화
        BoardDto boardDto = new BoardDto( 내용 , 작성자 );
        
        // 3. 컨트롤러에게 요청하고 응답받기
        boolean result = bc.save( boardDto );
        
        // 4. 처리한다
        if( result ){ System.out.println("등록성공"); }
        else{ System.out.println("등록실패"); }
    }

    // [2] 게시물 전체 출력  *<7번>*
    public void findAll(){
        // 1. 컨트롤러로부터 모든 게시물 요청하고 받는다 
        ArrayList<BoardDto> result = bc.findAll();
        
        // 2. 컨트롤러로부터 받은 모든 게시물 출력한다.
        for( BoardDto board : result ){
            System.out.println(
                board.getWriter()   +   " : "  +
                board.getContent() );
        }
    }
}   // class end