

void main() {
    Scanner input =new Scanner(System.in);
    System.out.print("Enter the discount : ");
    double Discount=input.nextDouble();
    System.out.print("Enter the priceAfterDiscount : ");
    double priceAfterDiscount=input.nextDouble();

    product Fristproduct=new product(Discount,priceAfterDiscount);
}
