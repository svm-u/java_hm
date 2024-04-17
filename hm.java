import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class hm {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        System.out.println("Ведите вашу фамилию");
        String surname = in.nextLine();
        myList.add(surname);
        System.out.println("Ведите ваше имя");
        String name = in.nextLine();
        myList.add(name);
        System.out.println("Ведите ваше отчество");
        String surname2 = in.nextLine();
        myList.add(surname2);
        System.out.println("Ведите вашу дату рождения в формате dd.mm.yyyy");
        String age = in.nextLine();
        myList.add(age);        
        System.out.println("Ведите ваш номер телефона (ввод допускается только цифрами)");
        String phoneNumber = in.nextLine();
        myList.add(phoneNumber);           
        System.out.println("Укажите ваш пол f - женский или m - мужской");
        String gender = in.nextLine();
        myList.add(gender);
        in.close();
        Boolean flag = true;
        for (int i=0; i<myList.size(); i++){
            if (myList.get(i).isEmpty() || myList.get(i).equals(" ")){
                flag = false;               
            }
        }
        if (flag==false){
        System.out.println("Вы ввели не все данные");             
        }else{            
            LocalDate ages;
            int phoneNumbers;
            try{
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                ages = LocalDate.parse(age, formatter);

            }catch (DateTimeParseException e){
                System.out.println("Неверный формат даты, должно быть dd.mm.yyyy");
                return;
            }
            try {
                phoneNumbers = Integer.parseInt(phoneNumber);
            }catch(NumberFormatException e) {
                System.out.println("Неверный формат номера, должны быть только цифры");
                return;
            }
            if (!gender.equals("f") && !gender.equals("m")){
                System.out.println("Неверный формат пола, f - женский или m - мужской");
            }
            String file = surname + ".txt";
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))){
                writer.write(surname+" "+name+" "+surname2+" "+ages.format(DateTimeFormatter.ISO_LOCAL_DATE)+" "+phoneNumbers+" "+gender);
                writer.newLine();
            }catch (IOException e){
                System.out.println("Ошибка записи");
            }
        } 

    } 
}
