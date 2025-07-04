package org.example.common;

import lombok.Data;
import org.example.common.idstrategy.BasicNextIdStrategy;
import org.example.common.idstrategy.IdStrategy;

public class BaseEntity {
    private long id;
    IdStrategy idStrategy;
    public BaseEntity() {
        this.idStrategy = BasicNextIdStrategy.getBasicNextIdStrategy();
        this.id = idStrategy.nextId();
    }
    public long getId() {
        return id;
    }

}
