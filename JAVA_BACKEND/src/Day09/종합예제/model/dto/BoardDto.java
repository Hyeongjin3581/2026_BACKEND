package Day09.종합예제.model.dto;


//  DTO : 데이터 이동객체??? . 자바는 저장소가 아니다. 데이터베이스(저장소/File)같은 유형이 저장소가 됨.
// - 데이터베이스 표에서 사용할 자료들을 멤버변수로 구성 

public class BoardDto {     // 실무에서는 DTO가 여러가지임. (상황에 따라 업데이트 , 뷰 , 등등...)
     // 1. 멤버변수 = 속성 = 테이블(표) 일치 권장*
    private String content;
    private String writer;
    // 2. 생성자 : 관례적으로 기본생성자+풀생성자
    public BoardDto(){ }
    public BoardDto( String content, String writer) {
        this.content = content;
        this.writer = writer;
    }
    // 3. 메소드 : 관례적으로 private 멤버변수에 대해 setter/getter 제공한다.
    public String getWriter() { return writer; }
    public void setWriter(String writer) { this.writer = writer; }
    public String getContent() { return content; }
    public void setContent(String content) {this.content = content;}
    @Override public String toString() {
        return "BoardDto{" +
                "content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                '}';
    }

}