import java.util.Scanner;
import java.util.InputMismatchException;
public class Main
{
    public static void main(String[] args)
    {
        Lista lista_zakupow = new Lista();
        int number;
        lista_zakupow.wczytaj_plik("lista_zakupow.txt");
        lista_zakupow.wyswietlanie_produktow();
        while(true)
        {
            System.out.println("Dodaj produkt do listy zakupów - 1");
            System.out.println("Wyświetl wszystkie produkty z listy zakupów - 2");
            System.out.println("Wyświetl wszystkie produkty z listy zakupów z danej kategorii - 3");
            System.out.println("Usuń wszystkie produkty z listy zakupów - 4");
            System.out.println("Usuń wszystkie produkty z listy zakupów z danej kategorii - 5");
            System.out.println("Usuń produkt z listy zakupów - 6");
            System.out.println("Zapisz listę zakupów na dysku - 7");
            System.out.println("Zamknij program - 8");

            System.out.println("Podaj numer operacji: ");
            Scanner skaner = new Scanner(System.in);
            try
            {
                number = skaner.nextInt();
            }
            catch(InputMismatchException e)
            {
                System.out.println("Nie poprawny znak");
                skaner.close();
                return;
            }

            if(number == 1)
            {
                lista_zakupow.wyswietlanie_kategorii();
                String wybor_kategorii ="";
                try
                {
                    wybor_kategorii = getStringFromUser("Wprowadz nazwe kategorii");
                }
                catch(InputMismatchException e)
                {
                    System.out.println("Nie poprawny znak");
                    return;
                }


                if(lista_zakupow.znajdz_kategorie(wybor_kategorii))
                {
                    lista_zakupow.wyswietlanie_produktow_dla_kategorii(wybor_kategorii);

                    try
                    {
                        String wybor_produkt = getStringFromUser("Wprowadz nazwe produktu");
                        lista_zakupow.add_produkt(" " + wybor_produkt,wybor_kategorii);
                    }
                    catch(InputMismatchException e)
                    {
                        System.out.println("Nie poprawny znak");
                        return;
                    }

                }
            }
            else if(number == 2)
            {
                lista_zakupow.wyswietlanie_produktow();
            }
            else if(number == 3)
            {
                String wybor_kategorii ="";
                try
                {
                    wybor_kategorii = getStringFromUser("Wprowadz nazwe kategorii");
                }
                catch(InputMismatchException e)
                {
                    System.out.println("Nie poprawny znak");
                    return;
                }
                lista_zakupow.wyswietlanie_produktow_dla_kategorii(wybor_kategorii);
            }
            else if(number == 4)
            {
                lista_zakupow.remove_cala_lista_produktow();
            }
            else if(number == 5)
            {
                String wybor_kategorii ="";
                try
                {
                    wybor_kategorii = getStringFromUser("Wprowadz nazwe kategorii");
                }
                catch(InputMismatchException e)
                {
                    System.out.println("Nie poprawny znak");
                    return;
                }
                lista_zakupow.remove_cala_lista_produktow_z_kategorii(wybor_kategorii);
            }
            else if(number == 6)
            {
                String wybor_kategorii ="";
                try
                {
                    wybor_kategorii = getStringFromUser("Wprowadz nazwe kategorii");
                }
                catch(InputMismatchException e)
                {
                    System.out.println("Nie poprawny znak");
                    return;
                }

                String wybor_produktu ="";
                try
                {
                    wybor_produktu = getStringFromUser("Wprowadz nazwe produktu");
                }
                catch(InputMismatchException e)
                {
                    System.out.println("Nie poprawny znak");
                    return;
                }
                lista_zakupow.remove_produkt_from_kategoria(" " + wybor_produktu,wybor_kategorii);
            }
            else if(number == 7)
            {
                lista_zakupow.zapisz_plik();
            }
            else if(number == 8)
            {
                break;
            }
            else
            {
                System.out.println("Nie poprawny numer");
            }


        }
    }


    private static String getStringFromUser(String mssg)
    {
        System.out.println(mssg);
        Scanner systemReader = new Scanner(System.in);

        return systemReader.nextLine();
    }
}

