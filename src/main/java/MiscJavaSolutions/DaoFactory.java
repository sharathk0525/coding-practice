package MiscJavaSolutions;


public class DaoFactory {
    public static Dao getInstance() {
        return new DaoImpl();
    }


}
