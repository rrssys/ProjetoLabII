package crudpassagemaeria.dao.impl_BD;
/**
 *
 * @author rrsantos
 */
public class BDException extends RuntimeException {

    public BDException(String s) {
        super(s);
    }

    public BDException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public BDException(Throwable throwable) {
        super(throwable);
    }
}
