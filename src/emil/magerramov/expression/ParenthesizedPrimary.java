package emil.magerramov.expression;

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

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public String toString() {
        return "Parens(" + expression + ")";
    }
}
