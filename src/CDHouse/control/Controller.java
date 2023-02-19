package CDHouse.control;

import CDHouse.model.*;
import CDHouse.view.Terminal;

/**
 *
 * @author NguyenXuanTrung QE170172
 */
public class Controller {

    Terminal terminal;
    Catalog cdList;
    private final String filename = "CD.dat";

    public Controller() {
        this.terminal = new Terminal();
        cdList = new Catalog();
        if (cdList.takeFromFile(filename)) {
            terminal.alert("Data retrieved from " + filename);
        } else {
            terminal.alert("Cannot retrieved data from " + filename + ". New file created.");
        }
    }

    private String[] menu = {
        "Add a CD",
        "Search by title",
        "Display catalog",
        "Update CD",
        "Save to file",
        "Print from file"
    };

    public static final String[] collections
            = {
                "game",
                "movie",
                "music"
            };

    public static final String[] types
            = {
                "audio",
                "video"
            };

    public void run() {
        while (true) {
            String choice = Terminal.showMenu(menu);
            if (choice == null) {
                break;
            }
            if (choice.equals(menu[0])) {
                add();
            } else if (choice.equals(menu[1])) {
                search_byTitle();
            } else if (choice.equals(menu[2])) {
                show();
            } else if (choice.equals(menu[3])) {
                update();
            } else if (choice.equals(menu[4])) {
                cdList.saveToFile(filename);
                terminal.alert("Save success");
            } else if (choice.equals(menu[5])) {
                terminal.show(cdList);
            }
        }
        if (!cdList.saveToFile(filename)) {
            terminal.alert("Save failed");
        }
        terminal.alert("have a nice day!");
    }

    private void add() {
        String id;
        while (true) {
            id = terminal.getString("New id");
            if (cdList.idExisted(id)) {
                terminal.alert("The CD with this id already existed in the catalog!");
                continue;
            }
            CD tar = terminal.add(id);
            if (tar == null) {
                terminal.alert("Cancelled");
                return;
            }
            if (cdList.add(tar)) {
                terminal.show(tar);
                terminal.alert("CD added successfully!");
            } else {
                terminal.alert("Add failed!");
            }
            break;
        }
    }

    private void search_byTitle() {
        String tar = terminal.getString("Search");
        terminal.show(cdList.search(cd -> {
            return cd.title.toLowerCase().contains(tar.toLowerCase());
        }));
    }

    private void update() {
        String tar = terminal.getString("ID");
        if (tar.equals("")) {
            terminal.alert("Cancelled");
            return;
        }

        Catalog res = cdList.search(cd -> {
            return cd.id.toLowerCase().equals(tar.toLowerCase());
        });
        if (res.size() == 0) {
            terminal.alert("No CD found");
        } else {
            terminal.update(res.get(0));
            terminal.alert("Update sucess");
        }

    }

    private void show() {
        terminal.show(cdList);
    }
}
