package Day06;

import java.util.Scanner;
public class OverallController1 {
    public static void main(String[] args) {
        memberRepository repository = new memberRepository();
        Scanner scan = new Scanner(System.in);
        for (;;) {
            System.out.println("============ My Community ============ ");
            System.out.println("1.회원 설정 2.회원 정보 출력");
            System.out.println("====================================== ");
            System.out.print("선택>");
            int ch = scan.nextInt();


            //class memberTable{
    int memberID;
    String userID;
    String userPW;
    String userName;
    String userPhoto;
}
            if (ch == 1) {
                scan.nextLine();
                System.out.print("회원고유ID : ");     int memberID = scan.nextInt();
                System.out.print("유저ID : ");   String userID = scan.nextLine();


                memberTable post = new memberTable(content, writer);
                boolean result = repository.save(post);

                if (result) { System.out.println("[안내] 글쓰기 성공");} 
                else { System.out.println("[안내] 글쓰기 실패"); }

            } else if (ch == 2) {
                Post[] posts = repository.findAll();
                for (Post post : posts) {
                    if (post != null) {
                        System.out.printf("작성자 : %s , 내용 : %s \n", post.writer, post.content);
                    }
                }
            }
        }
    }
}

//리뷰 레포지토리 데이터 저장 및 반환(조회) 비즈니스 로직 전담 클래스
class reviewRepository {

    ReviewTable[] review = new ReviewTable[100];

    // 리뷰테이블에 저장
    boolean save(ReviewTable revTable) {
        for (int index = 0; index < review.length; index++) {
            if (review[index] == null) {
                review[index] = revTable;
                return true;
            }
        }
        return false;
    }
    // 리뷰테이블 전체 목록 반환
    ReviewTable[] findAll() {
        return review;
    }
}


// 리뷰테이블 class 생성
class ReviewTable{
    String review;
    int score;
    String listDay;

    //기본 생성자 생성
    ReviewTable(){}

    ReviewTable(String review, int score, String listDay){
        this.review = review;
        this.score = score;
        this.listDay = listDay;
    }
}



class memberTable{
    int memberID;
    String userID;
    String userPW;
    String userName;
    String userPhoto;

    //기본생성자
    memberTable(){}

    memberTable(int memberID, String userID, String userPW, String userName,String userPhoto){
        this.memberID = memberID;
        this.userID = userID;
        this.userPW = userPW;
        this.userName = userName;
        this.userPhoto = userPhoto;
    }
}



//  등록 2개 , 출력 2개 
// class 2개만 만들고,  controller 1개 ( main )  ,repository( 배열 / 등록 / 출력 4개 메소드 )