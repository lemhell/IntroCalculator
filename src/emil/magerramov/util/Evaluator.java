package emil.magerramov.util;

import emil.magerramov.evaluation.Result;
import emil.magerramov.exception.EvaluationException;
import emil.magerramov.expression.Expression;

import java.util.function.BiFunction;

/**
 * Created by lemhell on 12.09.16.
 */
public class Evaluator {
    public static Result evaluateWithCheckFloatToFloat(Expression left, Expression right, BiFunction<Float, Float, Float> f)
            throws EvaluationException {
        Result leftResult = left.eval();
        checkNull(right);
        Result rightResult = right.eval();
        if (leftResult.getCode() != Result.ResultCode.Float
                || rightResult.getCode() != Result.ResultCode.Float) {
            throw new EvaluationException("Wrong operand types: " + left.eval().getCode() + ", " + right.eval().getCode());
        }
        return new Result(f.apply(left.eval().getFloatResult(), right.eval().getFloatResult()));
    }

    public static Result evaluateWithCheckBoolToBool(Expression left, Expression right, BiFunction<Boolean, Boolean, Boolean> f)
            throws EvaluationException {
        Result leftResult = left.eval();
        checkNull(right);
        Result rightResult = right.eval();
        if (leftResult.getCode() != Result.ResultCode.Boolean
                || rightResult.getCode() != Result.ResultCode.Boolean) {
            throw new EvaluationException("Wrong operand types: " + left.eval().getCode() + ", " + right.eval().getCode());
        }
        return new Result(f.apply(left.eval().getBoolResult(), right.eval().getBoolResult()));
    }

    public static Result evaluateWithCheckFloatToBool(Expression left, Expression right, BiFunction<Float, Float, Boolean> f)
            throws EvaluationException {
        Result leftResult = left.eval();
        checkNull(right);
        Result rightResult = right.eval();
        if (leftResult.getCode() != Result.ResultCode.Float
                || rightResult.getCode() != Result.ResultCode.Float) {
            throw new EvaluationException("Wrong operand types: " + left.eval().getCode() + ", " + right.eval().getCode());
        }
        return new Result(f.apply(left.eval().getFloatResult(), right.eval().getFloatResult()));
    }

    private static void checkNull(Expression exp) throws EvaluationException {
        if (exp == null) {
            throw new EvaluationException("Can not evaluate null");
        }
    }
}
