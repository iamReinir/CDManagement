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

    public void save() {
        if (!cdList.saveToFile(filename)) {
            terminal.alert("Save failed");
        }
    }

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
                update_menu();
            } else if (choice.equals(menu[4])) {
                save();
                terminal.pause();
            } else if (choice.equals(menu[5])) {
                cdList.sort((x, y) -> {
                    return x.title.toLowerCase().compareTo(y.title.toLowerCase());
                });
                terminal.show(cdList);
                terminal.pause();
            }
        }
        save();
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
                break;
            }
            if (cdList.add(tar)) {
                terminal.show(tar);
                terminal.alert("CD added successfully!");
            } else {
                terminal.alert("Add failed!");
            }
            break;
        }
        save();
        terminal.pause();
    }

    private void search_byTitle() {
        String tar = terminal.getString("Search");
        terminal.show(cdList.search(cd -> {
            return cd.title.toLowerCase().contains(tar.toLowerCase());
        }));
        terminal.pause();
    }

    static final String[] updateMenu = {
        "Update",
        "Delete"
    };

    private void update_menu() {
        String choice = terminal.multipleChoice("Update", updateMenu);
        if (choice == null) {
            terminal.alert("Cancelled!");
            return;
        }
        if (choice.equals(updateMenu[0])) {
            update();
        }
        if (choice.equals(updateMenu[1])) {
            delete();
        }
        save();

    }

    private void delete() {
        while (true) {
            String id = terminal.getString("ID to delete");
            if (id.equals("")) {
                terminal.alert("Cancelled!");
                break;
            }
            Catalog res = cdList.search(x -> {
                return x.id.toLowerCase().equals(id.toLowerCase());
            });
            if (res.size() <= 0) {
                terminal.alert("ID not found");
                continue;
            }
            terminal.show(res.get(0));
            if (terminal.confirm("Delete this CD?")) {
                if (cdList.remove(res.get(0))) {
                    terminal.alert("Delete sucessfully!");
                } else {
                    terminal.alert("Delete failed!");
                }
            } else {
                terminal.alert("Cancelled!");
            }
            break;
        }
        terminal.pause();
    }

    private void update() {
        while (true) {
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
                continue;
            } else {
                terminal.update(res.get(0));
            }
            break;
        }

        terminal.pause();
    }

    private void show() {
        terminal.show(cdList);
        terminal.pause();
    }
}
