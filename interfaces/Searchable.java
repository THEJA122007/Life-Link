package interfaces;

public interface Searchable {
    boolean matchesCity(String city);
    boolean matchesKeyword(String keyword);
}