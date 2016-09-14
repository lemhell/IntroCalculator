package emil.magerramov.expression;

import emil.magerramov.evaluation.Result;
import emil.magerramov.exception.EvaluationException;
import emil.magerramov.util.Util;

/**
 * Created by lemhell on 02.09.16.
 */
public class ParenthesizedPrimary extends Primary {
    private Expression expression;

    public ParenthesizedPrimary(Expression expression) {
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    public Result eval() throws EvaluationException {
        return expression.eval();
    }

    public String toString() {
        return "Parens(" + expression + ")";
    }

    @Override
    public String serialize(int level) {
        String tab = Util.tab(level);
        return "{\n" +
               tab +  "\"type\": \"Parens\",\n" +
               tab +  "\"value\": " + expression.serialize(level + 1) +
                "\n" + Util.tab(level - 1) +  "}";
    }
}
