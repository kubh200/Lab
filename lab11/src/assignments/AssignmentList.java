package assignments;

import java.util.ArrayList;
import java.util.List;

/**
 * A list of task that need to be completed.
 */
public class AssignmentList {

  private List<Assignment> tasks;
  private String ordering;

  /** Default constructor. */
  public AssignmentList() {
    tasks = new ArrayList<>();
    ordering = "assigned";
  }

  /**
   * Add a task to the task list.
   * 
   * @param t the task
   */
  public void add(Assignment t) {
    tasks.add(t);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Ordered by ").append(ordering).append("\n");    
    for (int i = 0; i < tasks.size(); i++) {
      sb.append(i + 1).append(" -- ").append(tasks.get(i)).append("\n");
    }
    return sb.toString();
  }
}
