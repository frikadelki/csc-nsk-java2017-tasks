/*
 * Task 01 - Containers
 * CSC Nsk Java 2017
 * Created by frikadelki on 2017/9/22
 */

package org.csc.nsk.java2017.task01.impl.frikadelki;

import org.csc.nsk.java2017.task01.Multiset;

import java.util.Collection;
import java.util.Iterator;

public final class DummyMultiset<TElement> implements Multiset<TElement> {
    public DummyMultiset() {
    }

    public DummyMultiset(final Collection<? extends TElement> sourceCollection) {
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<TElement> iterator() {
        return new Iterator<TElement>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public TElement next() {
                return null;
            }
        };
    }

    @Override
    public boolean add(final TElement element) {
        return false;
    }

    @Override
    public int add(final TElement element, final int occurrences) {
        return 0;
    }

    @Override
    public boolean remove(final Object e) {
        return false;
    }

    @Override
    public int remove(final Object e, final int occurrences) {
        return 0;
    }

    @Override
    public int count(final Object e) {
        return 0;
    }

    @Override
    public boolean containsAll(final Collection<?> c) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(final T[] a) {
        return null;
    }

    @Override
    public boolean removeAll(final Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(final Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public boolean contains(final Object o) {
        return false;
    }

    @Override
    public boolean addAll(final Collection<? extends TElement> c) {
        return false;
    }
}
