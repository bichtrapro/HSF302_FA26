package fu.se123456;

import fu.se123456.dao.EmployeeDAO;
import fu.se123456.pojo.Employee;
import fu.se123456.pojo.Gender;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("hsf302FU");
        //
        // System.out.println("EMF tao thanh cong!");

        //Test TODO 0.3
        EmployeeDAO dao = new EmployeeDAO();

        // ===== CREATE =====
        // [Lifecycle] emp dang o trang thai NEW/TRANSIENT (moi "new", chua lien quan DB)
        Employee emp = new Employee("Nguyen Van A", "a@fpt.edu.vn",
                new BigDecimal("15000000"), Gender.MALE, LocalDate.of(2022, 3, 1));

        dao.save(emp);
        // [Lifecycle] sau save(): trong luc persist() emp la MANAGED; sau khi method
        // save() return (EntityManager da dong), emp tro thanh DETACHED.
        System.out.println("Da tao: " + emp);
    }

}
