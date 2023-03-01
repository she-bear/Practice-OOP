package lesson3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NotebookIterator implements Iterable<Notebook>{
    
    private final List<Notebook> data;

    public NotebookIterator(List<Notebook> data) {
        this.data = data;
    }

    @Override
    public Iterator<Notebook> iterator() {
        List<Notebook> newList = new ArrayList<Notebook>(data);
        return new NotebookStorageIterator(newList); 
    }

    private static class NotebookStorageIterator implements Iterator<Notebook> {

        private final List<Notebook> data;
        private int cursor = 0;

        public NotebookStorageIterator(List<Notebook> data) {
            this.data = data;;
        }

        @Override
        public boolean hasNext() {
            return cursor < data.size();
        }

        @Override
        public Notebook next() {
            return data.get(cursor++);
        }
    }
}
