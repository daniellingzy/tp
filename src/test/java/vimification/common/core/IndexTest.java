package vimification.common.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link Index} class.
 */
public class IndexTest {

    /**
     * Tests that {@link Index#fromZeroBased(int)} correctly creates an index with the expected
     * zero-based value.
     */
    @Test
    public void fromZeroBased_validInput_success() {
        Index index = Index.fromZeroBased(5);
        assertEquals(5, index.getZeroBased());
    }

    /**
     * Tests that {@link Index#fromOneBased(int)} correctly creates an index with the expected
     * zero-based value.
     */
    @Test
    public void fromOneBased_validInput_success() {
        Index index = Index.fromOneBased(6);
        assertEquals(5, index.getZeroBased());
    }

    /**
     * Tests that {@link Index#getOneBased()} correctly returns the expected one-based value.
     */
    @Test
    public void getOneBased_validInput_success() {
        Index index = Index.fromZeroBased(3);
        assertEquals(4, index.getOneBased());
    }

    /**
     * Tests that {@link Index#equals(Object)} returns true for two indexes with the same zero-based
     * value.
     */
    @Test
    public void equals_sameZeroBasedValue_success() {
        Index index1 = Index.fromZeroBased(3);
        Index index2 = Index.fromZeroBased(3);
        assertTrue(index1.equals(index2));
    }

    /**
     * Tests that {@link Index#equals(Object)} returns false for two indexes with different
     * zero-based values.
     */
    @Test
    public void equals_differentZeroBasedValue_failure() {
        Index index1 = Index.fromZeroBased(2);
        Index index2 = Index.fromZeroBased(5);
        assertFalse(index1.equals(index2));
    }

    /**
     * Tests that {@link Index#toString()} returns the expected string representation of the index.
     */
    @Test
    public void toString_validInput_success() {
        Index index = Index.fromOneBased(8);
        assertEquals("Index [8]", index.toString());
    }
}
