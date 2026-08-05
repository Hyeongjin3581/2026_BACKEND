package Day06;

import java.util.Scanner;;

public class OverallController1{
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Post[] posts = new Post[100];
        
        // for 무한반복문
        for(;;){
            System.out.println("==== My Community ====");
            System.out.println("1. 게시물쓰기 2. 게시물선택");
            System.out.println("===================");
            System.out.print("선택> ");
            int ch = scan.nextInt();

            // if ch == 1일 때,
            if(ch==1){
                scan.nextLine();
                System.out.print("내용 : ");
                String content = scan.nextLine();
                System.out.print("작성자 : ");
                String writer = scan.nextLine();

                // post 인스턴스 생성 및 result 초기화
                Post post = new Post(content,writer);
                boolean result = false;

                for(int i=0; i<=posts.length-1;i++){
                    if(posts[i] == null){
                        posts[i] = post;
                        result = true;
                        break;
                    }
                }

                if(result){
                    System.out.println("[안내] 게시물 작성 성공");
                }else{
                    System.out.println("[안내] 게시물 작성 실패");
                }

            }else if(ch==2){
                //향상된 for문 
                for(Post post : posts){
                    if(post != null){
                        System.out.printf("내용 : %s , 작성자 : %s\n",post.content, post.writer);
                    }
                }
            }
            else{
                break;
            }
        }// for end
    }
}

class Post{
    String content;
    String writer;

    Post(){}

    Post(String content, String writer){
        this.content = content;
        this.writer = writer;
    }
}