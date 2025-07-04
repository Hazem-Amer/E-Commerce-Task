package org.example.common.idstrategy;

public class BasicNextIdStrategy implements IdStrategy {
    //only one instance needed
    private static  BasicNextIdStrategy basicNextIdStrategy;
    private BasicNextIdStrategy() {
    }

    public static BasicNextIdStrategy getBasicNextIdStrategy() {
        if(basicNextIdStrategy == null) {
            basicNextIdStrategy = new BasicNextIdStrategy();
        }
        return basicNextIdStrategy;
    }

    protected static int baseId = 0;
    @Override
    public long nextId() {
        return ++baseId;
    }
}
