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

    public Integer getInteger(String prompt);

    public Double getDouble(String prompt);
}
