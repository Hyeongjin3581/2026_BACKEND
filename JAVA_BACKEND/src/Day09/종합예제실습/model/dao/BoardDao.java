package Day09.종합예제실습.model.dao;

import java.util.ArrayList;

import Day09.종합예제실습.model.dto.BoardDto;

public class BoardDao {
    private BoardDao(){}
    private static  final BoardDao instance = new BoardDao();
    public static BoardDao getInstance(){
        return instance;
    }
     // [*] 데이터베이스 역할 하는 ArrayList < 추후에 삭제 예정 >
    private final ArrayList<BoardDto> boardList = new ArrayList<>();

    // [1] 명단 작성 로직   *<4번>*
    public boolean save( BoardDto boardDto ){
        // 1. controller 으로 부터 저장할 정보 객체 받는다.
        // * 추후에 insert 이용한 db에 저장
        // 2. 리스트에 저장
        boardList.add( boardDto );
        // 3. 성공반환
        return true;
    }
    //[2] 명단 전체 조회 로직  *<5번>*
    public ArrayList<BoardDto> findAll( ){
        // 1. controller 에게 매개변수 받는다.현재는 없음
        // * 추후에 select 이용한 db 조회
        // 2. 리스트 전체 반환
        return boardList;
    }

    // [3] 명단 수정 로직   *<6번>*
    public boolean update( BoardDto boardDto ){
    // 1. controller 로부터 수정할 정보 객체를 받음
    // 2. 리스트에서 수정할 대상을 찾기 위한 반복문
    for( int i = 0; i <= boardList.size()-1; i++ ){
        // number와 수정요청된 number가 일치하는지 확인
        if( boardList.get(i).getPhone().equals((boardDto.getPhone())) ) {
            // 3. number가 일치하다면, 값을 입력받아 return.
            boardList.set( i, boardDto );
            // 4. 수정 성공 반환
            return true; 
            }
        }//5. 실패반환
        return false;
    }


    // [4] 명단 삭제 로직   *<7번>*
    public boolean delete( String 전화번호 ){
    // 1. controller 로부터 삭제할 정보 객체를 받음
    // 2. 리스트에서 삭제할 대상을 찾기 위한 반복문
    for( int i = 0; i <= boardList.size()-1; i++ ){
        // 저장된 객체와 일치하는지 확인
       if( boardList.get(i).getPhone().equals( 전화번호)){
            // 3. 리스트의 해당 객체를 삭제
            boardList.remove(i);
             // 3. 성공반환
            return true;
            }
        }//4. 실패반환
        return false;
    }
}   