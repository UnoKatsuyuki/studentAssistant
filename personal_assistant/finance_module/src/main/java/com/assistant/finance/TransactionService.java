package com.assistant.finance;

import java.time.LocalDate;
import java.util.List;

//添加收支记录和计算结余功能实现类
public class TransactionService {
    private final TransactionRepository repository;  //一条收支记录

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    /**
     * 添加一条收支记录
     */
    public void addTransaction(double amount, TransactionType type, LocalDate date, String description) {
        if (amount <= 0) {
            throw new IllegalArgumentException("金额必须为正数");  //处理金额异常情况
        }
        repository.addTransaction(new Transaction(amount, type, date, description));  //正常添加一条收支记录
    }

    /**
     * 统计指定年月的结余 = 收入 - 支出
     */
    public double calculateMonthlyBalance(int year, int month) {
        List<Transaction> all = repository.getAllTransactions();  //获取所有收支记录
        double income = 0, expense = 0;  //初始化总收入和总支出

        //遍历所有收支记录，计算总收入和总支出
        for (Transaction t : all) {
            if (t.getDate().getYear() == year && t.getDate().getMonthValue() == month) {
                if (t.getType() == TransactionType.INCOME) {
                    income += t.getAmount();
                } else {
                    expense += t.getAmount();
                }
            }
        }

        return income - expense;  //计算结余
    }

}
