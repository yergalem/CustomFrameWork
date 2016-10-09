package di.library;

import di.lib.Book;

public interface FineCal {
    void visit( Book root);
    void visit( Magazine node);
    void visit( Media node);
}



