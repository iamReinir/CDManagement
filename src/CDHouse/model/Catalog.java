package CDHouse.model;

/**
 *
 * @author NguyenXuanTrung
 */
public class Catalog {
    private CD[] cdList;
    private int size;
    private int maxSize = 10;

    public Catalog() {
        cdList = new CD[maxSize];
        size = 0;
    }

    private boolean bigger() {
        CD[] cdListn = new CD[maxSize * 2];
        maxSize = maxSize * 2;
        for (int i = 0; i < size; ++i) {
            cdListn[i] = cdList[i];
        }
        cdList = cdListn;
        return true;
    }

    public boolean add(CD n) {
        if (size + 1 >= maxSize && bigger() == false) {

        }
    }

}
