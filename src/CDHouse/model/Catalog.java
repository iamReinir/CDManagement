package CDHouse.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.function.Predicate;

/**
 *
 * @author NguyenXuanTrung QE170172
 */
public final class Catalog extends DynamicArray<CD> implements Serializable {
    public Catalog(int capacity) {
        super(capacity);
    }

    public Catalog() {
        super(10);
    }

    public boolean saveToFile(String filename) {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filename));
            os.writeObject(this);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public boolean takeFromFile(String filename) {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(filename));
            Catalog x = (Catalog) is.readObject();
            return this.shallowCopy(x);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean idExisted(String id) {
        for (int i = 0; i < this.size(); ++i) {
            if (this.get(i).id.toLowerCase().equals(id.toLowerCase())) {
                return true;
            }
        }
        return false;

    }

    public Catalog search(Predicate<CD> x) {
        Catalog res = new Catalog();

        for (int i = 0; i < this.size(); ++i) {
            if (x.test(this.get(i))) {
                res.add(this.get(i));
            }
        }
        return res;
    }

    @Override
    public String toString() {
        String s = "CD list:\n";
        for (int i = 0; i < this.size(); ++i) {
            s += this.get(i) + "\n";
        }
        return s;
    }

}
