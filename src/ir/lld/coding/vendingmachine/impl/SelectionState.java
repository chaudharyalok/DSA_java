package ir.lld.coding.vendingmachine.impl;

import ir.lld.coding.vendingmachine.Coin;
import ir.lld.coding.vendingmachine.Item;
import ir.lld.coding.vendingmachine.State;
import ir.lld.coding.vendingmachine.VendingMachine;

import java.util.List;

public class SelectionState implements State {

    public SelectionState() {
        System.out.println("Currently vending machine is in selectionState");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        throw new Exception("you cannot click on insert coin button in selection state");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
            return;
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("you cannot insert coin in selection state");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
        // 1. get item of this code number
        Item item = machine.getInventory().getItem(codeNumber);

        // 2. total amount paid by user
        int paidByUser = 0;
        for(Coin coin: machine.getCoinList()){
            paidByUser+=coin.value;
        }

        // 3. compare product price and amount paid by user
        if(paidByUser < item.getPrice()){
            System.out.println("Insufficient amount, Product you selected is for price:"+ item.getPrice() +
                    " and you paid: "+ paidByUser);
            refundAllMoney(machine);
            throw new Exception("Insufficient amount");
        } else if(paidByUser >= item.getPrice()){
            if(paidByUser > item.getPrice()){
                getChange(paidByUser - item.getPrice());
            }
            machine.setVendingMachineState(new DispenseState(machine, codeNumber));
        }
    }

    @Override
    public int getChange(int returnMoney) throws Exception {
        System.out.println("Returned the change in the coin dispense tray"+returnMoney);
        return returnMoney;
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("product cannot be dispensed in selection state");
    }

    @Override
    public List<Coin> refundAllMoney(VendingMachine machine) throws Exception {
        System.out.println("Returned the full amount back in coin dispense tray");
        machine.setVendingMachineState(new IdleState(machine));
        return  machine.getCoinList();
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        throw new Exception("you cannot update inventory in selection state");
    }
}
