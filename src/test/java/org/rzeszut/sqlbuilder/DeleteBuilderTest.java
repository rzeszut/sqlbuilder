package org.rzeszut.sqlbuilder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.rzeszut.sqlbuilder.Condition.eq;
import static org.rzeszut.sqlbuilder.DeleteBuilder.deleteFrom;

public class DeleteBuilderTest {

    @Test
    public void testSimpleDelete() {
        // when
        final String delete = deleteFrom("users")
                .build();

        // then
        assertEquals("DELETE FROM users", delete);
    }

    @Test
    public void testDeleteWithCondition() {
        // when
        final String delete = deleteFrom("users")
                .where(eq("id", ":id"))
                .build();

        // then
        assertEquals("DELETE FROM users WHERE id = :id", delete);
    }
}