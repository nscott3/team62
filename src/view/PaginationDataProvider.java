package view;
import java.util.List;

public interface PaginationDataProvider<T> {
    int getTotalRowCount();
    List<T> getRows(int startIndex, int endIndex);
}