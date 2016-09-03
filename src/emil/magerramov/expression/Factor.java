package emil.magerramov.expression;

/**
 * Created by lemhell on 02.09.16.
 */
public class Factor extends Expression {
    public enum OpCode {Multiply, Divide, None}
    private OpCode code;
    private Expression left, right; // Primary

    public Factor(Expression left) {
        this.code = OpCode.None;
        this.left = left;
        this.right = null;
    }

    public Factor(OpCode code, Expression left, Expression right) {
        this.code = code;
        this.left = left;
        this.right = right;
    }

    public String toString() {
        if (code != OpCode.None) {
            return "Factor(" + left + " " + codeToString(code) + " " + right + ")";
        } else {
            return "Factor(" + left + ")";
        }
    }

    private String codeToString(OpCode code) {
        switch (code) {
            case Multiply: return "*";
            case Divide: return "/";
            case None: return "None";
            default: return "None";
        }
    }

    public OpCode getCode() {
        return code;
    }

    public void setCode(OpCode code) {
        this.code = code;
    }

    public Expression getLeft() {
        return left;
    }

    public void setLeft(Primary left) {
        this.left = left;
    }

    public Expression getRight() {
        return right;
    }

    public void setRight(Primary right) {
        this.right = right;
    }
}
