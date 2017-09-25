/*
 * Task 01 - Containers
 * CSC Nsk Java 2017
 * Created by frikadelki on 2017/9/22
 */

package org.csc.nsk.java2017.task01;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public final class MultisetBasicTests {
    @Rule
    public final Timeout globalTimeout = TestUtils.makeDefaultTimeoutRule();

    @Test
    public void testNewDefaultMultisetIsEmpty() {
        final Multiset<Object> multiset = MultisetFactory.makeDefaultMultiset();
        Assert.assertTrue(multiset.isEmpty());
        Assert.assertTrue(multiset.size() == 0);
        Assert.assertTrue(!multiset.contains(0));
        Assert.assertTrue(!multiset.iterator().hasNext());
    }
}
