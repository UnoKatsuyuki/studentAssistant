package com.assistant.finance;

import java.util.ArrayList;
import java.util.List;

//存储收支记录的类
public class TransactionRepository {
    private final List<Transaction> transactions = new ArrayList<>();  //收支记录列表

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return new ArrayList<>(transactions); // 返回副本，避免外部修改
    }
}
