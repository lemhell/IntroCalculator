package emil.magerramov.expression;

import emil.magerramov.evaluation.Result;
import emil.magerramov.exception.EvaluationException;
import emil.magerramov.util.Evaluator;

/**
 * Created by lemhell on 02.09.16.
 */
public class Factor extends Expression {
    public enum OpCode {Multiply, Divide, None}
    private OpCode code;
    private Expression left, right; // Primary

    public Factor(Expression left) {
        this.code = OpCode.None;
        this.left = left;
        this.right = null;
    }

    public Factor(OpCode code, Expression left, Expression right) {
        this.code = code;
        this.left = left;
        this.right = right;
    }

    public String toString() {
        if (code != OpCode.None) {
            return "Factor(" + left + " " + codeToString(code) + " " + right + ")";
        } else {
            return "Factor(" + left + ")";
        }
    }

    public Result eval() throws EvaluationException {
        switch (code) {
            case Multiply:  return Evaluator.evaluateWithCheckFloatToFloat(left, right, (a, b) -> a * b);
            case Divide:    return Evaluator.evaluateWithCheckFloatToFloat(left, right, (a, b) -> a / b);
            case None:      return left.eval();
            default:        return left.eval();
        }
    }

    private String codeToString(OpCode code) {
        switch (code) {
            case Multiply: return "*";
            case Divide: return "/";
            case None: return "None";
            default: return "None";
        }
    }
}
