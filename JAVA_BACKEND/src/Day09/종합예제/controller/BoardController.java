package Day09.종합예제.controller;

import java.util.ArrayList;

import Day09.종합예제.model.dao.BoardDao;
import Day09.종합예제.model.dto.BoardDto;

public class BoardController {
    private BoardController(){};
    private static final BoardController instance = new BoardController();
    public static BoardController getInstance(){ return instance; }
    
    // [*] MVC패턴 흐름의 dao 싱글톤 호출
    private BoardDao bd = BoardDao.getInstance();   // controller에서 dao 싱글톤 호출

    // [1] 게시물 작성 컨트롤러 *<3번>*
    public boolean save( BoardDto boardDto ){
        // 1. view 으로 부터 저장할 정보 객체로 받는다.
        // * 유효성검사 / 타입 변환 등등
        // 2. DAO 에게 요청하고 응답받기 
        boolean result = bd.save( boardDto );
        // 3. DAO 에게 받은 결과를 VIEW에게 응답하기  *<6번>*
        return result;
    } 

    // [2] 게시물 전체 조회 컨트롤러
    public ArrayList<BoardDto> findAll(){
        ArrayList<BoardDto> result = bd.findAll();
        return result;
    } // f end
}   // class end