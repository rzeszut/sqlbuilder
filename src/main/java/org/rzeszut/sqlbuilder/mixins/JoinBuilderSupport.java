package org.rzeszut.sqlbuilder.mixins;

import com.google.common.base.Joiner;
import org.rzeszut.sqlbuilder.JoinType;

public interface JoinBuilderSupport extends BaseMixin {
    default void addJoin(JoinType type, String table) {
        getBuilder().append(" ").append(type).append(" ")
                .append(table);
    }

    default void addJoin(JoinType type, String table, String alias) {
        getBuilder().append(" ").append(type).append(" ");
        Joiner.on(" ").appendTo(getBuilder(), table, alias);
    }
}
