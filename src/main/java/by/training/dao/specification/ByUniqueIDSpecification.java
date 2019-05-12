package by.training.dao.specification;

import by.training.dao.Specification;
import by.training.entity.Record;

public class ByUniqueIDSpecification implements Specification<Record> {

    private String searchID;

    public ByUniqueIDSpecification(String searchID) {
        this.searchID = searchID;
    }

    @Override
    public boolean match(Record bean) {
        return this.searchID.equals(bean.getUniqueID());
    }
}
