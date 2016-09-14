package emil.magerramov.expression;

import emil.magerramov.evaluation.Result;
import emil.magerramov.exception.EvaluationException;
import emil.magerramov.util.Evaluator;
import emil.magerramov.util.Util;

/**
 * Created by lemhell on 02.09.16.
 */
public class Term extends Expression {
    public enum OpCode {Plus, Minus, None}
    private OpCode code;
    private Expression left, right; // Factor

    public Term(Expression left) {
        this.code = OpCode.None;
        this.left = left;
        this.right = null;
    }

    public Term(OpCode code, Expression left, Expression right) {
        this.code = code;
        this.left = left;
        this.right = right;
    }

    public String toString() {
        if (code != OpCode.None) {
            return "Term(" + left + " " + codeToString(code) + " " + right + ")";
        } else {
            return "Term(" + left + ")";
        }
    }

    public Result eval() throws EvaluationException {
        switch (code) {
            case Plus:  return Evaluator.evaluateWithCheckFloatToFloat(left, right, (a, b) -> a + b);
            case Minus: return Evaluator.evaluateWithCheckFloatToFloat(left, right, (a, b) -> a - b);
            case None:  return left.eval();
            default:    return left.eval();
        }
    }

    @Override
    public String serialize(int level) {
        String tab = Util.tab(level);
        return "{\n" +
                tab +  "\"type\": \"Term\",\n" +
                tab +  "\"code\": \"" + codeToString(code) + "\",\n" +
                tab +  "\"left\": " + left.serialize(level + 1) + "," +
               "\n" + tab +  "\"right\": " + right.serialize(level + 1) +
                "\n" + Util.tab(level - 1) +  "}";
    }

    private String codeToString(OpCode code) {
        switch (code) {
            case Plus: return "+";
            case Minus: return "-";
            case None: return "None";
            default: return "None";
        }
    }
}
