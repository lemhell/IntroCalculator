package emil.magerramov.expression;

/**
 * Created by lemhell on 02.09.16.
 */
public class Relation extends Expression {
    public enum OpCode {Less, LessEq, Greater, GreaterEq, Equal, NotEq, None}
    private OpCode code;
    private Expression left, right; // Term

    public Relation(Expression left) {
        this.code = OpCode.None;
        this.left = left;
        this.right = null;
    }

    public Relation(OpCode code, Expression left, Expression right) {
        this.code = code;
        this.left = left;
        this.right = right;
    }

    public String toString() {
        if (code != OpCode.None) {
            return "Relation(" + left + " " + codeToString(code) + " " + right + ")";
        } else {
            return "Relation(" + left + ")";
        }
    }

    private String codeToString(OpCode code) {
        switch (code) {
            case Less: return "<";
            case LessEq: return "<=";
            case Greater: return ">";
            case GreaterEq: return ">=";
            case Equal: return "==";
            case NotEq: return "!=";
            case None: return "None";
            default: return "None";
        }
    }
}
