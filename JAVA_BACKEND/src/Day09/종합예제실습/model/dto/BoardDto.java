package Day09.종합예제실습.model.dto;

public class BoardDto {     // 실무에서는 DTO가 여러가지임. (상황에 따라 업데이트 , 뷰 , 등등...)
     // 1. 멤버변수 = 속성 = 테이블(표) 일치 권장*
    private String phone;
    private int number;
    // 2. 생성자 : 관례적으로 기본생성자+풀생성자
    public BoardDto(){ }
    public BoardDto( String phone, int number) {
        this.phone = phone;
        this.number = number;
    }
    // 3. 메소드 : 관례적으로 private 멤버변수에 대해 setter/getter 제공한다.

    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}
    public int getNumber() {return number;}
    public void setNumber(int number) {this.number = number;}
    @Override public String toString() {
        return "BoardDto{" +
                "phone='" + phone + '\'' +
                ", number='" + number +  
                '}';
    }
}