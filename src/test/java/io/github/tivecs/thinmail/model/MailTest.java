package io.github.tivecs.thinmail.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

import org.junit.jupiter.api.Test;

class MailTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Mail#Mail(Long, String, String, String, String, Date)}
     *   <li>{@link Mail#getBody()}
     *   <li>{@link Mail#getId()}
     *   <li>{@link Mail#getReceiverId()}
     *   <li>{@link Mail#getSendAt()}
     *   <li>{@link Mail#getSenderId()}
     *   <li>{@link Mail#getSubject()}
     * </ul>
     */
    @Test
    void testConstructorForFullMail() {
        Date sendAt = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        Mail actualMail = new Mail(1L, "42", "42", "Hello from the Dreaming Spires", "Not all who wander are lost", sendAt);

        assertEquals("Not all who wander are lost", actualMail.getBody());
        assertEquals(1L, actualMail.getId().longValue());
        assertEquals("42", actualMail.getReceiverId());
        assertSame(sendAt, actualMail.getSendAt());
        assertEquals("42", actualMail.getSenderId());
        assertEquals("Hello from the Dreaming Spires", actualMail.getSubject());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Mail#Mail(String, String, String, String)}
     *   <li>{@link Mail#getBody()}
     *   <li>{@link Mail#getId()}
     *   <li>{@link Mail#getReceiverId()}
     *   <li>{@link Mail#getSenderId()}
     *   <li>{@link Mail#getSubject()}
     * </ul>
     */
    @Test
    void testConstructorForSendingMail() {
        Mail actualMail = new Mail("42", "42", "Hello from the Dreaming Spires", "Not all who wander are lost");

        assertEquals("Not all who wander are lost", actualMail.getBody());
        assertNull(actualMail.getId());
        assertEquals("42", actualMail.getReceiverId());
        assertEquals("42", actualMail.getSenderId());
        assertEquals("Hello from the Dreaming Spires", actualMail.getSubject());
    }
}

