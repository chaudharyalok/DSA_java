package ir.lld.coding.vendingmachine.impl;

import ir.lld.coding.vendingmachine.Coin;
import ir.lld.coding.vendingmachine.Item;
import ir.lld.coding.vendingmachine.State;
import ir.lld.coding.vendingmachine.VendingMachine;

import java.util.ArrayList;
import java.util.List;

public class IdleState implements State {
    public IdleState() {
        System.out.println("Currently vending machine is in idle state");
    }

    public IdleState(VendingMachine machine){
        System.out.println("Currently vending machine is in idle state");
        machine.setCoinList(new ArrayList<>());
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        machine.setVendingMachineState(new HasMoneyState());
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
            throw new Exception("first you need to click on insert coin button");
    }


    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("you cannot insert Coin in idle state");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("you cannot choose product in idle state");
    }

    @Override
    public int getChange(int returnMoney) throws Exception {
        throw new Exception("you cannot get change in idle state");
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("you cannot dispense product in idle state");
    }

    @Override
    public List<Coin> refundAllMoney(VendingMachine machine) throws Exception {
        throw new Exception("you cannot get refund in idle state");
    }


    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
            machine.getInventory().addItem(item,codeNumber);
    }
}
