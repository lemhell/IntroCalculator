package emil.magerramov;

import emil.magerramov.parser.Parser;

public class Main {

    public static void main(String[] args) {
        String exp = "   + )";
        Parser parser = new Parser(exp);
        try {
            System.out.println(parser.parse());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
