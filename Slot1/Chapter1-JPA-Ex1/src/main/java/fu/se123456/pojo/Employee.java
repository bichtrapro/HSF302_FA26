package fu.se123456.pojo;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(unique = true)
    private String email;

    @Column(precision = 10, scale = 2)
    private BigDecimal salary;

    // Luôn dùng STRING, KHÔNG dùng mặc định ORDINAL (số thứ tự dễ sai khi enum thay đổi)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    // JPA 2.2+ map LocalDate trực tiếp, không cần @Temporal
    private LocalDate hireDate;

    private boolean active;

    // KHÔNG có cột tương ứng trong DB — tính toán ngay khi gọi getter
    @Transient
    private int yearsOfService;

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public boolean isActive() {
        return active;
    }

    public int getYearsOfService() {
        return yearsOfService;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setYearsOfService(int yearsOfService) {
        this.yearsOfService = yearsOfService;
    }

    public Employee(Long id, String fullName, String email, BigDecimal salary, Gender gender, LocalDate hireDate, boolean active, int yearsOfService) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.salary = salary;
        this.gender = gender;
        this.hireDate = hireDate;
        this.active = active;
        this.yearsOfService = yearsOfService;
    }
    public Employee() {
    }
}
