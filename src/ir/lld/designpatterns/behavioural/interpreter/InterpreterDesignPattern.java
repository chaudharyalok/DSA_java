package ir.lld.designpatterns.behavioural.interpreter;

import sun.reflect.annotation.AnnotationSupport;

public class InterpreterDesignPattern {
    public static void main(String[] args) {
        Context context = new Context();
        context.put("a",2);
        context.put("b",4);
        context.put("c",6);
        context.put("d",8);


        // a*b
        AbstractExpression expression = new MultiplyNonTerminalExpression(
                new NumberTerminalExpression("a"), new NumberTerminalExpression("b"));

        System.out.println(expression.interpret(context));

        // ((a*b) + (c*d))
        AbstractExpression expression1 = new SumNonTerminalExpression(new MultiplyNonTerminalExpression(
                new NumberTerminalExpression("a"), new NumberTerminalExpression("b")),
                new MultiplyNonTerminalExpression(new NumberTerminalExpression("c"), new NumberTerminalExpression("d")));

        System.out.println(expression1.interpret(context));
    }
}
