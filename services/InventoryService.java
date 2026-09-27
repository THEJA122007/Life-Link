package services;

import java.util.HashMap;

public class InventoryService {
        private HashMap<String, Integer>bloodInventory;

        public InventoryService() {
                bloodInventory = new HashMap<>();
                initializeInventory();
        }

        private void initializeInventory() {
                bloodInventory.put("A+", 0);
                bloodInventory.put("A-", 0);
                bloodInventory.put("B+", 0);
                bloodInventory.put("B-", 0);
                bloodInventory.put("AB+", 0);
                bloodInventory.put("AB-", 0);
                bloodInventory.put("O+", 0);
                bloodInventory.put("O-", 0);
        }

        public void addBlood(String bloodGroup,int units) {
                int currentUnits = bloodInventory.getOrDefault(bloodGroup,0);
                bloodInventory.put(bloodGroup,currentUnits + units);
                System.out.println("Blood inventory updated!");
        }

        public void viewInventory() {
                System.out.println("\n===== BLOOD INVENTORY =====");
                for (String bloodGroup: bloodInventory.keySet()) {
                        System.out.println(bloodGroup+ " : " + bloodInventory.get(bloodGroup)+ " units");
                }
        }
}