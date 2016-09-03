package emil.magerramov.expression;

/**
 * Created by lemhell on 02.09.16.
 */
public class Term extends Expression {
    public enum OpCode {Plus, Minus, None}
    private OpCode code;
    private Expression left, right; // Factor

    public Term(Expression left) {
        this.code = OpCode.None;
        this.left = left;
        this.right = null;
    }

    public Term(OpCode code, Expression left, Expression right) {
        this.code = code;
        this.left = left;
        this.right = right;
    }

    public String toString() {
        if (code != OpCode.None) {
            return "Term(" + left + " " + codeToString(code) + " " + right + ")";
        } else {
            return "Term(" + left + ")";
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

    public void setLeft(Factor left) {
        this.left = left;
    }

    public Expression getRight() {
        return right;
    }

    public void setRight(Factor right) {
        this.right = right;
    }

    private String codeToString(OpCode code) {
        switch (code) {
            case Plus: return "+";
            case Minus: return "-";
            case None: return "None";
            default: return "None";
        }
    }
}
