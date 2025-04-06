package ir.lld.designpatterns.behavioural.factory;

public class FactoryPattern {

    public static void main(String arr[]){
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape1 = shapeFactory.getShape("SQUARE");
        Shape shape2 = shapeFactory.getShape("CIRCLE");

        shape1.draw();
        shape2.draw();
    }
}
