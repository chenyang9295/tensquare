package entity;

import java.util.List;

public class PageResult<T> {
    private Long total;

    private List<T> row;

    public PageResult(Long total, List<T> row) {
        this.total = total;
        this.row = row;
    }

    public Long getTotal() {
        return total;
    }

    public List<T> getRow() {
        return row;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public void setRow(List<T> row) {
        this.row = row;
    }
}
