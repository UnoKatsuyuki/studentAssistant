import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TransactionRepository repository = new TransactionRepository();
        TransactionService service = new TransactionService(repository);

        while (true) {
            System.out.println("请输入收支信息：");
            System.out.println("1. 添加收入");
            System.out.println("2. 添加支出");
            System.out.println("3. 退出");
            System.out.print("请输入选项 (1/2/3): ");
            int option = scanner.nextInt();
            scanner.nextLine(); // 吸收换行符

            if (option == 3) {
                System.out.println("退出程序...");
                break;
            }

            System.out.print("请输入金额: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // 吸收换行符

            System.out.print("请输入日期 (格式: yyyy-MM-dd): ");
            String dateInput = scanner.nextLine();
            LocalDate date = LocalDate.parse(dateInput);

            System.out.print("请输入描述: ");
            String description = scanner.nextLine();

            try {
                if (option == 1) {
                    // 添加收入
                    service.addTransaction(amount, TransactionType.INCOME, date, description);
                    System.out.println("收入记录已添加。");
                } else if (option == 2) {
                    // 添加支出
                    service.addTransaction(amount, TransactionType.EXPENSE, date, description);
                    System.out.println("支出记录已添加。");
                } else {
                    System.out.println("无效的选项，请重新输入。");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("错误: " + e.getMessage());
            }

            // 打印当前结余
            double balance = service.calculateMonthlyBalance(date.getYear(), date.getMonthValue());
            System.out.printf("当前结余：%.2f元%n", balance);
        }

        scanner.close();
    }
}
