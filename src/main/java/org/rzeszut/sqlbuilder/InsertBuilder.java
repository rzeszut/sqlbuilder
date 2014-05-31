package org.rzeszut.sqlbuilder;

import org.rzeszut.sqlbuilder.mixins.BaseMixin;
import org.rzeszut.sqlbuilder.mixins.ColumnsBuilderSupport;
import org.rzeszut.sqlbuilder.mixins.QueryBuilderSupport;
import org.rzeszut.sqlbuilder.mixins.ValuesBuilderSupport;

public final class InsertBuilder implements ColumnsBuilderSupport, ValuesBuilderSupport {
    private StringBuilder builder = new StringBuilder("INSERT INTO ");

    private InsertBuilder() {}

    public static InsertBuilder insertInto(String table) {
        final InsertBuilder builder = new InsertBuilder();
        builder.builder.append(table);
        return builder;
    }

    public ColumnsBuilder columns(String... values) {
        addColumns(values);
        return new ColumnsBuilder();
    }

    public ValuesBuilder values(String... values) {
        addValues(values);
        return new ValuesBuilder();
    }

    @Override
    public StringBuilder getBuilder() {
        return builder;
    }

    public class ColumnsBuilder extends BaseBuilder implements ValuesBuilderSupport {
        private ColumnsBuilder() {}

        public ValuesBuilder values(String... values) {
            addValues(values);
            return new ValuesBuilder();
        }
    }

    public final class ValuesBuilder extends BaseBuilder implements QueryBuilderSupport, ValuesBuilderSupport {
        private ValuesBuilder() {}

        public ValuesBuilder values(String... values) {
            addNextValues(values);
            return this;
        }
    }

    private class BaseBuilder implements BaseMixin {

        @Override
        public StringBuilder getBuilder() {
            return builder;
        }
    }
}
