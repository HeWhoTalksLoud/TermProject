public class Main {


    public static void main(String[] args) {

        Employee[] employees = new Employee[10];

        Employee emp1 = new Employee("Иванов Иван Иванович", 1, 25000);
        Employee emp2 = new Employee("Рифеншталь Борух Сигизмундович", 1, 15000);
        Employee emp3 = new Employee("Штисель Ольга Павловна", 2, 12500);


        employees = new Employee[]{emp1, emp2, emp3};


        employeesList(employees);
    }

    public static void employeesList(Employee[] employees) {


         for (Employee employee : employees) {
             System.out.println(employee);
         }


    }
}