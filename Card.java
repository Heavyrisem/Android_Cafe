import java.text.SimpleDateFormat;
import java.util.Date;

class Card {
    private String card_number;
    private String  owner;
    private int cvc;
    private String expire_date;
    private int balance;

    public Card() {
        owner = "표인수";
        card_number = "20030924";
        balance = 1000000000;
    }

    public Card(String owner, String card_number, int balance) {
        this.owner = owner;
        this.card_number = card_number;
        this.balance = balance;
    }

    public Receipt pay(int pay_amount, String store_name) {
        if (pay_amount > 0 && this.balance > pay_amount) {
            this.balance -= pay_amount;
            String now = new SimpleDateFormat("yyyy년 MM월dd일 HH시mm분ss초").format(new Date());
            return (new Receipt(true, now, card_number, pay_amount, store_name));
        } else {
            return (new Receipt(false));
        }
    }
    // public Object pay(int pay_amount, String store_name) {
    //     if (pay_amount > 0 && this.balance > pay_amount) {
    //         this.balance -= pay_amount;
    //         return (new Object() {
    //             boolean result = true;
    //             String now = new SimpleDateFormat("yyyy년 MM월dd일 HH시mm분ss초").format(new Date());
    //             Receipt receipt = new Receipt(now, card_number, pay_amount, store_name);
    //         });
    //     } else {
    //         return (new Object() {
    //             boolean result = false;
    //         });
    //     }
    // }

    public int getBalance() {
        return balance;
    }

    private Boolean setBalance(int balance) {
        this.balance = balance;
        return true;
    }


}