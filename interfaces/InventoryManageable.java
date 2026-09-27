package interfaces;

public interface InventoryManageable {
    void addBlood(String bloodGroup, int units);
    boolean removeBlood(String bloodGroup, int units);
    int getBloodUnits(String bloodGroup);
}