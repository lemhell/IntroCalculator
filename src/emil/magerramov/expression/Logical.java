package emil.magerramov.expression;

/**
 * Created by lemhell on 02.09.16.
 */
public class Logical extends Expression {
    public enum OpCode {And, Or, Xor, None}
    private OpCode code;
    private Expression left, right; // Relation

    public Logical(Expression left) {
        this.code = OpCode.None;
        this.left = left;
        this.right = null;
    }

    public Logical(OpCode code, Expression left, Expression right) {
        this.code = code;
        this.left = left;
        this.right = right;
    }

    public String toString() {
        if (code != OpCode.None) {
            return "Logical(" + left + " " + codeToString(code) + " " + right + ")";
        } else {
            return "Logical(" + left + ")";
        }
    }

    private String codeToString(OpCode code) {
        switch (code) {
            case And: return "and";
            case Or: return "or";
            case Xor: return "xor";
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

    public void setLeft(Factor left) {
        this.left = left;
    }

    public Expression getRight() {
        return right;
    }

    public void setRight(Factor right) {
        this.right = right;
    }
}
