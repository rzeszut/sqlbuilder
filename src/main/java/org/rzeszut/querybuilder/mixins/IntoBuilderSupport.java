package org.rzeszut.querybuilder.mixins;

public interface IntoBuilderSupport extends BaseMixin {
    default void addInto(String table) {
        getBuilder().append(" INTO ").append(table);
    }
}
