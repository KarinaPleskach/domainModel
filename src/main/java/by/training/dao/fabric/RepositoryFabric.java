package by.training.dao.fabric;

import by.training.dao.Repository;
import by.training.dao.repository.TXTRepository;

public class RepositoryFabric {
    private static Repository repository = new TXTRepository();
    private RepositoryFabric() {}
    public static Repository getRepository() {
        return  repository;
    }
}