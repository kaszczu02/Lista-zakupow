import java.util.ArrayList;
public class Kategoria
{
    ArrayList<Produkt>lista_produktow = new ArrayList <Produkt>();
    String nazwa_kategorii;

    public int rozmiar_listy_produktow()
    {
        return lista_produktow.size();
    }
    public Kategoria(String kategoria)
    {
        nazwa_kategorii = kategoria;
    }
    public String get_nazwa_kategorii()
    {
        return nazwa_kategorii;
    }
    public void add_produkt(String produkt)
    {
        lista_produktow.add(new Produkt(produkt));

    }
    public String get_nazwa_produktu(int index)
    {
        return lista_produktow.get(index).get_produkt();
    }

    public void remove_lista_produktow()
    {
        lista_produktow.removeAll(lista_produktow);
    }
    public void remove_produkt_z_listy(String nazwa_produktu)
    {
        int size = lista_produktow.size();
        for(int i = 0; i < size; i++)
        {
            if(nazwa_produktu.compareTo(lista_produktow.get(i).get_produkt()) == 0)
            {
                lista_produktow.remove(i);
                break;
            }
        }

    }





}
