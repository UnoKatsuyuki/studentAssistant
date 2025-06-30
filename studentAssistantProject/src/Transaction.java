import java.time.LocalDate;

//收支记录实体类
public class Transaction {
    private final double amount;  //收支金额
    private final TransactionType type;  //收支类型
    private final LocalDate date;  //收支记录的时间
    private final String description;  //收支记录描述

    public Transaction(double amount, TransactionType type, LocalDate date, String description) {
        this.amount = amount;
        this.type = type;
        this.date = date;
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

}
