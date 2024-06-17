package leet.solutions;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class EmployeeImportanceTest {

    @Test
    public void testCase() {
        Assert.assertEquals(11, new EmployeeImportance().solve(
                List.of(new EmployeeImportance.Employee(1, 5, List.of(2, 3)),
                        new EmployeeImportance.Employee(2, 3, Collections.emptyList()),
                        new EmployeeImportance.Employee(3, 3, Collections.emptyList())), 1
        ));
    }

}