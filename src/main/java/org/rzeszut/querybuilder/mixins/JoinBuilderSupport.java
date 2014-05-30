package org.rzeszut.querybuilder.mixins;

import com.google.common.base.Joiner;
import org.rzeszut.querybuilder.JoinType;

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
