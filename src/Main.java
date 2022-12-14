public class Main {


    public static void main(String[] args) {

        Employee[] employees = new Employee[10];

        Employee emp1 = new Employee("Иванов Иван Иванович", 1, 25000);
        Employee emp2 = new Employee("Рифеншталь Борух Сигизмундович", 1, 15000);
        Employee emp3 = new Employee("Штисель Ольга Павловна", 2, 29000);
        Employee emp4 = new Employee("Кулакова Ираида Львовна", 2, 32800);
        Employee emp5 = new Employee("Версетти Павел Петрович", 3, 40000);
        Employee emp6 = new Employee("Джонсон Борис Борисович", 3, 55000);
        Employee emp7 = new Employee("Филипс Тревор Михайлович", 4, 60000);
        Employee emp8 = new Employee("Беллик Николай Владимирович", 4, 45000);
        Employee emp9 = new Employee("Дубинина Елена Петровна", 5, 40000);
        Employee emp10 = new Employee("Холстинина Ольга Борисовна", 5, 38000);


        employees = new Employee[]{emp1, emp2, emp3, emp4, emp5, emp6, emp7, emp8, emp9, emp10};

        // a
        employeesList(employees);
        // b
        System.out.println("Суммарная з/п: " + totalSalaries(employees));
        // c
        Employee e = minSalary(employees);
        System.out.println("Минимальная з/п: " + e.getSalary() + " (" +
                e.getFullName() + ")");
        // d
        e = maxSalary(employees);
        System.out.println("Максимальная з/п: " + e.getSalary() + " (" +
                e.getFullName() + ")");
        // e
        System.out.println("Средняя з/п: " + avgSalary(employees));
        // f
        employeesMames(employees);
    } // main

    public static void employeesList(Employee[] employees) {
         for (Employee employee : employees) {
             System.out.println(employee);
         }
    }

    public static int totalSalaries(Employee[] employees){
        int sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum;
    }

    public static Employee minSalary(Employee[] employees){
        Employee minEmployee = employees[0];

        for (int i = 1; i < employees.length; i++) {
            Employee e = employees[i];
            if (e.getSalary()  < minEmployee.getSalary()) minEmployee = e;
        }
        return minEmployee;
    }

    public static Employee maxSalary(Employee[] employees){
        Employee maxEmployee = employees[0];

        for (int i = 1; i < employees.length; i++) {
            Employee e = employees[i];
            if (e.getSalary()  > maxEmployee.getSalary()) maxEmployee = e;
        }
        return maxEmployee;
    }

    public static int avgSalary(Employee[] employees){

        return totalSalaries(employees) / employees.length;
    }

    public static void employeesMames(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee.getFullName());
        }
    }


}