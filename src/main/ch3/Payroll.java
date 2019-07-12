package ch3;

public class Payroll {

    public Money calculatePay(Employee e) {
        switch (e.type) {
            case "A":
                return calculateCommissionedPay(e);
            case "B":
                return calculateHourlyPay(e);
            default:
                throw new RuntimeException();
        }
    }

    private Money calculateHourlyPay(Employee e) {
        return null;
    }

    private Money calculateCommissionedPay(Employee e) {
        return null;
    }

}
