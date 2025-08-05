import java.util.Comparator;

// Comparator to sort by name (alphabetically), then age (ascending)
public class VisitorNameAgeComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        int nameCompare = v1.getName().compareToIgnoreCase(v2.getName());
        if (nameCompare != 0) {
            return nameCompare;
        }
        // If names are the same, compare by age
        return Integer.compare(v1.getAge(), v2.getAge());
    }
}
