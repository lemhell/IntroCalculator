package emil.magerramov.expression;

import emil.magerramov.evaluation.Result;
import emil.magerramov.exception.EvaluationException;
import emil.magerramov.util.Evaluator;
import emil.magerramov.util.Util;

/**
 * Created by lemhell on 02.09.16.
 */
public class Logical extends Expression {
    public enum OpCode {And, Or, Xor, None}
    private OpCode code;
    private Expression left, right; // Relation

    public Logical(Expression left) {
        this.code = OpCode.None;
        this.left = left;
        this.right = null;
    }

    public Logical(OpCode code, Expression left, Expression right) {
        this.code = code;
        this.left = left;
        this.right = right;
    }

    public String toString() {
        if (code != OpCode.None) {
            return "Logical(" + left + " " + codeToString(code) + " " + right + ")";
        } else {
            return "Logical(" + left + ")";
        }
    }

    public Result eval() throws EvaluationException {
        switch (code) {
            case And: return Evaluator.evaluateWithCheckBoolToBool(left, right, (a, b) -> a && b);
            case Or:  return Evaluator.evaluateWithCheckBoolToBool(left, right, (a, b) -> a || b);
            case Xor: return Evaluator.evaluateWithCheckBoolToBool(left, right, (a, b) -> a  ^ b);
            case None:return left.eval();
            default:  return left.eval();
        }
    }

    @Override
    public String serialize(int level) {
        String tab = Util.tab(level);
        return "{\n" +
               tab +  "\"type\": \"Logical\",\n" +
               tab +  "\"code\": \"" + codeToString(code) + "\",\n" +
               tab +  "\"left\": " + left.serialize(level + 1) + ",\n" +
               tab +  "\"right\": " + right.serialize(level + 1) +
               "\n" + Util.tab(level - 1) +  "}";
    }

    private String codeToString(OpCode code) {
        switch (code) {
            case And: return "and";
            case Or: return "or";
            case Xor: return "xor";
            case None: return "None";
            default: return "None";
        }
    }
}
