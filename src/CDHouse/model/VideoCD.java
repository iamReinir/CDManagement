package CDHouse.model;

/**
 *
 * @author NguyenXuanTrung
 */
public class VideoCD extends CD {

    public VideoCD(String collectionName, String title, double price, String id) {
        super(collectionName, title, price, id);
    }

    public VideoCD() {
    }

    @Override
    public String toString() {
        return super.toString() + "~" + "video";
    }

    @Override
    public void play() {
        System.out.println("Playing video...");
    }

    @Override
    public String getType() {
        return "video";
    }


}
