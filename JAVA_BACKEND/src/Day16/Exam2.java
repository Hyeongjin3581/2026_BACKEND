package Day16;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Exam2 {
    public static void main(String[] args) {
        /*
                스레드 풀 :  매번 새로운 스레드를 생성하지 않고 미리 일정한 스레드풀에 생성
                목적 : 과부하 방지
                구조 : 선입선출 (queue) 방식으로 먼저 요청이 들어온 순서대로 *대기중인* 스레드가 처리한다. 
                    *) 만일 대기중인 스레드가 없으면 요청은 wait(대기) 상태이며 스레드가 작업이 끝나고 대기중인 요청 처리.
                활용처 : 웹서버(톰캣), JDBC ,   대규모 서버의 안전한 구축을 위해 사용 , 등등
        */
       // [1] 스레드풀 구축 ,  메서드의 반환 타입은 상위 인터페이스인 ExecutorService로 선언되어 있습니다.
       ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);  // 강제타입변환 다운캐스팅.
       //ThreadPoolExecutor 타입으로 형변환하면 스레드 풀의 세부 상태를 모니터링하거나 제어하는 전용 메서드들을 사용할 수 있게 됩니다.

       // [2] 임의의 요청 스레드 생성 (구현체)
       Runnable runnable = new Runnable(){
        @Override public void run(){
            for(int i=1; i<=20; i++){
                try{Thread.sleep(3000);}catch(Exception e){}
                CallTask task = new CallTask(i);
                poolExecutor.submit(task);

                // [6] 현재 스레드 상태
                int 작업중인스레드수 = poolExecutor.getActiveCount();
                int 대기중인스레드수 = poolExecutor.getCorePoolSize() - 작업중인스레드수;
                int 대기중인요청수 = poolExecutor.getQueue().size();

                System.out.println("작업중인 스레드수 : " + 작업중인스레드수);
                System.out.println("대기중인 스레드수 : " + 대기중인스레드수);
                System.out.println("대기중인 요청수 : " + 대기중인요청수);
                }// for end
                poolExecutor.shutdown();
            } //run
       }; // runnable
       // [5]구현체 start
       Thread thread = new Thread(runnable);
       thread.start();

    }   // main end
}

//[2] 작업(요청)스레드
class CallTask implements Runnable{
    private Random random = new Random();
    private int id;     // 스레드 식별용
    public CallTask(int id){this.id = id;}
    @Override public void run(){
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName +"상담원이 고객통화 시작됨 고객id : " +id);
        try{Thread.sleep(6000 + random.nextInt(6000));}catch(Exception e){}
        System.out.println(threadName+"상담원이 고객통화 종료됨");
    }
}