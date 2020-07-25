import java.util.*;

class Cafe {

    String name;
    Coffee selected_coffee;
    int balance = 100000;
    int change = 0;
    Queue<Coffee> menus; 

    public Cafe(String cafe_name) {
        this.name = cafe_name;
        menus = new LinkedList<Coffee>();
        menus.offer(new Coffee("아아", 3000));
        menus.offer(new Coffee("뜨아", 3500));
        menus.offer(new Coffee("모카", 4000));
        menus.offer(new Coffee("카라멜마끼아또", 5000000));        
    }

    public boolean select(Coffee coffee) {

        Iterator<Coffee> menu_itr = menus.iterator();

        while (menu_itr.hasNext()) {
            Coffee tmpCoffee = menu_itr.next();
            if (tmpCoffee.equals(coffee)) {
                selected_coffee = tmpCoffee;
                return true;
            }
        }

        return false;
    }

    public int pay(int money) {
        if (money > 0 && money >= selected_coffee.getPrice()) {
            change = money - selected_coffee.getPrice();
            if (balance > change) {
                balance -= change;
                if (change != 0) {
                    System.out.println("고객님 거스름돈 " + change + "원 입니다");
                }
                // returnCoffee();
                return change;
            } else {
                System.out.println("고객님 죄송합니다. 거스름돌을 돌려줄 잔고가 없네요.");
                return -1;
            }
        } else {
            System.out.println("고객님 돈 제대로 줘");
            return -1;
        }
    }

    public boolean pay(Card card) {
        Receipt payment_result = card.pay(selected_coffee.getPrice(), this.name);
        
        if (payment_result.result) {
            System.out.println("고객님 " + payment_result.pay_amount + "원이 " + payment_result.pay_card_no + "에서 결제되었습니다.");
            System.out.println(payment_result);
            return true;
        } else {
            System.out.println("카드의 잔액이 부족해서 결제를 진행할 수 없습니다");
            return false;
        }
        
    }

    public Coffee[] getMenus() {
        return menus.toArray(new Coffee[menus.size()]);
    }

    private String returnCoffee() {
        String return_coffee = selected_coffee.getName();
        System.out.println("고객님 " + return_coffee + " 나왔습니다");
        return selected_coffee.getName();
    }
}