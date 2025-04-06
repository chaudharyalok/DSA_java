package ir.lld.designpatterns.behavioural.decorator;

public class DecoratorPattern {
    public static void main(String arr[]){
        // we need farmhouse + extracheese
        BasePizza bp = new Farmhouse();
        BasePizza extraCheese = new ExtraCheese(bp);

        System.out.println("farmhouse + extracheese cost:" + extraCheese.getCost());

        // we need farmhouse + extracheese + mushroom
        BasePizza extraCheeseMushroom = new Mushroom(extraCheese);
        System.out.println("farmhouse + extracheese + mushroom cost:" + extraCheeseMushroom.getCost());

        // we can continue decorating BasePizza with as many combination as we want


    }
}
