import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        BankAccount vano = new BankAccount("Vano");
        BankAccount stepan = new BankAccount("Stepan");
        BankAccount nasty = new BankAccount("Nasty");

        System.out.println("Создание счета");
        System.out.println(vano);
        System.out.println(stepan);

        System.out.println("\nПополнение счета");

        System.out.println("\nБаланс счетов");
        System.out.println("Пополнение счёта Vano:" + vano.deposit(1000));
        System.out.println("Пополнение счёта Stepan:" + stepan.deposit(2500));

        System.out.println("\nБаланс Vano:" + vano.getBalance());
        System.out.println("Баланс Stepan:" + stepan.getBalance());

        System.out.println("\nСнятие денег");
        System.out.println("Снятие 500 рублей с Vano:" + vano.withdraw(500));
        System.out.println("Снятие 1000 рублей с Stepan:" + stepan.withdraw(1000));

        System.out.println("\nБаланс Vano:" + vano.getBalance());
        System.out.println("Баланс Stepan:" + stepan.getBalance());

        System.out.println("\nПеревод денег");
        System.out.println("Перевод 100 рублей с Vano на Stepan:" + vano.transfer(stepan, 100));
        System.out.println("Баланс Vano:" + vano.getBalance());
        System.out.println("Баланс Stepan:" + stepan.getBalance());

        System.out.println("\nСнимаем большее количество денег, чем есть на счету Vano:" + vano.withdraw(5000));
        nasty.setBlocked(true);
        System.out.println("\nБлокируем счёт Nasty и пытаемся перевести на заблокированный счёт 300 рублей:" + stepan.transfer(nasty,300));

        System.out.println("\nstepan похож на nasty: " + stepan.equals(nasty));
    }
}