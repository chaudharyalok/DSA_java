package ir.lld.coding.vendingmachine;

public class Inventory {

    ItemShelf[] inventory = null;

    public Inventory(int itemCount) {
        this.inventory = new ItemShelf[itemCount];
        initialEmptyInventory();
    }

    public ItemShelf[] getInventory() {
        return inventory;
    }

    public void setInventory(ItemShelf[] inventory) {
        this.inventory = inventory;
    }

    public void initialEmptyInventory(){
        int startCode = 101;
        for(int i = 0; i < inventory.length; i++){
            ItemShelf space = new ItemShelf();
            space.setCode(startCode);
            space.setSoldOut(true);
            inventory[i] = space;
            startCode++;
        }
    }

    public void addItem(Item item, int codeNumber) throws Exception{
        for(ItemShelf itemShelf : inventory){
            if(itemShelf.getCode() == codeNumber){
                if(itemShelf.isSoldOut() == true){
                    itemShelf.setItem(item);
                    itemShelf.setSoldOut(false);
                } else{
                    throw new Exception("item already present you cannot add item here");
                }
            }
        }
    }

    public Item getItem(int codeNumber) throws Exception{
        for(ItemShelf itemShelf : inventory){
            if(itemShelf.getCode() == codeNumber){
                if(!itemShelf.isSoldOut()) {
                    return itemShelf.getItem();
                }
            }
        }
        throw new Exception("item not present in inventory");
    }

    public void updateSoldOutItem(int codeNumber){
        for(ItemShelf itemShelf : inventory){
            if(itemShelf.getCode() == codeNumber){
                itemShelf.setSoldOut(true);
                return;
            }
        }

    }
}
