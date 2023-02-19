package CDHouse.model;

import java.io.Serializable;

/**
 *
 * @author NguyenXuanTrung QE170172
 */
public abstract class CD implements Serializable {
    private String collectionName = "";
    private String title = "";
    private double price = 0.0;
    private String id = "";

    public CD() {
    }


    // "\" before "~" and "\"
    static private String stuffing(String basic) {
        String result = "";
        for (int i = 0; i < basic.length(); ++i) {
            if (basic.charAt(i) == '~' || basic.charAt(i) == '\\') {
                result += '\\';
            }
            result += basic.charAt(i);
        }
        return result;
    }

    static private String destuffing(String basic) {
        String result = "";
        for (int i = 0; i < basic.length(); ++i) {
            if (basic.charAt(i) == '\\') {

                if (i + 1 > basic.length()
                        || basic.charAt(i + 1) != '~' && basic.charAt(i + 1) != '\\') {
                    throw new RuntimeException("Invalid stuffed string");
                }
                continue;
            }
            result += basic.charAt(i);
        }
        return result;
    }

    public final String getCollectionName() {
        return destuffing(collectionName);
    }
    public final void setCollectionName(String collectionName) {
        this.collectionName = stuffing(collectionName);
    }

    public final String getTitle() {
        return destuffing(title);
    }

    public final void setTitle(String title) {
        this.title = stuffing(title);
    }

    public final double getPrice() {
        return price;
    }

    public final void setPrice(double price) {
        this.price = price;
    }

    public final String getId() {
        return destuffing(id);
    }

    public final void setId(String id) {
        this.id = stuffing(id);
    }

    public CD(String collectionName, String title, double price, String id) {
        setCollectionName(collectionName);
        setTitle(title);
        setPrice(price);
        setId(id);
    }

    //Use "~" as seperator
    @Override
    public String toString() {
        return collectionName + "~" + title + "~" + price + "~" + id;
    }
    public abstract void play();

    public abstract String getType();
}
