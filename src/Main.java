import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        task1();
        task2();
        task3();
        task4();

    }
    public static void task1() throws IOException {
        Scanner input = new Scanner(System.in);
        FileWriter output = null;
        String line;

        System.out.println("Podaj sciezkę do pliku");

        try {
            output = new FileWriter(input.nextLine());
            System.out.println("Podaj zawartosc do wpisanaia pliku, " +
                    "zakonczenie wprowadzania tekstu bedzie przy pojawienei sie zanku -");
            while (true) {
                line = input.nextLine();
                if (line.equals("-")) break;
                output.write(line);
                output.write(System.lineSeparator());
            }
        } finally {
            if (output != null)
                output.close();
        }
    }
    public static void task2() throws IOException{
        System.out.println("Podaj ścieżke do pliku: ");
        Scanner input = new Scanner(System.in);
        BufferedReader Buffered = new BufferedReader(new FileReader(input.nextLine()));

        try {
            int licznik = 0;
            String Linia;
            while ((Linia = Buffered.readLine()) != null) {
                if (!Linia.isEmpty()) {
                    System.out.println(Linia);
                    licznik++;
                }
            }
            System.out.println("Liczba linii w pliku: "+licznik);

        } finally {
            Buffered.close();
        }
    }

    public static int Wczytywanie(String prompt,int minValue, int maxValue){
        boolean JestPoprawna = false;
        int WproawdzanaDana=0;
        Scanner input = new Scanner(System.in);
        while(!JestPoprawna){

            System.out.println(prompt);
            try{
           WproawdzanaDana = input.nextInt();
           if(WproawdzanaDana>=minValue && WproawdzanaDana <= maxValue ){
               JestPoprawna = true;
           }

            } catch (Exception e){
                System.out.println("Błędnie wprowadzona dana");
            }


        }
        return WproawdzanaDana;
    }
    public static void task3() throws IOException{
        Scanner input = new Scanner(System.in);
        System.out.print("Podaj scieżkę: ");
        DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(input.nextLine()));
         int rok,miesiac,dzien;
         rok = Wczytywanie("Wproawdź rok",1900,2023);
         miesiac = Wczytywanie("Wproawdź miesiąc",1,12);
         dzien = Wczytywanie("Wprawdz dzien",1,31);
         outputStream.writeInt(rok);
         outputStream.writeInt(miesiac);
         outputStream.writeInt(dzien);
         outputStream.close();
    }
    public static void task4() throws  IOException{
        Scanner input = new Scanner(System.in);
        System.out.print("Podaj ścieżkę do pliku binarnego: ");
        DataInputStream inputStream = new DataInputStream(new FileInputStream(input.nextLine()));
            int rokOdczyt = inputStream.readInt();
            int miesiacOdczyt = inputStream.readInt();
            int dzienOdczyt = inputStream.readInt();
            System.out.println("Data urodzenia: "+rokOdczyt+ "-"+miesiacOdczyt+"-"+dzienOdczyt);

        }



}






