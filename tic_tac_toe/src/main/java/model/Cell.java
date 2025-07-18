package model;

public class Cell {
	
	private MarkType mark;

    public Cell() {
        this.mark = MarkType.EMPTY;
    }

    public MarkType getMark() {
        return mark;
    }

    public void setMark(MarkType mark) {
        if (this.mark != MarkType.EMPTY) {
            throw new IllegalStateException("Cell is already marked");
        }
        this.mark = mark;
    }

    public boolean isEmpty() {
        return this.mark == MarkType.EMPTY;
    }

    public void reset() {
        this.mark = MarkType.EMPTY;
    }

}
