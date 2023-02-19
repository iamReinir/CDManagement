package CDHouse.model;

import java.io.Serializable;

/**
 *
 * @author NguyenXuanTrung QE170172
 */
public class CD implements Serializable {

    public String collectionName = "";
    public String type = "";
    public String title = "";
    public double price = 0.0;
    public String id = "";
    public String pubYear = "";

    public CD() {
    }

    public CD(String id,
            String title,
            String pubYear,
            String collectionName,
            String type,
            double price) {
        this.id = id;
        this.title = title;
        this.pubYear = pubYear;
        this.collectionName = collectionName;
        this.type = type;
        this.price = price;
    }

    public CD(String CD) {
        String[] tokens = CD.split(" - ");
        try {
            if (tokens.length != 6) {
                throw new RuntimeException();
            }
            this.id = tokens[0];
            this.title = tokens[1];
            this.pubYear = tokens[2];
            this.collectionName = tokens[3];
            this.type = tokens[4];
            this.price = Double.parseDouble(tokens[5]);
        } catch (Exception ex) {
            throw new RuntimeException("Invalid CD");
        }
    }

    //Use "~" as seperator
    @Override
    public String toString() {
        return id + " - "
                + title + " - "
                + pubYear + " - "
                + collectionName + " - "
                + type + " - "
                + price;
    }

}
