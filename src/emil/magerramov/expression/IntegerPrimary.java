package emil.magerramov.expression;

import emil.magerramov.evaluation.Result;
import emil.magerramov.util.Util;

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

    @Override
    public String serialize(int level) {
        String tab = Util.tab(level);
        return "{\n" +
                tab +  "\"type\": \"Integer\",\n" +
                tab +  "\"value\": " + intValue +
               "\n" + Util.tab(level - 1) +  "}";
    }
}
