public class product {
    private double discount;
    private double priceAfterDiscount;

    public   product (double discount ,double priceAfterDiscount ){
        setDiscount(discount);
        setPriceAfterDiscount(priceAfterDiscount);
        System.out.print("The Discount is "+getDiscount()+
                         "The Price Afther Discount is "+getPriceAfterDiscount()+
                         "The Price Before Discount is "+basePrice(getDiscount(),getPriceAfterDiscount()));

    }

    public double getDiscount() {
        return discount;
    }
    public double getPriceAfterDiscount() {
        return priceAfterDiscount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
    public void setPriceAfterDiscount(double priceAfterDiscount) {
        this.priceAfterDiscount = priceAfterDiscount;
    }


    public  double basePrice(double discount,double priceAfterDiscount){
        return (priceAfterDiscount * 100) / (100 - discount);

    }
}
