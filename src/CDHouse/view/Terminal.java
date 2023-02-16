package CDHouse.view;

import CDHouse.model.CD;
import CDHouse.model.VideoCD;
import CDHouse.model.AudioCD;
import java.util.Scanner;

/**
 *
 * @author NguyenXuanTrung
 */
public class Terminal implements View {

    @Override
    public CD add() {
        Scanner sc = new Scanner(System.in);
        String collectionName;
        String title;
        String id;
        double price;
        String type;
        System.out.print("Collection name:");
        collectionName = sc.nextLine();
        System.out.print("Title:");
        title = sc.nextLine();
        System.out.print("ID:");
        id = sc.nextLine();
        while (true) {
            System.out.print("Price (please enter a positive number):");
            try {
                price = Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                continue;
            }
            if (price > 0) {
                break;
            }
        }
        while (true) {
            System.out.println("Type (audio or video):");
            type = sc.nextLine();
            switch (type) {
                case "audio":
                    return new AudioCD(collectionName, title, price, id);
                case "video":
                    return new VideoCD(collectionName, title, price, id);
                default:
            }
        }
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
        if (x instanceof CD) {

        }
    }

    private void showCD(CD x) {

    }

    @Override
    public void alert(String msg) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean confirm(String msg) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getString(String prompt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getInteger(String prompt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getDouble(String prompt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
