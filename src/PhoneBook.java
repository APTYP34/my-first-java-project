import javax.xml.namespace.QName;
import java.io.FileWriter;

import java.util.HashMap;

public class PhoneBook {
    HashMap<String, Contact> contactMap = new HashMap<>();

    public void addContact(String name, String phoneNumber){
        if (contactMap.containsKey(name)){
            System.out.print("Контакт уже существует!");
            return;
        }
        Contact c = new Contact(name, phoneNumber);
        contactMap.put(name, c);
    }

    public void findContact(String name){
        if (contactMap.containsKey(name)){
            System.out.print("Контакт найден: " +contactMap.get(name));
            return;
        }
        System.out.print("Контакт не найден");
    }

    public void deleteContact(String name){
        if (contactMap.containsKey(name)){
            contactMap.remove(name);
            System.out.print("Контакт удален!");
            return;
        }
        System.out.print("Контакт не найден или был удален ранее");
    }

    public void printAll() {
        System.out.println("=== СПИСОК КОНТАКТОВ ==="); // Заголовок до цикла
        for (Contact c : contactMap.values()) {
            // Выводим и имя, и номер. println делает перенос строки
            System.out.println(c.getName() + " - " + c.getPhoneNumber());
        }
    }

    public void saveToFile(){
        try{
            java.io.FileWriter writer = new java.io.FileWriter("contacts.txt", java.nio.charset.StandardCharsets.UTF_8);
            for (Contact c : contactMap.values()){
                writer.write(c.getName() + " " + c.getPhoneNumber() + "\n");
            }

            writer.close(); // ОБЯЗАТЕЛЬНО закрываем файл!
            System.out.println("Контакты успешно сохранены!");

        } catch (Exception e){
            System.out.print("Ошибка записи!");
        }
    }

    public void loadFromFile(){
        try{
            java.io.File file = new java.io.File("contacts.txt");
            if (!file.exists()){
                System.out.println("Файл не найден!");
                return;
            }

            java.util.Scanner fileScanner = new java.util.Scanner(file, "UTF-8");
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(" ");
                String name = parts[0].trim();
                String phoneNumber = parts[1].trim();
                contactMap.put(name, new Contact(name, phoneNumber));
            }
            fileScanner.close();
            System.out.println("Контакты успешно загружены из файла!");
        } catch (Exception e){
            System.out.println("Ошибка при загрузке файла!");
        }
    }
}
