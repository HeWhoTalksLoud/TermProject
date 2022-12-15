public class Employee {

    private static int counter = 0;
    private String fullName;
    private int department;
    private int salary;
    private int id;

    public String getFullName() {
        return fullName;
    }



    public Employee(String fullName, int department, int salary) {
        if (fullName.isEmpty()) {
            throw new IllegalArgumentException("Имя сотрудника не может быть пустым");
        }
        this.fullName = fullName;
        this.id = counter++;
        setDepartment(department);
        setSalary(salary);

    }

    public int getId() {
        return id;
    }
    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Номер отдела должен быть в диапазоне от 1 до 5");
        }
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Значение зарплаты не может быть отрицательным");
        }
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ФИО: " + this.fullName +
                ", отдел " + this.department +
                ", з/п: " + this.salary +
                ", id: " + this.id;
    }
}
