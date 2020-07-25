import java.lang.Integer;

class Cafeexam {

    public static void main(String[] args) {
        // Cafe starbucks = new Cafe();
        Cafe cafe1 = new Cafe("투썸플레이스");
        Card card = new Card("고객", "1829382983", 4000);
        Boolean result;
        result = cafe1.select(args[0]);
        
        
        if (result) {
            if (args[1].equals("카드")) {
                Boolean res = cafe1.pay(card);
                if (res) {
                    pl("결제 성공");
                    pl("카드 잔액 : " + card.getBalance() + "원");
                } else {
                    pl("결제 실패");
                }
            } else {
                int change = cafe1.pay(Integer.parseInt(args[1]));
                if (change == -1) {
                    pl("결제 실패");
                } else {
                    pl("감사합니다.");
                }
            }
        } else {
            pl("주문한 메뉴가 없습니다.");
        }

        // if (result) {
        //     int change = cafe1.pay(Integer.parseInt(args[1]));
        //     if (change == -1) {
        //         pl("결제 실패");
        //     } else {
        //         pl("감사합니다.");
        //     }
        // } else {
        //     pl("뭐야 왜 없어");
        // }

        // Coffee ame = new Coffee();
        // Coffee mocha = new Coffee("모카", 3500);
        // pl("ame.name : " + ame.getName());
        // pl("ame.price : " + ame.getPrice());
        // pl("mocha.name : " + mocha.getName());
        // pl("mocha.price : " + mocha.getPrice());
        
        // ame.setPrice(50000000);
        // mocha.setPrice(1);

        // pl("ame.name : " + ame.getName());
        // pl("ame.price : " + ame.getPrice());
        // pl("mocha.name : " + mocha.getName());
        // pl("mocha.price : " + mocha.getPrice());

        // String coffee1 = starbucks.select(args[0]);
        // pl(coffee1);

        // if (coffee1 != null && coffee1.contains("선택")) {
        //     int ss_change = starbucks.pay(Integer.parseInt(args[1]));
        //     // pl( String.valueOf(ss_change) );

        //     if (ss_change != -1) {
        //         pl("거스름돈 " + ss_change + "원 입니다.");
        //         String my_coffee = starbucks.getCoffee();
        //         pl(my_coffee);
        //     } else {
        //         pl("고갱님 돈이 부족합니다.");
        //     }
        // } else {
        //     pl("고갱님 " + args[0] + "는(은) 없습니다.");
        // }
        // pl("카페");
        // pl("starbucks.coffee " + starbucks.coffee);
    
        // String coffee1 = starbucks.select("드아");
        // pl(coffee1);
        // String coffee2 = starbucks.select("아아");
        // pl(coffee2);

        // int ss_money = 100000;
        // int jj_money = 3000;

        // int ss_change = starbucks.pay(ss_money);
        // pl( String.valueOf(ss_change) );
        // int jy_change = starbucks.pay(jj_money);
        // pl(jy_change+"");

        // String my_coffee = starbucks.getCoffee();
        // pl(my_coffee);
    }

    public static void pl(String str) {
        System.out.println(str);
    }
}
    