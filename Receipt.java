class Receipt {
    String pay_time;
    String pay_card_no;
    int pay_amount;
    String store_name;
    boolean result;

    public Receipt(boolean result) {
        this.result = result;
    }

    public Receipt(Boolean result, String pay_time, String pay_card_no, int pay_amount, String store_name) {
        this.result = result;
        this.pay_time = pay_time;
        this.pay_card_no = pay_card_no;
        this.pay_amount = pay_amount;
        this.store_name = store_name;
    }

    @Override
    public String toString(){
        if(this.result) {
            return "\n=== 영수증 ===" +"\n" +
                "구매자 카드 번호 : " + pay_card_no + "\n" +
                "판매상점 : " + store_name + "\n" +
                "금액 : " + pay_amount + "\n" +
                "구매일시 : " + pay_time + "\n" +
                "==============" + "\n";
        } else {
            return "결제 실패";
        }
    }
}