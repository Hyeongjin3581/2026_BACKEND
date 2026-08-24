package Day16;

public class Exam1 {
    public static void main(String[] args) {
        
        /*
            스레드 : 코드 실행 흐름 단위,
            멀티스레드 : 여러 사용자들이 하나의 웹서버(통캣)에 요청함으로 웹서버는 멀티스레드로 관리.
            장점 : 여러 요청들을 다중처리 , 단점 : 관리(동기화/과부하)
        */

        계산기 calculator  = new 계산기();

        스레드1 thread1 = new 스레드1();
        thread1.calculator = calculator;
        스레드2 thread2 = new 스레드2();
        thread2.calculator = calculator;
        // 서로 다른 스레드 1, 2가 동일한 계산기를 사용하는 중

        thread1.start();
        thread2.start();
       
        // 계산기의 순번에 따라서 후에 온 스레드의 값에따라 Memory값이 산출된다.

        계산기2 calculator2 = new 계산기2();
        
        스레드3 thread3 = new 스레드3();    
        thread3.calculator2 = calculator2;
        스레드4 thread4 = new 스레드4();
        thread4.calculator2 = calculator2;

        thread3.start();
        thread4.start();



    }   // main end
}

class 스레드1 extends Thread{
    public 계산기 calculator;
    @Override public void run(){
            calculator.setMemory(100);
    }
}

class 스레드2 extends Thread{
    public 계산기 calculator;
    @Override public void run(){
            calculator.setMemory(200);
    }
}

class 계산기 {
    public int memory;

    public void setMemory(int memory) {
        this.memory = memory;
        
        try{Thread.sleep(2000);} catch(Exception e){}
        System.out.println("현재 계산기의 값: " + this.memory);
    }
}


class 스레드3 extends Thread{
    public 계산기2 calculator2;
    @Override public void run(){
            calculator2.setMemory(100);
    }
}

class 스레드4 extends Thread{
    public 계산기2 calculator2;
    @Override public void run(){
            calculator2.setMemory(200);
    }
}


class 계산기2 {
    public int memory;

    // synchronized: 한 스레드가 이 메서드를 실행 중이면 다른 스레드는 대기함
    public synchronized void setMemory(int memory) {
        this.memory = memory;
        
        try{ Thread.sleep(2000); } catch(Exception e){}
        
        System.out.println(Thread.currentThread().getName() + "현재 계산기의 값: " + this.memory);
    }
}