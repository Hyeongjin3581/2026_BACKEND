package Day09.종합예제실습2.model.dto;

public class BoardDto {
    private int bookNum;
    private String bookName;    
    public BoardDto(int bookNum, String bookName) {
        this.bookNum = bookNum;
        this.bookName = bookName;
    }
    public int getBookNum() {
        return bookNum;
    }
    public void setBookNum(int bookNum) {
        this.bookNum = bookNum;
    }
    public String getBookName() {
        return bookName;
    }
    @Override
    public String toString() {
        return "BoardDto [bookNum=" + bookNum + ", bookName=" + bookName + "]";
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }


}
