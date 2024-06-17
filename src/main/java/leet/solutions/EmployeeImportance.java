package leet.solutions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeImportance {

    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    }


    @SuppressWarnings("ClassEscapesDefinedScope")
    public int solve(List<Employee> employees, int id) {
        return new Solution().getImportance(employees, id);
    }


    static class Solution {
        public int getImportance(List<Employee> employees, int id) {
            Map<Integer, Employee> employeeMap = new HashMap<>();
            for (Employee employee : employees) {
                employeeMap.put(employee.id, employee);
            }

            return recursiveImportance(id, employeeMap);
        }

        private int recursiveImportance(int employeeId, Map<Integer, Employee> employeeMap) {
            Employee employee = employeeMap.get(employeeId);
            int imp = employee.importance;
            for (Integer id : employee.subordinates) {
                imp += recursiveImportance(id, employeeMap);
            }
            return imp;
        }

    }

}
