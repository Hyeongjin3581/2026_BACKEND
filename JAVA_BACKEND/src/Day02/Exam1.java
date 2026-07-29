package Day02;

public class Exam1 {
    public static void main(String[] args) {
        // == 다형성 == 
        // [1] 자동(묵시적) 타입 변환   byte --> short --> int --> long --> float --> double 
        byte bytevalue = 100;  // byte 타입에 bytevalue 변수명으로 100 리터럴 대입했다.
        short shortvalue = bytevalue; // [가능] byte -> short [*자료유지, 타입변경]
        int intvalue = shortvalue; // [가능] short -> int [*자료유지, 타입변경]
        long longvalue = intvalue; // [가능] int -> long [*자료유지, 타입변경] 
        float floatvalue = longvalue; // [가능] long -> float [*자료유지, 타입변경] 
        double doublevalue = floatvalue; // [가능] float -> double [*자료유지, 타입변경] 
        // * 연산 (계산) 중에 자동 타입변환
        byte b1 =  10; byte b2 = 20;
        int result1 = b1+ b2; // byte + byte = int

        // [2] 강제 타입 변환
    }
}
