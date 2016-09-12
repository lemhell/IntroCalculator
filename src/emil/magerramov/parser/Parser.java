package emil.magerramov.parser;

import emil.magerramov.exception.ParseException;
import emil.magerramov.expression.*;
import emil.magerramov.expression.IntegerPrimary;

/**
 * Created by lemhell on 03.09.16.
 */
public class Parser {
    private String str;
    private int pos = -1;
    private int ch;

    public Parser(String str) {
        // TODO: Probably, should add Tokenizer and accept List<Token> here
        this.str = str;
    }

    public Expression parse() throws Exception {
        return parseExpression();
    }

    private Expression parseExpression() throws Exception {
        return new Expression(parseLogical());
    }

    private Expression parseLogical() throws Exception {
        Expression relation = parseRelation();
        Logical.OpCode code = Logical.OpCode.None;
        if (searchFor("and")) code = Logical.OpCode.And;
        else if (searchFor("or")) code = Logical.OpCode.Or;
        else if (searchFor("xor")) code = Logical.OpCode.Xor;
        if (code == Logical.OpCode.None) {
            return relation;
        } else {
            return new Logical(code, relation, parseLogical());
        }
    }

    private Expression parseRelation() throws Exception {
        // TODO: Should do smth with more than one consecutive relation
        // (should be an error)
        Expression term = parseTerm();
        Relation.OpCode code = Relation.OpCode.None;
        if (searchFor("<")) code = Relation.OpCode.Less;
        else if (searchFor("<=")) code = Relation.OpCode.LessEq;
        else if (searchFor(">")) code = Relation.OpCode.Greater;
        else if (searchFor(">=")) code = Relation.OpCode.GreaterEq;
        else if (searchFor("==")) code = Relation.OpCode.Equal;
        else if (searchFor("!=")) code = Relation.OpCode.NotEq;
        if (code == Relation.OpCode.None) {
            return term;
        } else {
            return new Relation(code, term, parseTerm());
        }
    }

    private Expression parseTerm() throws Exception {
        Expression factor = parseFactor();
        Term.OpCode code = Term.OpCode.None;
        if (searchFor("+")) code = Term.OpCode.Plus;
        else if (searchFor("-")) code = Term.OpCode.Minus;
        if (code == Term.OpCode.None) {
            return factor;
        } else {
            return new Term(code, factor, parseTerm());
        }
    }

    private Expression parseFactor() throws Exception {
        Expression primary = parsePrimary();
        Factor.OpCode code = Factor.OpCode.None;
        if (searchFor("*")) code = Factor.OpCode.Multiply;
        else if (searchFor("/")) code = Factor.OpCode.Divide;
        if (code == Factor.OpCode.None) {
            return primary;
        } else {
            return new Factor(code, primary, parseFactor());
        }
    }

    private Expression parsePrimary() throws Exception {
        if (searchFor(")")) {
            throw new ParseException("Extra closing bracket!");
        }
        if (searchFor("(")) {
            int startPos = pos;
            int endPos = -1;
            while (pos < str.length()) {
                if (str.charAt(pos) == ')') {
                    endPos = pos;
                    break;
                }
                pos++;
            }
            if (endPos == -1) {
                throw new ParseException("No closing bracket!");
            } else {
                pos = startPos;
                Expression expr = new ParenthesizedPrimary(parseExpression());
                nextChar();
                return expr;
            }
        } else {
            ch = str.charAt(pos);
            while (ch == ' ') nextChar();
            int startPos = pos;
            while (ch >= '0' && ch <= '9') {
                nextChar();
            }
            if (startPos == pos) {
                throw new ParseException("Could not parse Primary token");
            }
            return new IntegerPrimary(Integer.parseInt(str.substring(startPos, pos)));
        }
    }

    private void nextChar() {
        pos++;
        if (pos >= str.length()) ch = -1;
        else ch = str.charAt(pos);
    }

    private boolean searchFor(String c) {
        if (pos == -1) pos = 0;
        if (pos >= str.length()) return false;
        ch = str.charAt(pos);
        while (ch == ' ') nextChar();
        try {
            if (str.substring(pos, pos + c.length()).equals(c)) {
                for (int i = 0; i < c.length(); i++) nextChar();
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}


