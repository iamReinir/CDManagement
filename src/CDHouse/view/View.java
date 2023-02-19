package CDHouse.view;
/**
 *
 * @author NguyenXuanTrung QE170172
 */
public interface View {

    public void show(Object x);

    public void alert(String msg);

    public boolean confirm(String msg);

    public String getString(String prompt);

    public int getInteger(String prompt);

    public double getDouble(String prompt);
}
