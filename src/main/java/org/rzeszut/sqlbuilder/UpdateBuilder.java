package org.rzeszut.sqlbuilder;

import org.rzeszut.sqlbuilder.mixins.QueryBuilderSupport;
import org.rzeszut.sqlbuilder.mixins.SetBuilderSupport;
import org.rzeszut.sqlbuilder.mixins.WhereBuilderSupport;

public final class UpdateBuilder implements SetBuilderSupport {
    private StringBuilder builder = new StringBuilder("UPDATE ");

    private UpdateBuilder() {}

    public static UpdateBuilder update(String table) {
        final UpdateBuilder builder = new UpdateBuilder();
        builder.builder.append(table);
        return builder;
    }

    public SetBuilder set(String column, String value) {
        addSet(column, value);
        return new SetBuilder();
    }

    @Override
    public StringBuilder getBuilder() {
        return builder;
    }

    public final class SetBuilder extends WhereBuilder implements SetBuilderSupport, WhereBuilderSupport {
        private SetBuilder() {}

        public SetBuilder set(String column, String value) {
            addNextSet(column, value);
            return this;
        }

        public WhereBuilder where(Condition condition) {
            addWhere(condition);
            return new WhereBuilder();
        }
    }

    public class WhereBuilder implements QueryBuilderSupport {
        private WhereBuilder() {}

        @Override
        public StringBuilder getBuilder() {
            return builder;
        }
    }
}
