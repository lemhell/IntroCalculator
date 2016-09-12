package emil.magerramov.expression;

import emil.magerramov.evaluation.Result;
import emil.magerramov.exception.EvaluationException;

/**
 * Created by lemhell on 02.09.16.
 */
public class Expression {
    private Expression value; // Logical

    public Expression(Expression value) {
        this.value = value;
    }

    public Expression() {
    }

    public Expression getValue() {
        return value;
    }

    public String toString() {
        return value.toString();
    }

    public Result eval() throws EvaluationException {
        return value.eval();
    }
}
