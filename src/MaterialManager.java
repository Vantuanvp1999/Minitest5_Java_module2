import java.util.ArrayList;

public class MaterialManager {
    private ArrayList<Material> materials = new ArrayList<Material>();

    public void add(Material material) {
        materials.add(material);
        System.out.println("Đã Thêm "+material.getName());
    }
    public void delete(String id,Material material) {
        for(Material m : materials) {
            if(m.getId().equals(id)) {
                materials.remove(material);
                System.out.println("Đã xóa "+material.getName());
            }
        }

    }
    public void edit(String id,Material material) {
        for(int i = 0; i < materials.size(); i++) {
            if(materials.get(i).getId().equals(id)) {
                materials.set(i, material);
                break;
            }
        }
    }
    public void printAll() {
        for(Material m : materials) {
            System.out.println("ID: "+m.getId()+", name: "+m.getName()+", amount: "
                    +m.getAmount()+", real money: "+((Discount)m).getRealMoney());
        }
    }
    public double getTotalDiscountDifference() {
        double total = 0;
        for(Material m : materials) {
            total+= m.getAmount() -((Discount)m).getRealMoney();
        }
        return total;
    }
}
