/**
 * This is an interface which provides the name of the hospital and
 * consists of a final variable.
 *
 **/
public interface childCareHospital {
    String hospitalName = "Child Care Hospital";
}

/**
 * This class implements three various interfaces childcarehospital,
 * person, employee. This makes a whole structure for the hospitalEmployee
 * by overriding the methods in the interface.
 *
 */
class hospitalEmployee implements childCareHospital, Person, Employee{
    @Override
    public double employeeId() {
        return 01;
    }

    @Override
    public String position() {
        return "nurse";
    }

    @Override
    public String workDescription() {
        return "Nursing Patients";
    }

    @Override
    public String Name() {
        return "Mariam";
    }

    @Override
    public int Age() {
        return 22;
    }

    @Override
    public String dateOfBirth() {
        return "06/13/2001";
    }

    @Override
    public double SSN() {
        return 669;
    }

    public static void main(String[] args) {
        System.out.println(hospitalEmployee.hospitalName);
        hospitalEmployee employee1 = new hospitalEmployee();
        System.out.println(employee1.Name());
        System.out.println(employee1.Age());
        System.out.println(employee1.dateOfBirth());
        System.out.println(employee1.SSN());
        System.out.println(employee1.employeeId());
        System.out.println(employee1.position());
        System.out.println(employee1.workDescription());
    }
}