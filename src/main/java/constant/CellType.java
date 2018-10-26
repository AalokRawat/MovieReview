package constant;

/**
 * Created by aalokr on 4/7/18.
 */
public enum CellType {
    S ("simple"),
    WS ("word dobule"),
    LS ("letter double"),
    St ("start");

    private final String type;

    private CellType(String type) {
        this.type = type;
    }

/*    @Override
    public String toString() {
        return this.type;
    }*/
}
