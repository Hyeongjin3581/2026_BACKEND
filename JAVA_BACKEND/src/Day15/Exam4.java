package Day15;

import java.util.Scanner;
import java.awt.*;
import java.time.LocalTime;

import com.mysql.cj.protocol.ExportControlled;

public class Exam4 {
    public static void main(String[] args) {
        // [1] 시계 구현
        // 1. 새로운 작업(시계) 스레드 실행

        시계스레드 runnable1 = new 시계스레드();    // 구현체 생성
        Thread thread = new Thread(runnable1);      // 스레드객체에 구현체 대입
        thread.start();                                                  // 스레드객체 시작, [1.MAIN]가 [2.시계스레드] 스레드 켠다.

         // [3] 타이머 구현 [3. 타이머스레드]
        타이머스레드 thread2 = null;

        // [2] 입력 구현
        while (true){
            System.out.println("1.ON    ,   2.OFF   : ");
            Scanner scan = new Scanner(System.in);
            int ch = scan.nextInt();

            if( ch == 1){
                thread2 = new 타이머스레드();
                thread2.start();    // [1.Main 스레드] 가 [3.타이머스레드]를 켠다. 
            }
            if( ch == 2){
                // 만약에 현재 스레드가 존재하면 상태 false 하여 [3.타이머스레드] 무한루프 종료1

                if(thread2 != null){
                    thread2.state = false;  // 밑에있는 타이머스레드2 의   public boolean state = true;    타이머작동여부값 변경. 
                }
            }

        }   // while end 
    }   // main end [1. MAIN스레드 ] 사망(프로그램 끝)
}

class 시계스레드 implements Runnable{   // Runnable 인터페이스 구현하면 멀티스레드 정의
    @Override
    public void run() { // 멀티스레드가 처리할 작업
        while( true ){ // 무한루프
            System.out.println( LocalTime.now() ); // 현재시간
            try{Thread.sleep(1000);}catch(Exception e){ }   // 1초 일시정지
        }
    }   // run 종료도면 작업스레드 종료 
}

class 타이머스레드 extends Thread{
    public boolean state = true;    // 타이머 작동여부
    @Override
    public void run() {
        int time = 0;
        while( state ) { // 타이머 작동여부가 true 인 경우만 무한루프 / false 종료 
            time++ ;    // 1초 증가
            System.out.println( ">> 타이머 : " + time + "초");
            try{ Thread.sleep(1000); }catch(Exception e){}
        }
    }   // run 종료되면 작업스레드 종료
}


// [1]. 자바 프로젝트로 깃 저장소 생성시 bin 폴더제외 해야함. * ignore 
// bin 폴더는 코드 파일이 아니고 코드가 컴파일된 파일이므로 취합 x 

//1-1. 프로젝트 폴더 세팅 (MVC) / JDBC.jar 추가.
//1- 2. AppStart , Dto , Dao , Controller  , view 같은 내용을 폴더당 임의 파일1개 삽입 후 생성하는게 좋음. (* 빈 폴더는 커밋안됨. )
//1-3. 프로젝트 최상단 폴더에 .gitignore파일 만들기
// 1-4  해당 파일 안에 **/bin/ 내용 작성

// [2] 조장이 해야하는 세팅. 
// 일정(미니프로젝트)을 작성해야 하는데, 인터넷이 *지라* 라고 작성하면, 프로젝트 할 때 사용하는 칸반/스크럼보드 (일정 & 이슈관리)  프로그램을 사용해주면 좋음 .

// 2-1 지라 프로젝트 생성하여 '타임라인' 에 일정 작성.  https://www.atlassian.com/ko/software/jira
// 2-2 구글 로그인(최초 로그인시 사이트이름 설정(아무거나)) / 2-3 [조장] 프로젝트(새 스페이스) 생성 
// 2-4 범주 -> 소프트웨어 개발 -> 칸반(카드형태) or 스크럼보드(애자일 작업단위) [정규땐 스크럼보드 사용할 예정.]
// 2-5 이번 프로젝트는 타임라인을 활용, 스페이스 상단에 ... 을 클릭한 후 팀원들을 초대하여 우측 하단에 [주]단위로 설정, / 
// 2-6 [만들기 에픽]을 추가하여 "기획 및 설계"  막대 조정 및 하위 에픽에 [기획서 작성] 및 [데이터베이스 설계] 생성  / 구현  / 테스트 를 생성.
// 2-7 구현 하위에픽에 [로그인 구현]을 세팅한다면 , 해당 에픽에 담당자를 정할 수 있는데, 이 기능까지 활용하여 API 명세서를 기준으로 담당자 설정. 