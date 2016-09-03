package emil.magerramov.expression;

/**
 * Created by lemhell on 02.09.16.
 */
public class IntegerPrimary extends Primary {
    private int intValue;

    public IntegerPrimary(int value) {
        this.intValue = value;
    }

    public long getIntValue() {
        return intValue;
    }

    public void setValue(int value) {
        this.intValue = value;
    }

    public String toString() {
        return "Integer(" + intValue + ")";
    }
}