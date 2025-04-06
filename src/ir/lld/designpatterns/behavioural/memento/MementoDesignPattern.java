package ir.lld.designpatterns.behavioural.memento;

public class MementoDesignPattern {
    public static void main(String[] args) {
        ConfigurationCaretaker caretakerObject = new ConfigurationCaretaker();
        // initiate state of the originator
        ConfigurationOriginator configurationOriginator = new ConfigurationOriginator(5,10);

        // save it
        ConfigurationMemento snapshot1 = configurationOriginator.createMemento();
        caretakerObject.addMemento(snapshot1);

        // originator changing to new state
        configurationOriginator.setHeight(10);
        configurationOriginator.setWidth(20);

        ConfigurationMemento snapshot2 = configurationOriginator.createMemento();
        caretakerObject.addMemento(snapshot2);

        // originator changing to new state
        configurationOriginator.setHeight(15);
        configurationOriginator.setWidth(25);


    //    ConfigurationMemento snapshot3 = configurationOriginator.createMemento();
    //    caretakerObject.addMemento(snapshot3);
        System.out.println("height: " + configurationOriginator.height + " width: " + configurationOriginator.width);

        // UNDO
        ConfigurationMemento restoredConfiguration = caretakerObject.undo();
        configurationOriginator.restoreMemento(restoredConfiguration);

        System.out.println("height: " + configurationOriginator.height + " width: " + configurationOriginator.width);


    }
}
