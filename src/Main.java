import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        float score;
        int totalStudent = 0;
        double totalScore = 0;
        double maxScore = Double.MIN_VALUE;
        double minScore = Double.MAX_VALUE;
        do {
            System.out.println("*************MENU NHẬP ĐIỂM***************");
            System.out.println("1. Nhập điểm học viên");
            System.out.println("2. Hiện thị thống kế");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 ->{
                    do {
                        System.out.print("Nhập điểm: ");
                        score = Float.parseFloat(scanner.nextLine());
                        if(score < -1 || score > 10) {
                            System.out.println("Điểm không hợp lệ. Nhập lại.");
                            score = Float.parseFloat(scanner.nextLine());
                        }
                        if (score == -1){
                            break;
                        }
                        // Cập nhật thống kê
                        totalStudent++;
                        totalScore += score;

                        if (score > maxScore) {
                            maxScore = score;
                        }

                        if (score < minScore) {
                            minScore = score;
                        }
                        if (score < 5) {
                            System.out.println("Xếp loại: Yếu");
                        } else if (score < 7) {
                            System.out.println("Xếp loại: Trung Bình");
                        } else if (score < 8) {
                            System.out.println("Xếp loại: Khá");
                        } else if (score < 9) {
                            System.out.println("Xếp loại: Giỏi");
                        } else {
                            System.out.println("Xếp loại: Xuất sắc");
                        }
                    }while(score != -1);
                }
                case 2 ->{
                    if (totalStudent == 0) {
                        System.out.println("Chưa có dữ liệu.");
                    } else {
                        System.out.println("\n===== THỐNG KÊ =====");
                        System.out.println("Số học viên: " + totalStudent);
                        System.out.printf("Điểm trung bình: %.2f\n", totalScore / totalStudent);
                        System.out.printf("Điểm cao nhất: %.2f\n", maxScore);
                        System.out.printf("Điểm thấp nhất: %.2f\n", minScore);
                    }
                    break;
                }
                case 3 ->{
                        System.out.println("Kết thúc chương trình.");
                        scanner.close();
                        System.exit(0);
                }
                default ->{
                    System.out.println("Lựa chọn không hợp lệ.");
                }
            }
        }while (true);
    }
}