package emil.magerramov;

import emil.magerramov.expression.Expression;
import emil.magerramov.parser.Parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        BufferedReader br = null;
        System.out.println("Write \"exit\" to exit, write expression to get it's AST and result");
        try {
            while (true) {
                br = new BufferedReader(new InputStreamReader(System.in));
                try {
                    String exp = br.readLine();
                    if (exp.replace(" ", "").toLowerCase().equals("exit")) {
                        break;
                    } else {
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
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
