package Day09.종합예제실습2.view;

import Day09.종합예제실습2.model.dto.BoardDto;
import Day09.종합예제실습2.controller.BoardController;

import java.util.*;

public class BoardView {
    private BoardView(){} // 1. 기본생성자 생성
    private static final BoardView instance = new BoardView(); // 2. 유일한 인스턴스 생성: 클래스 로딩 시 단 하나의 객체를 생성하며, final을 통해 변경을 방지하고 private으로 보호합니다.    
    public static BoardView getInstance( ){ return instance; } // 3.  외부에서 객체 생성 없이 클래스명으로 접근해 단 하나의 인스턴스를 공유받을 수 있는 메소드

    // [*] 싱글톤 패턴으로 구현된 BoardController 객체의 유일한 인스턴스를 가져와 필드(멤버 변수)에 저장하는 코드
    private BoardController bc = BoardController.getInstance();
    private Scanner scan = new Scanner(System.in);

    // 실행문 코드 작성.
    public  void run(){
        while (true) {
            System.out.print("1.도서 등록 2.도서 전체 조회 3. 도서 개별 수정 4. 도서 명단 삭제 > ");
            int ch = scan.nextInt();
            if(ch==1){  save();}
            else if(ch==2){ findAll(); }
            else if(ch==3){ update(); }
            else if(ch==4){ delete(); }

        }
    }
    // [1] 도서등록 입출력  
    public void save(){
        // 1. 입력받기 
        System.out.print("도서번호: ");   int 도서번호 = scan.nextInt(); 
        System.out.print("도서제목: ");    String 도서제목 = scan.next();
        
        // 2. 객체화
        BoardDto boardDto = new BoardDto( 도서번호 , 도서제목 );
        
        // 3. 컨트롤러에게 요청하고 응답받기
        boolean result = bc.save( boardDto );
        
        // 4. 처리한다
        if( result ){ System.out.println("등록성공"); }
        else{ System.out.println("등록실패"); }
    }

    //[2] 도서 전체 출력
    public void findAll(){
    // 1. 컨트롤러로부터 모든 명단을 요청하고 받는다 
    ArrayList<BoardDto> result = bc.findAll();
        
    // 2. 컨트롤러로부터 받은 모든 명단을 출력한다.
    for( BoardDto board : result ){
        System.out.println(
            board.getBookNum()   +   " : "  +
            board.getBookName() );
        }
    }
    // [3] 도서제목 수정
    public void update(){
        // 1. 입력받기 
        System.out.print("도서번호: ");   int 도서번호 = scan.nextInt();
        System.out.print("변경할 도서명: ");  String 도서제목 = scan.next();
        
        // 2. 객체화
        BoardDto boardDto = new BoardDto( 도서번호,도서제목 );
        
        // 3. 컨트롤러에게 요청하고 응답받기
        boolean result = bc.update( boardDto );
        
        // 4. 처리한다
        if( result ){ System.out.println("수정성공"); }
        else{ System.out.println("수정실패"); }
    }
    
    //[4] 개별 도서 삭제
    public void delete(){
        System.out.print("삭제할 도서번호: ");  int 도서번호 = scan.nextInt();
        // BoardDto boardDto = new BoardDto(도서번호); 객체화 x 바로 컨트롤러에 요청.
        boolean result = bc.delete(도서번호);

        if( result ){ System.out.println("삭제성공"); }
        else{ System.out.println("삭제실패"); }
    }
}// class end

