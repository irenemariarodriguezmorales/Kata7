package view;

import model.Block;

public interface BlockDisplay{
    public static final int SIZE = 100;
    void paintBlock(int x, int y);
    void on(Moved moved);
    
    public interface Moved {
        void to(int x, int y);
    }
    
}
