package by.training.creator;

public class CreatorFabric {
    private static Creator creator = new RecordCreator();
    private CreatorFabric() {}
    public static Creator getCreator() {
        return  creator;
    }
}
