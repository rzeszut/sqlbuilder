package org.rzeszut.sqlbuilder.mixins;

import com.google.common.base.Joiner;

public interface ValuesBuilderSupport extends BaseMixin {
    default void addValues(String... values) {
        getBuilder().append(" VALUES (");
        Joiner.on(", ").appendTo(getBuilder(), values);
        getBuilder().append(")");
    }

    default void addNextValues(String... values) {
        getBuilder().append(", (");
        Joiner.on(", ").appendTo(getBuilder(), values);
        getBuilder().append(")");
    }
}
