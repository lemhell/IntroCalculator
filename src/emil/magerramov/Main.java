package emil.magerramov;

import emil.magerramov.evaluation.Result;
import emil.magerramov.expression.Expression;
import emil.magerramov.parser.Parser;

public class Main {

    public static void main(String[] args) {
        String exp = "(1 / 1) + 2 * 3";
        Parser parser = new Parser(exp);
        Expression expr;
        try {
            expr = parser.parse();
            System.out.println(expr);
            System.out.println("Result is: " + expr.eval());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
