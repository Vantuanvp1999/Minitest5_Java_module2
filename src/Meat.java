import java.time.LocalDate;
import java.time.Period;

public class Meat extends Material implements Discount {
    double weight;

    public Meat() {
    }

    public Meat(double weight) {
        this.weight = weight;
    }

    public Meat(String id, String name, LocalDate manufacturingDate, int cost, double weight) {
        super(id, name, manufacturingDate, cost);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double getRealMoney() {
        Period period = Period.between(getExpiryDate(), LocalDate.now());
        if(period.getDays() <=5 ){
            return getAmount()*70/100;

        }else{
            return getAmount()*90/100;
        }
    }

    @Override
    public double getAmount() {
        return weight*getCost();
    }

    @Override
    public LocalDate getExpiryDate() {
        return getManufacturingDate().plusDays(7);
    }
}
