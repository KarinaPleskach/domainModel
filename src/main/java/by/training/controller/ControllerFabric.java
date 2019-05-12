package by.training.controller;

public final class ControllerFabric {
    private static Controller controller = new DiskController();
    private ControllerFabric() {}
    public static Controller getController() {
        return controller;
    }
}