package ir.lld.designpatterns.behavioural.chainofresponsibility;

public class ChainOfResponsibilityPattern {
    public static void main(String arr[]){

        LogProcessor logObject = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));

        logObject.log(LogProcessor.ERROR, "exception happens");
        logObject.log(LogProcessor.DEBUG, "need to debug");
        logObject.log(LogProcessor.INFO, "just for info");


    }
}
