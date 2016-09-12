package emil.magerramov.expression;

import emil.magerramov.evaluation.Result;

/**
 * Created by lemhell on 02.09.16.
 */
public class IntegerPrimary extends Primary {
    private int intValue;

    public IntegerPrimary(int value) {
        this.intValue = value;
    }

    public String toString() {
        return "Integer(" + intValue + ")";
    }

    public Result eval() {
        return new Result(intValue);
    }
}
