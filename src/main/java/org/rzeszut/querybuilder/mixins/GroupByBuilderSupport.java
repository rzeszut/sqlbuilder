package org.rzeszut.querybuilder.mixins;

/**
 * Created by mateusz on 30.05.14.
 */
public interface GroupByBuilderSupport extends BaseMixin {
    default void addGroupBy(String column) {
        getBuilder().append(" GROUP BY ").append(column);
    }
}
