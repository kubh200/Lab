package assignments;

import java.util.Comparator;
import java.util.List;

public class AlphabeticalSchedulingStrategy implements SchedulingStrategy {
  @Override
  public String schedule(List<Assignment> assignments) {
    assignments.sort(Comparator.comparing(Assignment::getDescription));
    return "AlphabeticalSchedulingStrategy";
  }
}
