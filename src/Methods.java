import java.time.LocalDate;
import java.util.Scanner;

public class Methods {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Задание 1:");
        System.out.println("Введите год, который хотите проверить");
        int checkingYear = console.nextInt();
        checkLeapYear(checkingYear);
        printSeparator();
        System.out.println("Задание 2:");
        System.out.println("Введите тип операционной системы (0 - iOS, 1 - Android)");
        int typeOS = console.nextInt();
        System.out.println("Введите год выпуска устройства");
        int deviceYear = console.nextInt();
        checkVersion(typeOS, deviceYear);
        printSeparator();
        System.out.println("Задание 3:");
        System.out.println("Введите дистанцию");
        int distance = console.nextInt();
        int days = calculationShippingDays(distance);
        if (days > 3) {
            System.out.println("Доставки нет");
        }
        else {
            System.out.println("Итоговое время доставки - " + days + " суток");
        }
        printSeparator();
    }

    public static void printSeparator() {
        System.out.println("====================");
    }

    public static void checkLeapYear(int year) {
        if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
            System.out.println("Год является високосным");
        }
        else {
            System.out.println("Год не является високосным");
        }
    }

    public static void checkVersion(int clientOS, int clientDeviceYear) {
        int currentYear = LocalDate.now().getYear();
        if (clientOS == 0) {
            if (clientDeviceYear >= currentYear) {
                System.out.println("Установите облегченную версию приложения для iOS по ссылке");
            }
            else {
                System.out.println("Установите версию приложения для iOS по ссылке");
            }
        }
        else {
            if (clientDeviceYear >= currentYear) {
                System.out.println("Установите облегченную версию приложения для Android по ссылке");
            }
            else {
                System.out.println("Установите версию приложения для Android по ссылке");
            }
        }
    }

    public static int calculationShippingDays (int deliveryDistance) {
        int deliveryTime = 0;
        if (deliveryDistance < 20) {
            deliveryTime += 1;
        }
        else if (deliveryDistance >= 20 && deliveryDistance < 60) {
            deliveryTime += 2;
        } else if (deliveryDistance >= 60 && deliveryDistance < 100) {
            deliveryTime += 3;
        }
        else {
            deliveryTime += 4;
        }
        return deliveryTime;
    }
}
