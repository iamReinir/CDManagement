/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package CDHouse;

import CDHouse.model.CDFactory;
import CDHouse.model.CD;
import CDHouse.model.VideoCD;
import CDHouse.control.Controller;

/**
 *
 * @author Giga P34
 */
public class CDManagement {

    public static void CD_construct_test() {
        CD x = new VideoCD();
        x.setCollectionName("Game");
        x.setTitle("Hollow Knight");
        x.setId("1");
        x.setPrice(12);
        assert (x.toString().equals("Game~Hollow Knight~12.0~1"));

        x.setTitle("Hollow~Knight");
        assert (x.toString().equals("Game~Hollow\\~Knight~12.0~1"));

        x.setId("\\ARID");
        assert (x.toString().equals("Game~Hollow\\~Knight~12.0~\\\\ARID"));

        assert (x.getTitle().equals("Hollow~Knight"));
        assert (x.getId().equals("\\ARID"));

        x.setTitle("Hollow~Knight\\~\\");

        CD retype = CDFactory.parse(x.toString());
        assert (retype.getTitle().equals("Hollow~Knight\\~\\"));
        retype.play();

    }
    public static void main(String[] args) {
        Controller control = new Controller();
        control.run();
    }

}
