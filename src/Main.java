public class Main {


    public static void main(String[] args) {

        // Employee[] employees = new Employee[10];

        Employee emp1 = new Employee("Иванов Иван Иванович", 1, 25000);
        Employee emp2 = new Employee("Рифеншталь Борух Сигизмундович", 1, 15000);
        Employee emp3 = new Employee("Штисель Ольга Павловна", 2, 29000);
        Employee emp4 = new Employee("Кулакова Ираида Львовна", 2, 32800);
        Employee emp5 = new Employee("Версетти Павел Петрович", 3, 40000);
        Employee emp6 = new Employee("Джонсон Борис Борисович", 3, 55000);
        Employee emp7 = new Employee("Филипс Тревор Михайлович", 4, 42000);
        Employee emp8 = new Employee("Беллик Николай Владимирович", 4, 45000);
        Employee emp9 = new Employee("Дубинина Елена Петровна", 5, 40000);
        Employee emp10 = new Employee("Холстинина Ольга Борисовна", 5, 38000);


        Employee[] employees = new Employee[]{emp1, emp2, emp3, emp4, emp5, emp6, emp7, emp8, emp9, emp10};

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
        // raiseSalary(employees, 10);


        // Повышенная сложность
        // 1.
        raiseSalaryInDept(employees, 2, 10);

        int deptNumber = 4;
        // 2.
        // a
        System.out.println("Сотрудник с мин. зарплатой в отделе №" + deptNumber);
        System.out.println(minSalaryInDept(employees, deptNumber));

        // b
        deptNumber = 5;
        System.out.println("Сотрудник с макс. зарплатой в отделе №" + deptNumber);
        System.out.println(maxSalaryInDept(employees, deptNumber));

        // c
        deptNumber = 1;
        System.out.println("Сумма зарплат по отделу №" + deptNumber);
        System.out.println(totalSalariesInDept(employees, deptNumber));

        // d
        System.out.println("Средняя зарплата по отделу №" + deptNumber);
        System.out.println(avgSalaryInDept(employees, deptNumber));

        // e, f
        deptNumber = 2;
        raiseSalaryInDept(employees, deptNumber, 20);
        System.out.println("Зарплаты в отделе №" + deptNumber + " после индексации");
        employeesListinDept(employees, deptNumber);

        // 3.
        // a
        int salaryLess = 40000;
        System.out.println();
        System.out.println("Список сотрудников с з/п меньше " + salaryLess + ":");
        listSalaryLess(employees, salaryLess);

        // b
        int salaryMore = 50000;
        System.out.println();
        System.out.println("Список сотрудников с з/п больше или равной " + salaryMore + ":");
        listSalaryGreaterOrEq(employees, salaryMore);

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

    public static int raiseByPercent(int number, int percent) {
        return (number + number * percent  / 100);
    }
    public static void raiseSalary(Employee[] employees, int raisePercent) {
        if (raisePercent <= 0) {
            throw new IllegalArgumentException("Процент повышения зарплаты должен быть выше 0");
        }
        int salary;
        for (Employee e : employees) {
            salary = e.getSalary();
            e.setSalary(raiseByPercent(salary, raisePercent));
        }
    }

    public static Employee minSalaryInDept(Employee[] employees, int deptNumber){
        Employee minEmployee = null;
        for (Employee e : employees) {
            if (e.getDepartment() ==  deptNumber) {
                if (minEmployee == null) minEmployee = e;
                if (e.getSalary() <= minEmployee.getSalary()) minEmployee = e;
            }
        }
        // Если в employees вообще нет сотрудников отдела номер deptNumber,
        // метод вернет null
        return minEmployee;
    }

    public static Employee maxSalaryInDept(Employee[] employees, int deptNumber){
        Employee maxEmployee = null;
        for (Employee e : employees) {
            if (e.getDepartment() ==  deptNumber) {
                if (maxEmployee == null) maxEmployee = e;
                if (e.getSalary() >= maxEmployee.getSalary()) maxEmployee = e;
            }
        }
        // Если в employees вообще нет сотрудников отдела номер deptNumber,
        // метод вернет null
        return maxEmployee;
    }

    public static int totalSalariesInDept(Employee[] employees, int deptNumber){
        int total = 0;

        for (Employee e : employees) {
            if (e.getDepartment() == deptNumber)
                total += e.getSalary();
        }

        // Если в employees вообще нет сотрудников отдела номер deptNumber,
        // метод вернет 0
        return total;
    }

    public static int avgSalaryInDept(Employee[] employees, int deptNumber) {
        int i = 0, total = 0;

        for (Employee e : employees) {
            if (e.getDepartment() == deptNumber) {
                i ++;
                total += e.getSalary();
            }
        }

        // Если в employees вообще нет сотрудников отдела номер deptNumber,
        // метод вернет 0
        if (i == 0) return 0;
        else return (total / i);
    }

    public static void raiseSalaryInDept(Employee[] employees, int deptNumber, int percent) {
        for (Employee e : employees) {
            if (e.getDepartment() == deptNumber)
                e.setSalary(raiseByPercent(e.getSalary(), percent));
        }
    }

    public static void employeesListinDept(Employee[] employees, int deptNumber) {
        for (Employee e : employees) {
            if (e.getDepartment() == deptNumber) {
                System.out.println("ФИО: " + e.getFullName() + ", з/п: " + e.getSalary() +
                        " id: " + e.getId());
            }
        }
    }

    public static void listSalaryLess(Employee[] employees, int salary) {
        for (Employee e : employees) {
            if (e.getSalary() < salary) {
                System.out.println("ФИО: " + e.getFullName() + ", з/п: " + e.getSalary() +
                        " id: " + e.getId());
            }
        }
    }

    public static void listSalaryGreaterOrEq(Employee[] employees, int salary) {
        for (Employee e : employees) {
            if (e.getSalary() >= salary) {
                System.out.println("ФИО: " + e.getFullName() + ", з/п: " + e.getSalary() +
                        " id: " + e.getId());
            }
        }
    }




}