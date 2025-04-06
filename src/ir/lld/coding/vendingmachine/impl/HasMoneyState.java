package ir.lld.coding.vendingmachine.impl;

import ir.lld.coding.vendingmachine.Coin;
import ir.lld.coding.vendingmachine.Item;
import ir.lld.coding.vendingmachine.State;
import ir.lld.coding.vendingmachine.VendingMachine;

import java.util.List;

public class HasMoneyState implements State {

    public HasMoneyState() {
        System.out.println("Currently vending machine is in has money state");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        return;
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
        machine.setVendingMachineState(new SelectionState());
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        System.out.println("Accepted the coin");
        machine.getCoinList().add(coin);
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("first you need to click on start product selection button");
    }

    @Override
    public int getChange(int returnMoney) throws Exception {
        throw new Exception("you cannot get change in hasmoney state");
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("product cannot be dispensed in hasmoney state");
    }

    @Override
    public List<Coin> refundAllMoney(VendingMachine machine) throws Exception {
        System.out.println("Refund the full amount back in the coin dispense tray");
        List<Coin> coinList = machine.getCoinList();
        machine.setVendingMachineState(new IdleState(machine));
        return coinList;
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        throw new Exception("you cannot update inventory in hasmoney state");
    }
}
