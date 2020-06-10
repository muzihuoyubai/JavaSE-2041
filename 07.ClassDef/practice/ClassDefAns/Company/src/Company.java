public class Company {

    private Employee [] employeeArr = new Employee[100];
    private int employeeTotal = 0;

    public void add(Employee employee) {
        if (employee == null) {
            System.out.println("不合法");
            return;
        }

        employeeArr[employeeTotal++] = employee;
    }

    public Employee remove(String name) {
        int index = -1;

        for (int i = 0; i < employeeTotal ; i++ ) {
            if (employeeArr[i].getName().equals(name)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return null;
        }

        Employee rlt = employeeArr[index];

        employeeArr[index] = employeeArr[employeeTotal - 1];
        employeeArr[employeeTotal--] = null;

        return rlt;

    }

    public void printAll() {
    	System.out.println("=============");
        for (int i = 0; i < employeeTotal; i++ ) {
            Employee employee = employeeArr[i];
            System.out.println(employee.getName() + ":" + employee.getSalary());
        }

    }

}