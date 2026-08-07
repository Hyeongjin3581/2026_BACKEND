package Day08.pakage1;  // 패키지란? 클래스들의 위치 식별

public class A {
    public int 공개변수; 
    private int 비공개변수; 
    // 조금 위험한 정보에 대해선 private을 하여 사전차단.(현재 class내에서만 구동. )
    int 일반변수;

    public void 공개메소드(){}
    private void 비공개메소드(){}
    void 일반메소드(){ 비공개변수 = 3;}
}
