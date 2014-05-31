package org.rzeszut.sqlbuilder;

import org.rzeszut.sqlbuilder.mixins.QueryBuilderSupport;
import org.rzeszut.sqlbuilder.mixins.WhereBuilderSupport;

public final class DeleteBuilder implements QueryBuilderSupport, WhereBuilderSupport {
    private StringBuilder builder = new StringBuilder("DELETE FROM ");

    private DeleteBuilder() {}

    public static DeleteBuilder deleteFrom(String table) {
        final DeleteBuilder builder = new DeleteBuilder();
        builder.builder.append(table);
        return builder;
    }

    public EndBuilder where(Condition condition) {
        addWhere(condition);
        return new EndBuilder();
    }

    @Override
    public StringBuilder getBuilder() {
        return builder;
    }

    public final class EndBuilder implements QueryBuilderSupport {
        private EndBuilder() {}

        @Override
        public StringBuilder getBuilder() {
            return builder;
        }
    }
}
