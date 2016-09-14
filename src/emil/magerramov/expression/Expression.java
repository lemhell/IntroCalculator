package emil.magerramov.expression;

import emil.magerramov.evaluation.Result;
import emil.magerramov.exception.EvaluationException;
import emil.magerramov.interfaces.Serializable;


/**
 * Created by lemhell on 02.09.16.
 */
public class Expression implements Serializable {
    private Expression value; // Logical

    public Expression(Expression value) {
        this.value = value;
    }

    public Expression() {
    }

    public String toString() {
        return value.toString();
    }

    public Result eval() throws EvaluationException {
        return value.eval();
    }

    @Override
    public String serialize(int level) {
        return value.serialize(level);
    }
}
