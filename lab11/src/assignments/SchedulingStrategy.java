package assignments;

import java.util.List;
  /**
   * Schedule assignments based on a specific strategy.
   * 
   * @param assignments the list of assignments to schedule
   * @return the name of the scheduling strategy used
   */
public interface SchedulingStrategy {
  String schedule(List<Assignment> assignments);
}
