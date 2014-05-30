package org.rzeszut.querybuilder.mixins;

import com.google.common.base.Joiner;

public interface ColumnsBuilderSupport extends BaseMixin {
    default void addColumns(String...  columns) {
        getBuilder().append(" (");
        Joiner.on(", ").appendTo(getBuilder(), columns);
        getBuilder().append(")");
    }
}
