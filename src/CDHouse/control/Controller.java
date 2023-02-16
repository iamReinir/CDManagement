package CDHouse.control;
import CDHouse.view.Terminal;

/**
 *
 * @author NguyenXuanTrung QE170172
 */
public class Controller {
    Terminal terminal;

    public Controller() {
        this.terminal = new Terminal();
    }

    private String[] menu = {
        "Add a CD",
        "Search by title",
        "Display catalog",
        "Update CD",
        "Save to file",
        "Print from file"
    };

    public void run() {
        String choice = Terminal.showMenu(menu);
        terminal.add();
    }
}
