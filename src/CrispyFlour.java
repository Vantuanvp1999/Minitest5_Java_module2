import java.time.LocalDate;
import java.time.Period;

public class CrispyFlour extends Material implements Discount {
    private int quantity;

    public CrispyFlour() {
    }

    public CrispyFlour(int quantity) {
        this.quantity = quantity;
    }

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, int quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double getRealMoney() {
        Period period = Period.between(getExpiryDate(), LocalDate.now());
        if (period.getMonths() >= 2) {
            return getAmount()*60/100;
        }else if (period.getMonths() >= 4) {
            return getAmount()*80/100;
        }else{
            return getAmount()*95/100;
        }
    }

    @Override
    public double getAmount() {
        return getQuantity()*getCost();
    }

    @Override
    public LocalDate getExpiryDate() {
        return getManufacturingDate().plusYears(1);
    }
}
