package emil.magerramov.expression;

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

    public void setValue(Logical value) {
        this.value = value;
    }

    public String toString() {
        return value.toString();
    }
}
