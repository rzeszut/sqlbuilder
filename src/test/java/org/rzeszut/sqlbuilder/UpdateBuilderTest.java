package org.rzeszut.sqlbuilder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.rzeszut.sqlbuilder.Condition.gt;
import static org.rzeszut.sqlbuilder.UpdateBuilder.update;

public class UpdateBuilderTest {

    @Test
    public void testSimpleUpdate() {
        // when
        final String update = update("users")
                .set("id", "id + 1")
                .build();

        // then
        assertEquals("UPDATE users SET id = id + 1", update);
    }

    @Test
    public void testUpdateWithWhere() {
        // when
        final String update = update("users")
                .set("id", "id + 1")
                .where(gt("id", "100"))
                .build();

        // then
        assertEquals("UPDATE users SET id = id + 1 WHERE id > 100", update);
    }

    @Test
    public void testUpdateWithMultipleSets() {
        // when
        final String update = update("users")
                .set("id", "id + 1")
                .set("name", "'asdf'")
                .where(gt("id", "100"))
                .build();

        // then
        assertEquals("UPDATE users SET id = id + 1, name = 'asdf' WHERE id > 100", update);
    }
}