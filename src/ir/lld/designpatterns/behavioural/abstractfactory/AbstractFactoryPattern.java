package ir.lld.designpatterns.behavioural.abstractfactory;

public class AbstractFactoryPattern {

    public static void main(String arr[]){
    /*    Computer ps = ComputerFactory.getComputer(new PCFactory("4","200", "2.4gz"));
        Computer server = ComputerFactory.getComputer(new ServerFactory("64","2000", "2.9gz"));

        System.out.println("ps created: " + ps);
        System.out.println("server created: " + server);*/



        // another way of calling
        ComputerAbstractFactory abstractFactory = AbstractgetFactoryInstance("PC");
        System.out.println("ps created: " + abstractFactory.createComputer())   ;



    }

    private static ComputerAbstractFactory AbstractgetFactoryInstance(String value) {

        if("PC".equalsIgnoreCase(value)){
            return new PCFactory("4","200", "2.4gz");
        }else if("server".equalsIgnoreCase(value)){
            return new ServerFactory("64","2000", "2.9gz");
        }
        return null;
    }
}
