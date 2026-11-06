public class Main {
    public static void main (String[] args){
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        PhoneBook phone = new PhoneBook();

        while (true){
            System.out.println("1 - Добавить контакт, 2 - Найти контакт, 3 - Удалить контакт, 4 - Вывод всех, 5 - Сохранить файл, 6 - Загрузить данные");
            int choice = 0;
            choice = scanner.nextInt();
            if (choice == 1){
                System.out.print("Введите имя: ");
                String name = scanner.next();

                System.out.print("Введите номер начиная с +7: ");
                String phoneNumber = scanner.next();
                phone.addContact(name, phoneNumber);
            } else if (choice == 2){
                System.out.print("Введите имя для поиска: ");
                String name = scanner.next();
                phone.findContact(name);
            } else if (choice == 3){
                System.out.print("Введите имя для удаления: ");
                String name = scanner.next();
                phone.deleteContact(name);
            } else if (choice == 4){
                phone.printAll();
            } else if (choice == 5){
                phone.saveToFile();
            } else if (choice == 6){
                phone.loadFromFile();
            }
        }
    }
}