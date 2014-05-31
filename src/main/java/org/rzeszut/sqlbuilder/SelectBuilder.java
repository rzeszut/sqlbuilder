package org.rzeszut.sqlbuilder;

import com.google.common.base.Joiner;
import org.rzeszut.sqlbuilder.mixins.*;

public final class SelectBuilder implements FromBuilderSupport {
    private static final String ALL_COLUMNS = "*";

    private StringBuilder builder = new StringBuilder("SELECT ");

    private SelectBuilder() {}

    public static SelectBuilder select() {
        final SelectBuilder builder = new SelectBuilder();
        builder.builder.append(ALL_COLUMNS);
        return builder;
    }

    public static SelectBuilder select(String... cols) {
        final SelectBuilder builder = new SelectBuilder();
        Joiner.on(", ").appendTo(builder.builder, cols);
        return builder;
    }

    public FromBuilder from(String table) {
        addFrom(table);
        return new FromBuilder();
    }

    public FromBuilder from(String table, String alias) {
        addFrom(table, alias);
        return new FromBuilder();
    }

    @Override
    public StringBuilder getBuilder() {
        return builder;
    }

    public final class FromBuilder extends JoinConditionBuilder implements FromBuilderSupport {
        private FromBuilder() {}

        public FromBuilder from(String table) {
            addNextFrom(table);
            return this;
        }

        public FromBuilder from(String table, String alias) {
            addNextFrom(table, alias);
            return this;
        }
    }

    public final class JoinBuilder extends JoinConditionBuilder implements JoinConditionBuilderSupport {
        private JoinBuilder() {}

        public JoinConditionBuilder on(Condition condition) {
            addOn(condition);
            return new JoinConditionBuilder();
        }

        public JoinConditionBuilder using(String column) {
            addUsing(column);
            return new JoinConditionBuilder();
        }
    }

    public class JoinConditionBuilder extends WhereBuilder implements JoinBuilderSupport, WhereBuilderSupport {
        private JoinConditionBuilder() {}

        public JoinBuilder innerJoin(String table) {
            addJoin(JoinType.INNER, table);
            return new JoinBuilder();
        }

        public JoinBuilder innerJoin(String table, String alias) {
            addJoin(JoinType.INNER, table, alias);
            return new JoinBuilder();
        }

        public JoinBuilder leftOuterJoin(String table) {
            addJoin(JoinType.LEFT_OUTER, table);
            return new JoinBuilder();
        }

        public JoinBuilder leftOuterJoin(String table, String alias) {
            addJoin(JoinType.LEFT_OUTER, table, alias);
            return new JoinBuilder();
        }

        public JoinBuilder rightOuterJoin(String table) {
            addJoin(JoinType.RIGHT_OUTER, table);
            return new JoinBuilder();
        }

        public JoinBuilder rightOuterJoin(String table, String alias) {
            addJoin(JoinType.RIGHT_OUTER, table, alias);
            return new JoinBuilder();
        }

        public JoinBuilder fullOuterJoin(String table) {
            addJoin(JoinType.FULL_OUTER, table);
            return new JoinBuilder();
        }

        public JoinBuilder fullOuterJoin(String table, String alias) {
            addJoin(JoinType.FULL_OUTER, table, alias);
            return new JoinBuilder();
        }

        public WhereBuilder where(Condition cond) {
            addWhere(cond);
            return new WhereBuilder();
        }
    }

    public class WhereBuilder extends BaseBuilder implements QueryBuilderSupport, GroupByBuilderSupport, OrderByBuilderSupport {
        private WhereBuilder() {}

        public GroupByBuilder groupBy(String column) {
            addGroupBy(column);
            return new GroupByBuilder();
        }

        public OrderByBuilder orderBy(String column) {
            addOrderBy(column);
            return new OrderByBuilder();
        }

        public OrderByBuilder orderBy(String column, Order order) {
            addOrderBy(column, order);
            return new OrderByBuilder();
        }
    }

    public final class GroupByBuilder extends HavingBuilder implements HavingBuilderSupport {
        private GroupByBuilder() {}

        public HavingBuilder having(Condition condition) {
            addHaving(condition);
            return new HavingBuilder();
        }
    }

    public class HavingBuilder extends BaseBuilder implements QueryBuilderSupport, OrderByBuilderSupport {
        private HavingBuilder() {}

        public OrderByBuilder orderBy(String column) {
            addOrderBy(column);
            return new OrderByBuilder();
        }

        public OrderByBuilder orderBy(String column, Order order) {
            addOrderBy(column, order);
            return new OrderByBuilder();
        }
    }

    public final class OrderByBuilder extends BaseBuilder implements QueryBuilderSupport, OrderByBuilderSupport {
        private OrderByBuilder() {}

        public OrderByBuilder orderBy(String column) {
            addNextOrderBy(column);
            return this;
        }

        public OrderByBuilder orderBy(String column, Order order) {
            addNextOrderBy(column, order);
            return this;
        }
    }

    private abstract class BaseBuilder implements BaseMixin {

        @Override
        public StringBuilder getBuilder() {
            return builder;
        }
    }
}
