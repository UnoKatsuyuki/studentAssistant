package com.assistant.finance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionServiceTest {

    private TransactionRepository repository;
    private TransactionService service;

    @BeforeEach
    void setUp() {
        // 每次测试前初始化，确保测试之间的数据隔离
        repository = new TransactionRepository();
        service = new TransactionService(repository);
    }

    // 正常情况测试：添加收入
    @Test
    void addIncomeTransaction_PositiveAmount_AddsTransaction() {
        double amount = 100.0;
        LocalDate date = LocalDate.of(2023, 10, 26);
        String description = "工资";

        service.addTransaction(amount, TransactionType.INCOME, date, description);

        List<Transaction> transactions = repository.getAllTransactions();
        assertEquals(1, transactions.size());
        Transaction addedTransaction = transactions.get(0);
        assertEquals(amount, addedTransaction.getAmount());
        assertEquals(TransactionType.INCOME, addedTransaction.getType());
        assertEquals(date, addedTransaction.getDate());
        assertEquals(description, addedTransaction.getDescription());
    }

    // 正常情况测试：添加支出
    @Test
    void addExpenseTransaction_PositiveAmount_AddsTransaction() {
        double amount = 50.0;
        LocalDate date = LocalDate.of(2023, 10, 27);
        String description = "购物";

        service.addTransaction(amount, TransactionType.EXPENSE, date, description);

        List<Transaction> transactions = repository.getAllTransactions();
        assertEquals(1, transactions.size());
        Transaction addedTransaction = transactions.get(0);
        assertEquals(amount, addedTransaction.getAmount());
        assertEquals(TransactionType.EXPENSE, addedTransaction.getType());
        assertEquals(date, addedTransaction.getDate());
        assertEquals(description, addedTransaction.getDescription());
    }

    // 异常情况测试：添加金额为零的交易
    @Test
    void addTransaction_ZeroAmount_ThrowsIllegalArgumentException() {
        double amount = 0.0;
        LocalDate date = LocalDate.now();
        String description = "零金额交易";

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            service.addTransaction(amount, TransactionType.INCOME, date, description);
        });

        assertEquals("金额必须为正数", thrown.getMessage());
        assertTrue(repository.getAllTransactions().isEmpty()); // 确保没有添加交易
    }

    // 异常情况测试：添加金额为负数的交易
    @Test
    void addTransaction_NegativeAmount_ThrowsIllegalArgumentException() {
        double amount = -10.0;
        LocalDate date = LocalDate.now();
        String description = "负金额交易";

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            service.addTransaction(amount, TransactionType.EXPENSE, date, description);
        });

        assertEquals("金额必须为正数", thrown.getMessage());
        assertTrue(repository.getAllTransactions().isEmpty()); // 确保没有添加交易
    }

    // 正常情况测试：计算月结余（有收入有支出）
    @Test
    void calculateMonthlyBalance_MixedTransactions_ReturnsCorrectBalance() {
        // 添加收入
        service.addTransaction(200.0, TransactionType.INCOME, LocalDate.of(2023, 10, 1), "兼职收入");
        service.addTransaction(150.0, TransactionType.INCOME, LocalDate.of(2023, 10, 15), "零花钱");
        // 添加支出
        service.addTransaction(50.0, TransactionType.EXPENSE, LocalDate.of(2023, 10, 5), "咖啡");
        service.addTransaction(30.0, TransactionType.EXPENSE, LocalDate.of(2023, 10, 20), "午餐");

        double balance = service.calculateMonthlyBalance(2023, 10);
        assertEquals(200.0 + 150.0 - 50.0 - 30.0, balance, 0.001); // 使用 delta 进行浮点数比较
    }

    // 边界条件测试：计算月结余（只有收入）
    @Test
    void calculateMonthlyBalance_OnlyIncome_ReturnsCorrectBalance() {
        service.addTransaction(300.0, TransactionType.INCOME, LocalDate.of(2023, 11, 10), "奖学金");
        service.addTransaction(100.0, TransactionType.INCOME, LocalDate.of(2023, 11, 20), "礼物");

        double balance = service.calculateMonthlyBalance(2023, 11);
        assertEquals(300.0 + 100.0, balance, 0.001);
    }

    // 边界条件测试：计算月结余（只有支出）
    @Test
    void calculateMonthlyBalance_OnlyExpense_ReturnsCorrectBalance() {
        service.addTransaction(70.0, TransactionType.EXPENSE, LocalDate.of(2023, 12, 5), "书本费");
        service.addTransaction(20.0, TransactionType.EXPENSE, LocalDate.of(2023, 12, 15), "交通费");

        double balance = service.calculateMonthlyBalance(2023, 12);
        assertEquals(- (70.0 + 20.0), balance, 0.001);
    }

    // 边界条件测试：计算月结余（无任何交易）
    @Test
    void calculateMonthlyBalance_NoTransactions_ReturnsZero() {
        double balance = service.calculateMonthlyBalance(2024, 1);
        assertEquals(0.0, balance, 0.001);
    }

    // 边界条件测试：计算月结余（有其他月份的交易）
    @Test
    void calculateMonthlyBalance_TransactionsInOtherMonths_IgnoresThem() {
        service.addTransaction(100.0, TransactionType.INCOME, LocalDate.of(2023, 9, 1), "9月收入");
        service.addTransaction(50.0, TransactionType.EXPENSE, LocalDate.of(2023, 11, 1), "11月支出");
        service.addTransaction(200.0, TransactionType.INCOME, LocalDate.of(2023, 10, 1), "当月收入");

        double balance = service.calculateMonthlyBalance(2023, 10);
        assertEquals(200.0, balance, 0.001);
    }

    // 边界条件测试：计算月结余（跨年交易）
    @Test
    void calculateMonthlyBalance_TransactionsAcrossYears_FiltersByYear() {
        service.addTransaction(100.0, TransactionType.INCOME, LocalDate.of(2023, 10, 1), "去年收入");
        service.addTransaction(50.0, TransactionType.INCOME, LocalDate.of(2024, 10, 5), "今年收入");
        service.addTransaction(20.0, TransactionType.EXPENSE, LocalDate.of(2024, 10, 10), "今年支出");

        double balance = service.calculateMonthlyBalance(2024, 10);
        assertEquals(50.0 - 20.0, balance, 0.001);
    }

    // 正常情况测试：TransactionRepository 的 getAllTransactions 返回副本
    @Test
    void getAllTransactions_ReturnsCopy() {
        service.addTransaction(10.0, TransactionType.INCOME, LocalDate.now(), "测试");
        List<Transaction> transactions1 = repository.getAllTransactions();
        List<Transaction> transactions2 = repository.getAllTransactions();

        assertNotSame(transactions1, transactions2); // 应该返回不同的List对象
        assertEquals(transactions1, transactions2); // 内容应该相同
    }


}