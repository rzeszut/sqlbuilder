package org.rzeszut.sqlbuilder.mixins;

import com.google.common.base.Joiner;

public interface FromBuilderSupport extends BaseMixin {
    default void addFrom(String table) {
        getBuilder().append(" FROM ").append(table);
    }

    default void addFrom(String table, String alias) {
        getBuilder().append(" FROM ");
        Joiner.on(" ").appendTo(getBuilder(), table, alias);
    }

    default void addNextFrom(String table) {
        getBuilder().append(", ").append(table);
    }

    default void addNextFrom(String table, String alias) {
        getBuilder().append(", ");
        Joiner.on(" ").appendTo(getBuilder(), table, alias);
    }
}
