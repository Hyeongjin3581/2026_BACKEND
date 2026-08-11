package Day09.종합예제실습2.model.dao;

import java.util.ArrayList;
import Day09.종합예제실습2.model.dto.BoardDto;

public class BoardDao {
    private BoardDao(){}
    private static final BoardDao instance = new BoardDao();
    public static BoardDao getInstance(){ return instance; }

        // * 데이터베이스 대신에 ArrayList 사용하여 데이터베이스 표/데이터 역할 * 
    // * 추후에 MYSQL 서버와 연동 *
    private ArrayList<BoardDto> boardList = new ArrayList<>(); 

    // [1]
    public boolean save(BoardDto boardDto){     // 하나의 클래스타입 또한 매개변수로 활용가능.(한묶음 상자.)
        for(int i = 0; i < boardList.size(); i++){
            if(boardList.get(i).getBookNum() == boardDto.getBookNum()){
                System.out.println("[경고] 중복된 도서번호입니다.");
                return false; 
            }
        }
        boardList.add(boardDto); 
        return true;
    }

    //[2]
    public ArrayList<BoardDto>findAll(){    // 타입 안전성 보장 및 불필요한 형변환 방지. (제네릭표현)
        return boardList;
    }

    //[3]
    public boolean update(BoardDto boardDto){
        for(int i =0; i<=boardList.size()-1;i++){
            // 도서번호 i번째값과 수정요청된 getBookNum이 일치하는지 확인.
            if(boardList.get(i).getBookNum() == boardDto.getBookNum()){
                boardList.set(i,boardDto);
                return true;
            }
        }return false;
    }

    //[4]
    public boolean delete(int 도서번호){
        for(int i=0; i<=boardList.size()-1;i++){
            if(boardList.get(i).getBookNum() == 도서번호){
                boardList.remove(i);
                return true;
            }
        }return false;
    }
}

