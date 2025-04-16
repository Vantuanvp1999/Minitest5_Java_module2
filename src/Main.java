import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MaterialManager manager = new MaterialManager();
        //tao 5 bot
        for (int i = 1; i <= 5; i++) {
            manager.add(new CrispyFlour("C "+i,"Bột "+i, LocalDate.now().minusMonths(i),10000,i*2));

        }
        for (int i = 1; i <= 5; i++) {
            manager.add(new Meat("M"+i,"Thịt"+i, LocalDate.now().minusDays(i),150000,i*1.5));
        }
        manager.printAll();
        System.out.println("Tổng chênh lệch chưa và đã chiết khấu "+manager.getTotalDiscountDifference());
    }
}