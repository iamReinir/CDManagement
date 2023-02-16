package CDHouse.model;

/**
 *
 * @author NguyenXuanTrung QE170172
 */
public class AudioCD extends CD {

    public AudioCD(String collectionName, String title, double price, String id) {
        super(collectionName, title, price, id);
    }

    public AudioCD() {
    }

    @Override
    public String toString() {
        return super.toString() + "~" + "audio";
    }

    @Override
    public void play() {
        System.out.println("Playing audio...");
    }

    @Override
    public String getType() {
        return "audio";
    }


}
