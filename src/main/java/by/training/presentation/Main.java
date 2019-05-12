package by.training.presentation;

import by.training.controller.Controller;
import by.training.controller.ControllerFabric;

public class Main {
    public static void main(String[] args) {
        Controller controller = ControllerFabric.getController();
        System.out.println("OPEN_DISK: " + controller.executeTask("open_Disk D:\\epam\\Java\\web\\DomainModel\\test.txt"));
        System.out.println("SHOW: " + controller.executeTask("show"));
        System.out.println("FIND: " + controller.executeTask("find duration 2.30-6.04"));
//        System.out.println("FIND: " + controller.executeTask("find band Maroon5 style POP"));
//        System.out.println("FIND: " + controller.executeTask("find record ringtone"));
//        System.out.println("FIND: " + controller.executeTask("find timbre BASS"));
//        System.out.println("SORT: " + controller.executeTask("sort songName"));
//        System.out.println("SORT: " + controller.executeTask("sort performer duration"));
//        System.out.println("DELETE: " + controller.executeTask("delete duration 0.0-1.0"));
        System.out.println("SHOW: " + controller.executeTask("show"));
//        System.out.println("DELETE: " + controller.executeTask("delete band Maroon5 style POP"));
        System.out.println("SHOW: " + controller.executeTask("show"));
//        System.out.println("SUM: " + controller.executeTask("sum duration all"));
//        System.out.println("ADD: " + controller.executeTask("add Ringtone ring 1 0"));
//        System.out.println("ADD: " + controller.executeTask("add D:\\epam\\Java\\web\\DomainModel\\add.txt"));
//        System.out.println("SUM: " + controller.executeTask("sum performer band"));
//        System.out.println("SAVE: " + controller.executeTask("save D:\\epam\\Java\\web\\DomainModel\\test.txt"));
//        System.out.println("DELETE: " + controller.executeTask("delete"));
    }
}
