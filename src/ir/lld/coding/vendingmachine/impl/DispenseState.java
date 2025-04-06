package ir.lld.coding.vendingmachine.impl;

import ir.lld.coding.vendingmachine.Coin;
import ir.lld.coding.vendingmachine.Item;
import ir.lld.coding.vendingmachine.State;
import ir.lld.coding.vendingmachine.VendingMachine;

import java.util.List;

public class DispenseState implements State {

    DispenseState(VendingMachine machine, int codeNumber) throws Exception{

        System.out.println("Currently Vending machine is in DispenseState");
        dispenseProduct(machine, codeNumber);
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {

    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {

    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {

    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {

    }

    @Override
    public int getChange(int returnMoney) throws Exception {
        return 0;
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
        System.out.println("Product has been dispensed");
        Item item = machine.getInventory().getItem(codeNumber);
        machine.getInventory().updateSoldOutItem(codeNumber);
        machine.setVendingMachineState(new IdleState(machine));



        return null;
    }

    @Override
    public List<Coin> refundAllMoney(VendingMachine machine) throws Exception {
        throw new Exception("refund can not be happen in Dispense state");
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        throw new Exception("inventory can not be updated in Dispense state");
    }
}
