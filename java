import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private int age;
    private String department;
    private String code;
    private double salaryRate;

    public Employee(int id, String name, int age, String department, String code, double salaryRate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.code = code;
        this.salaryRate = salaryRate;
    }

    // Getters and setters
    // Nếu cần, bạn có thể thêm các phương thức khác tại đây.

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                ", code='" + code + '\'' +
                ", salaryRate=" + salaryRate +
                '}';
    }
}

public class EmployeeManagementApp {
    private static List<Employee> employees = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        // Khởi tạo 10 nhân viên
        for (int i = 0; i < 10; i++) {
            employees.add(new Employee(nextId++, "Employee " + (i + 1), 30, "IT", "EMP" + nextId, 1000));
        }

        displayEmployees();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Thêm nhân viên mới");
            System.out.println("2. Xóa nhân viên");
            System.out.println("3. Hiển thị danh sách nhân viên");
            System.out.println("4. Thoát");
            System.out.print("Chọn một chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addEmployee(scanner);
                    break;
                case 2:
                    deleteEmployee(scanner);
                    break;
                case 3:
                    displayEmployees();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    private static void addEmployee(Scanner scanner) {
        System.out.println("\nNhập thông tin cho nhân viên mới:");
        System.out.print("Tên: ");
        String name = scanner.nextLine();
        System.out.print("Tuổi: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Phòng ban: ");
        String department = scanner.nextLine();
        System.out.print("Mã nhân viên: ");
        String code = scanner.nextLine();
        System.out.print("Mức lương: ");
        double salaryRate = scanner.nextDouble();

        employees.add(new Employee(nextId++, name, age, department, code, salaryRate));
        System.out.println("Nhân viên mới đã được thêm vào danh sách.");
    }

    private static void deleteEmployee(Scanner scanner) {
        System.out.print("Nhập ID của nhân viên cần xóa: ");
        int id = scanner.nextInt();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                employees.remove(i);
                System.out.println("Nhân viên có ID " + id + " đã được xóa.");
                return;
            }
        }
        System.out.println("Không tìm thấy nhân viên có ID " + id + ".");
    }

    private static void displayEmployees() {
        System.out.println("\nDanh sách nhân viên:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}