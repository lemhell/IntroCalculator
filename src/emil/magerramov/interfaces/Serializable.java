package emil.magerramov.interfaces;

/**
 * Created by lemhell on 13.09.16.
 */
public interface Serializable {
    default String serialize() {
        return serialize(1);
    }

    String serialize(int level);
}
