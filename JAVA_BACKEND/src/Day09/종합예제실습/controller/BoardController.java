package Day09.종합예제실습.controller;

import java.util.ArrayList;

import Day09.종합예제실습.model.dao.BoardDao;
import Day09.종합예제실습.model.dto.BoardDto;

public class BoardController {
    private BoardController(){};
    private static final BoardController instance = new BoardController();
    public static BoardController getInstance(){ return instance; }
    
    // [*] MVC패턴 흐름의 dao 싱글톤 호출
    private BoardDao bd = BoardDao.getInstance();   // controller에서 dao 싱글톤 호출

    // [1] 명단 작성 컨트롤러 *<3번>*
    public boolean save( BoardDto boardDto ){
        // 1. view 으로 부터 저장할 정보 객체로 받는다.
        // * 유효성검사 / 타입 변환 등등
        // 2. DAO 에게 요청하고 응답받기 
        boolean result = bd.save( boardDto );
        // 3. DAO 에게 받은 결과를 VIEW에게 응답하기  *<8번>*
        return result;
    } 

    // [2] 명단 전체 조회 컨트롤러
    public ArrayList<BoardDto> findAll( ){
        ArrayList<BoardDto> result = bd.findAll();
        return result;
    } 

    // [3] 대기명단 개별 수정 컨트롤러
    public boolean update(BoardDto boardDto){
        boolean result = bd.update( boardDto );
        return result;
    }

    // [4] 대기명단 개별 삭제 컨트롤러
    public boolean delete(String 전화번호){
        boolean result = bd.delete( 전화번호 );
        return result;
    }
}   // class end