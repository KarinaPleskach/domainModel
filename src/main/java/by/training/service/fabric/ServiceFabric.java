package by.training.service.fabric;

import by.training.service.DiskService;
import by.training.service.impl.DiskServiceImpl;

public final class ServiceFabric {
    private static DiskService service = new DiskServiceImpl();
    private ServiceFabric() {}
    public static DiskService getService() {
        return service;
    }
}
