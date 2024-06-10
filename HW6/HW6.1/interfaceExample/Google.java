/**
 * This is an interface which provides the name of the Google and
 * consists of a final variable.
 *
 **/
public interface Google {
    String companyName = "Google";
}

/**
 * This class implements three various interfaces google,
 * person, employee. This makes a whole structure for the companyEmployee
 * by overriding the methods in the interface.
 *
 */
class companyEmployee implements Google, Employee, Person {

    @Override
    public String Name() {
        return "Dhruv";
    }

    @Override
    public int Age() {
        return 22;
    }

    @Override
    public String dateOfBirth() {
        return "12/15/2001";
    }

    @Override
    public double SSN() {
        return 42798;
    }

    @Override
    public double employeeId() {
        return 1;
    }

    @Override
    public String position() {
        return "Data Analyst";
    }

    @Override
    public String workDescription() {
        return "Finds meaningful data.";
    }

    public static void main(String[] args) {
        System.out.println(companyEmployee.companyName);
        companyEmployee employee1 = new companyEmployee();
        System.out.println(employee1.Name());
        System.out.println(employee1.Age());
        System.out.println(employee1.dateOfBirth());
        System.out.println(employee1.SSN());
        System.out.println(employee1.employeeId());
        System.out.println(employee1.position());
        System.out.println(employee1.workDescription());
    }
}


