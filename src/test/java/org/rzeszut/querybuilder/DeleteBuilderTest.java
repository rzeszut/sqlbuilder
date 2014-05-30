package org.rzeszut.querybuilder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.rzeszut.querybuilder.Condition.eq;
import static org.rzeszut.querybuilder.DeleteBuilder.delete;

public class DeleteBuilderTest {

    @Test
    public void testSimpleDelete() {
        // when
        final String delete = delete()
                .from("users")
                .build();

        // then
        assertEquals("DELETE FROM users", delete);
    }

    @Test
    public void testDeleteWithCondition() {
        // when
        final String delete = delete()
                .from("users")
                .where(eq("id", ":id"))
                .build();

        // then
        assertEquals("DELETE FROM users WHERE id = :id", delete);
    }
}