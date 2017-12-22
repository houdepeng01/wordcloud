package com.kennycason.kumo.nlp.filter;

import java.util.List;

/**
 * Created by kenny
 */
public class CompositeFilter extends Filter {

    private final List<Filter> filters;

    public CompositeFilter(final List<Filter> filters) {
        this.filters = filters;
    }

    @Override
    public boolean test(String word) {
        for (Filter filter : filters) {
            if (!filter.test(word)) { return false; }
        }
        return true;
    }
}
