import java.util.ArrayList;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lista
{
    ArrayList<Kategoria> lista_kategorii = new ArrayList <Kategoria>();
    public void remove_produkt_from_kategoria(String produkt,String kategoria)
    {
        int size = lista_kategorii.size();
        for(int i = 0; i < size; i++)
        {
            if (lista_kategorii.get(i).get_nazwa_kategorii().compareTo(kategoria) == 0)
            {
                lista_kategorii.get(i).remove_produkt_z_listy(produkt);
                return;
            }

        }
    }

    public void remove_cala_lista_produktow()
    {
        for(var kat : lista_kategorii)
        {
            kat.remove_lista_produktow();
        }
    }

    public void remove_cala_lista_produktow_z_kategorii(String nazwa)
    {
        for(var kat : lista_kategorii)
        {
            if(nazwa.compareTo(kat.get_nazwa_kategorii()) == 0)
            {
                kat.remove_lista_produktow();
            }
        }
    }
    public void add_kategoria(String kategoria)
    {
        lista_kategorii.add(new Kategoria(kategoria));
    }

    public void add_produkt(String produkt, String kategoria)
    {
        for(var kat : lista_kategorii)
        {
            if(kategoria.compareTo(kat.get_nazwa_kategorii()) == 0)
            {
                kat.add_produkt(produkt);
            }
        }
    }
    public void wyswietlanie_produktow()
    {
        int size = lista_kategorii.size();
        for(int i = 0; i < size; i++)
        {
            System.out.println(lista_kategorii.get(i).get_nazwa_kategorii());
            for(int j = 0; j < lista_kategorii.get(i).rozmiar_listy_produktow(); j++)
            {
                System.out.println(lista_kategorii.get(i).get_nazwa_produktu(j));
            }
        }
    }

    public void wyswietlanie_produktow_dla_kategorii(String argument)
    {
        int size = lista_kategorii.size();
        for(int i = 0; i < size; i++)
        {
            if (lista_kategorii.get(i).get_nazwa_kategorii().compareTo(argument) == 0)
            {
                for (int j = 0; j < lista_kategorii.get(i).rozmiar_listy_produktow(); j++)
                {
                    System.out.println(lista_kategorii.get(i).get_nazwa_produktu(j));
                }
                return;
            }

        }
    }

    public void wyswietlanie_kategorii()
    {
        int size = lista_kategorii.size();
        for(int i = 0; i < size; i++)
        {
            System.out.println( lista_kategorii.get(i).get_nazwa_kategorii());

        }
    }

    public boolean znajdz_kategorie(String argument)
    {
        for(int i = 0; i < lista_kategorii.size(); i++)
        {
            if(argument.compareTo(lista_kategorii.get(i).get_nazwa_kategorii()) == 0)
            {
                return true;
            }
        }
        return false;
    }

    public void zapisz_plik()
    {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("lista_zakupow.txt")))
        {
            for(var kat : lista_kategorii)
            {
                writer.write(kat.get_nazwa_kategorii() + "\n");
                for(var prod : kat.lista_produktow)
                {
                    writer.write(prod.get_produkt() + "\n");
                }
            }
        }
        catch(IOException e)
        {
            System.out.println("Nie mozna zapisac do pliku");
        }
    }

    public void wczytaj_plik(String nazwa_pliku)
    {
        try
        {
            File plik =  new File(nazwa_pliku);
            Scanner skaner = new Scanner(plik);
            String kategoria ="";
            while(skaner.hasNextLine())
            {
                String dane = skaner.nextLine();
                if((int)dane.charAt(0) == 9 || (int)dane.charAt(0) == 32)
                {
                    if(kategoria.compareTo("") == 0)
                    {
                        System.out.println("Blad zapisu");
                        continue;
                    }
                    add_produkt(dane,kategoria);
                }
                else
                {
                    kategoria = dane;
                    add_kategoria(dane);
                }

            }

        }
        catch(FileNotFoundException e)
        {
            System.out.println("Nie mozna wczytac pliku");
        }
    }
}
