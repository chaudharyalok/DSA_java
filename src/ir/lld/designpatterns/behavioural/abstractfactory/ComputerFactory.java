package ir.lld.designpatterns.behavioural.abstractfactory;

public class ComputerFactory {

    public static Computer getComputer(ComputerAbstractFactory factory) {
        return factory.createComputer();
    }
}
