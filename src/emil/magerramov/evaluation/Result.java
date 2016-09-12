package emil.magerramov.evaluation;

/**
 * Created by lemhell on 12.09.16.
 */
public class Result {
    public enum ResultCode {Float, Boolean, None}
    private float floatResult;
    private boolean boolResult;
    private ResultCode code;

    public Result(float floatResult) {
        this.floatResult = floatResult;
        this.code = ResultCode.Float;
    }

    public Result(boolean boolResult) {
        this.boolResult = boolResult;
        this.code = ResultCode.Boolean;
    }

    public float getFloatResult() {
        return floatResult;
    }

    public boolean getBoolResult() {
        return boolResult;
    }

    public ResultCode getCode() {
        return code;
    }

    public String toString() {
        if (code == ResultCode.Boolean) {
            return String.valueOf(this.getBoolResult());
        } else {
            return String.valueOf(this.getFloatResult());
        }
    }
}
