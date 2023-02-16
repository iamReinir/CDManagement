package CDHouse.view;
/**
 *
 * @author NguyenXuanTrung QE170172
 */
public interface View {

    public Object add();

    public void show(Object x);

    public void alert(String msg);

    public boolean confirm(String msg);

    public String getString(String prompt);

    public String getInteger(String prompt);

    public String getDouble(String prompt);
}
