package emil.magerramov.expression;

import emil.magerramov.evaluation.Result;
import emil.magerramov.exception.EvaluationException;
import emil.magerramov.util.Evaluator;

import java.util.Objects;
import java.util.function.BiFunction;

/**
 * Created by lemhell on 02.09.16.
 */
public class Relation extends Expression {
    public enum OpCode {Less, LessEq, Greater, GreaterEq, Equal, NotEq, None}
    private OpCode code;
    private Expression left, right; // Term

    public Relation(Expression left) {
        this.code = OpCode.None;
        this.left = left;
        this.right = null;
    }

    public Relation(OpCode code, Expression left, Expression right) {
        this.code = code;
        this.left = left;
        this.right = right;
    }

    public String toString() {
        if (code != OpCode.None) {
            return "Relation(" + left + " " + codeToString(code) + " " + right + ")";
        } else {
            return "Relation(" + left + ")";
        }
    }

    public Result eval() throws EvaluationException {
        if (right == null) {
            throw new EvaluationException("Can not evaluate null");
        }
        switch (code) {
            case Less: return Evaluator.evaluateWithCheckFloatToBool(left, right, (a, b) -> a < b);
            case LessEq: return Evaluator.evaluateWithCheckFloatToBool(left, right, (a, b) -> a <= b);
            case Greater: return Evaluator.evaluateWithCheckFloatToBool(left, right, (a, b) -> a > b);
            case GreaterEq: return Evaluator.evaluateWithCheckFloatToBool(left, right, (a, b) -> a >= b);
            case Equal: {
                if (left.eval().getCode() == Result.ResultCode.Boolean) {
                    return Evaluator.evaluateWithCheckBoolToBool(left, right, (a, b) -> a == b);
                } else {
                    return Evaluator.evaluateWithCheckFloatToBool(left, right, Objects::equals);
                }
            }
            case NotEq: {
                if (left.eval().getCode() == Result.ResultCode.Boolean) {
                    return Evaluator.evaluateWithCheckBoolToBool(left, right, (a, b) -> a != b);
                } else {
                    return Evaluator.evaluateWithCheckFloatToBool(left, right, (a, b) -> !Objects.equals(a, b));
                }
            }
            case None: return left.eval();
            default:   return left.eval();
        }
    }

    private String codeToString(OpCode code) {
        switch (code) {
            case Less: return "<";
            case LessEq: return "<=";
            case Greater: return ">";
            case GreaterEq: return ">=";
            case Equal: return "==";
            case NotEq: return "!=";
            case None: return "None";
            default: return "None";
        }
    }
}
