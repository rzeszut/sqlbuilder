package org.rzeszut.querybuilder;

import org.rzeszut.querybuilder.mixins.FromBuilderSupport;
import org.rzeszut.querybuilder.mixins.QueryBuilderSupport;
import org.rzeszut.querybuilder.mixins.WhereBuilderSupport;

public final class DeleteBuilder implements FromBuilderSupport {
    private StringBuilder builder = new StringBuilder("DELETE");

    private DeleteBuilder() {}

    public static DeleteBuilder delete() {
        return new DeleteBuilder();
    }

    public FromBuilder from(String table) {
        addFrom(table);
        return new FromBuilder();
    }

    @Override
    public StringBuilder getBuilder() {
        return builder;
    }

    public final class FromBuilder extends EndBuilder implements WhereBuilderSupport {
        private FromBuilder() {}

        public EndBuilder where(Condition condition) {
            addWhere(condition);
            return new EndBuilder();
        }
    }

    public class EndBuilder implements QueryBuilderSupport {
        private EndBuilder() {}

        @Override
        public StringBuilder getBuilder() {
            return builder;
        }
    }
}
