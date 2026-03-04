package dev.onesnzeroes.designpatterns.strategy;

import dev.onesnzeroes.designpatterns.strategy.sorter.BubbleSort;
import dev.onesnzeroes.designpatterns.strategy.sorter.Sorter;

/**
 * Defaults to BubbleSort
 */
public class SortContext {

    private Sorter sorter;

    public SortContext(){
        this.sorter = new BubbleSort();
    }

    public Sorter getSorter() {
        return sorter;
    }

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }

    public int[] sort(int[] arr){
        return this.sorter.sort(arr);
    }
}
