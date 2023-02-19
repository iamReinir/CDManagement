package CDHouse.view;

import CDHouse.control.Controller;
import CDHouse.model.CD;
import java.util.Scanner;

/**
 *
 * @author NguyenXuanTrung
 */
public class Terminal implements View {

    Scanner sc = new Scanner(System.in);

    public CD add(String id) {

        String title = getString("Title");
        if (title.equals("")) {
            return null;
        }
        String pubYear;
        while (true) {
            pubYear = getString("Publish year:");
            if (pubYear.equals("")) {
            return null;
            }
            if (pubYear.matches("[0-9]+") == false) {
                alert("Please only enter year number!");
                continue;
            }
            break;
        }
        String collectionName = multipleChoice("Collection name", Controller.collections);
        if (collectionName == null) {
            return null;
        }
        Double price;
        while (true) {
            price = getDouble("CD price");
            if (price == null) {
                return null;
            }
            if (price <= 0) {
                alert("Please enter a positive number!");
                continue;
            }
            break;
        }
        String type = multipleChoice("CD type", Controller.types);
        if (type == null) {
            return null;
        }
        return new CD(id, title, pubYear, collectionName, type, price);
    }

    public void update(CD tar) {
        show(tar);
        alert("Updating this CD. Leave field blank if you don't want to change infomation.");
        pause();
        String title = getString("Title");
        if (title.equals("")) {
            title = tar.title;
        }
        String pubYear;
        while (true) {
            pubYear = getString("Publish year:");
            if (pubYear.equals("")) {
                pubYear = tar.pubYear;
            }
            if (pubYear.matches("[0-9]+") == false) {
                alert("Please only enter year number!");
                continue;
            }
            break;
        }
        String collectionName = multipleChoice("Collection name", Controller.collections);
        if (collectionName == null) {
            collectionName = tar.collectionName;
        }
        Double price;
        while (true) {
            price = getDouble("CD price");
            if (price == null) {
                price = tar.price;
            }
            if (price <= 0) {
                alert("Please enter a positive number!");
                continue;
            }
            break;
        }
        String type = multipleChoice("CD type", Controller.types);
        if (type == null) {
            type = tar.type;
        }
        tar.collectionName = collectionName;
        tar.price = price;
        tar.pubYear = pubYear;
        tar.title = title;
        tar.type = type;
        show(tar);
        alert("Update sucess");
    }

    public static String showMenu(String[] menu) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu:");
        for (int i = 1; i <= menu.length; ++i) {
            System.out.println(i + "." + menu[i - 1]);
        }
        System.out.println("Your choice..");
        int choice;
        try {
            choice = Integer.parseInt(sc.nextLine());
            return menu[choice - 1];
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void show(Object x) {
        System.out.println(String.valueOf(x));
    }

    public void show(CD x) {
        System.out.println("CD " + x.id + ":");
        System.out.println("Title : " + x.title);
        System.out.println("Publish year : " + x.pubYear);
        System.out.println("Collection name : " + x.collectionName);
        System.out.println("CD type : " + x.type);
        System.out.println("Price : " + x.price);
    }

    @Override
    public void alert(String msg) {
        System.out.println(msg);
    }

    @Override
    public boolean confirm(String msg) {
        String res = getString(msg + "(enter Y to confirm)");
        return (res.equals("Y") || res.equals("y"));
    }

    @Override
    public String getString(String prompt) {
        System.out.print(prompt + ":");
        return sc.nextLine();
    }

    public String multipleChoice(String prompt, String[] choices) {
        show(prompt);
        for (int i = 0; i < choices.length; ++i) {
            System.out.println((i + 1) + "." + choices[i]);
        }
        Integer choose = getInteger("Choose [1.." + choices.length + "]");
        if (choose == null) {
            return null;
        }
        if (choose - 1 < 0 || choose - 1 >= choices.length) {
            return null;
        }
        return choices[choose - 1];
    }

    @Override
    public Integer getInteger(String prompt) {
        while (true)
        try {
            String res = getString(prompt);
            if (res.equals("")) {
                return null;
            }
            Integer result = Integer.parseInt(res);
            return result;
        } catch (NumberFormatException ex) {
            if (true) {
                show("Please enter an Integer");
            }
        }
    }

    @Override
    public Double getDouble(String prompt) {
        while (true)
        try {
            String res = getString(prompt);
            if (res.equals("")) {
                return null;
            }
            Double result = Double.parseDouble(res);
            return result;
        } catch (NumberFormatException ex) {
            if (true) {
                show("Please enter a number!");
            }
        }
    }

    public void pause() {
        alert("Press ENTER to continues...");
        sc.nextLine();
    }
}
