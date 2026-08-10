package Day09.종합예제실습2.controller;

import java.util.ArrayList;

import Day09.종합예제실습2.model.dao.BoardDao;
import Day09.종합예제실습2.model.dto.BoardDto;


public class BoardController {
    private BoardController(){}
    private static final BoardController instance = new BoardController();
    public static BoardController getInstance(){ return instance; }

    //[*] MVC패턴 흐름의 dao 싱글톤 호출
    private BoardDao bd = BoardDao.getInstance();


    //[1]
    public boolean save(BoardDto boardDto){
        boolean result = bd.save(boardDto);
        return result;
    } 

    // [2] 
    public ArrayList<BoardDto> findAll( ){
        ArrayList<BoardDto> result = bd.findAll();
        return result;
    } 

     //[3]
    public boolean update(BoardDto boardDto){
        boolean result = bd.update(boardDto);
        return result;
    } 

    //[4]
    public boolean delete(int 도서번호){
        boolean result = bd.delete(도서번호);
        return result;
    } 
}
