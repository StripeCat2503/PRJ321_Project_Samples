
package cart;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private String customerId;
    private Map<String, Integer> items;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    public void addItemToCart(String itemName){
        // 1. Check cart existed
        if(this.items == null){
            this.items = new HashMap<>();
        }
        // 2. Check item existed
        int quantity = 1;
        if(this.items.containsKey(itemName)){
            quantity = this.items.get(itemName) + 1;
        }
        
        this.items.put(itemName, quantity);
    }
    
    public void removeItemFromCart(String itemName){
        // 1. Check cart existed
        if(this.items == null){
            return;
        }
        
        if(this.items.containsKey(itemName)){
            this.items.remove(itemName);
            if(this.items.isEmpty()){
                this.items = null;
            }
        }
    }
    
}
