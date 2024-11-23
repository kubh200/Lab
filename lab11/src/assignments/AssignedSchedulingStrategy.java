package assignments;

import java.util.List;

public class AssignedSchedulingStrategy implements SchedulingStrategy {

  @Override
  public String schedule(List<Assignment> assignments) {
    return "AssignedSchedulingStrategy";
  }
}
