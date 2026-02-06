import java.util.Scanner;

public class App {

    private Scanner scanner;
    int lastId = 0;

    public App(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.println("명령) ");
            String cmd = scanner.nextLine();

            switch (cmd) {
                case "등록" -> {
                    System.out.print("명언 : ");
                    String saying = scanner.nextLine();
                    System.out.print("작가 : ");
                    String author = scanner.nextLine();
                    lastId++;
                    System.out.println("%d번 명언이 등록되었습니다." .formatted(lastId));
                }
                case "종료" -> {
                    return;
                }
            }
        }
    }
}
