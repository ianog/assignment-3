
/**
 * Write a description of class LamborghiniCarLot here.
 *
 * @author Aaron Schollen
 * @version November 25
 */
import java.util.ArrayList;

public class LamborghiniCarLot
{
    // instance variables - replace the example below with your own
    private String                  lotName;
    private ArrayList <Lamborghini> inventory;

    /**
     * default constructor for LamborghiniCarLot
     */
    public LamborghiniCarLot()
    {
        ArrayList inventory = new ArrayList<>();        
    }

    /**
     * @param the name of the LamborghiniCarLot
     * @param cannot be "Taylor's Used Lambos", will default to "Jason's Used Lambos"
     */
    public LamborghiniCarLot(String lotName)
    {
        if (lotName != null){
            if (lotName.equalsIgnoreCase("Taylor's Used Lambos")){
                this.lotName = "Jason's Used Lambos";       
            }else{
                this.lotName = lotName;
            }
        }
        ArrayList inventory = new ArrayList<>();
        inventory.add(new Lamborghini(1965, "350GT",          365.3, true));
        inventory.add(new Lamborghini(1966, "400GT 2+2",      366.3, false));
        inventory.add(new Lamborghini(1967, "MIURA",          367.3, true));
        inventory.add(new Lamborghini(1968, "espada",         368.3, false));
        inventory.add(new Lamborghini(1969, "islero",         369.3, true));
        inventory.add(new Lamborghini(1970, "jarama",         370.3, false));
        inventory.add(new Lamborghini(1971, "urraco",         371.3, false));
        inventory.add(new Lamborghini(1971, "urraco",         371.3, false));
        inventory.add(new Lamborghini(1973, "countache",      373.3, false));
        inventory.add(new Lamborghini(1974, "silhouette",     374.3, false));
        inventory.add(new Lamborghini(1975, "jalpa",          375.3, true));
        inventory.add(new Lamborghini(1976, "silhouette",     476.3, false));
        inventory.add(new Lamborghini(1977, "silhouette",     377.3, true));
        inventory.add(new Lamborghini(1978, "countache",      478.3, false));
        inventory.add(new Lamborghini(1978, "countache",      578.3, false));
        inventory.add(new Lamborghini(1978, "countache",      378.3, true));
        inventory.add(new Lamborghini(1979, "silhouette",     479.3, false));
        inventory.add(new Lamborghini(1980, "countache",      580.3, false));
        inventory.add(new Lamborghini(1981, "jalpa",          381.3, true));
        inventory.add(new Lamborghini(1981, "jalpa",          481.3, true));
        inventory.add(new Lamborghini(1982, "countache",      582.3, true));
        inventory.add(new Lamborghini(1983, "countache",      383.3, false));
        inventory.add(new Lamborghini(1984, "countache",      484.3, false));
        inventory.add(new Lamborghini(1985, "countache",      585.3, false));
        inventory.add(new Lamborghini(1986, "lm002",          386.3, true));
        inventory.add(new Lamborghini(1987, "jalpa",          487.3, false));
        inventory.add(new Lamborghini(1988, "countache",      588.3, false));
        inventory.add(new Lamborghini(1989, "countache",      389.3, true));
        inventory.add(new Lamborghini(1990, "diablo",         490.3, false));
        inventory.add(new Lamborghini(1991, "lm002",          591.3, false));
        inventory.add(new Lamborghini(1991, "lm002",          391.3, true));
        inventory.add(new Lamborghini(1991, "lm002",          491.3, false));
        inventory.add(new Lamborghini(1991, "lm002",          591.3, true));
        inventory.add(new Lamborghini(1992, "lm002",          392.3, false));
        inventory.add(new Lamborghini(1993, "lm002",          493.3, false));
        inventory.add(new Lamborghini(1994, "diablo",         594.3, false));
        inventory.add(new Lamborghini(1994, "diablo",         394.3, true));
        inventory.add(new Lamborghini(1995, "diablo",         495.3, false));
        inventory.add(new Lamborghini(1996, "diablo",         596.3, false));
        inventory.add(new Lamborghini(1997, "diablo",         397.3, false));
        inventory.add(new Lamborghini(1998, "diablo",         498.3, false));
        inventory.add(new Lamborghini(1999, "diablo",         599.3, false));
        inventory.add(new Lamborghini(1999, "diablo",         599.3, false));
        inventory.add(new Lamborghini(2000, "diablo",         400.3, false));
        inventory.add(new Lamborghini(2000, "diablo",         500.3, false));
        inventory.add(new Lamborghini(2001, "murcielago",     501.3, false));
        inventory.add(new Lamborghini(2002, "murcielago",     502.3, false));
        inventory.add(new Lamborghini(2003, "gallardo",       303.3, true));
        inventory.add(new Lamborghini(2004, "murcielago",     404.3, true));
        inventory.add(new Lamborghini(2005, "murcielago",     505.3, true));
        inventory.add(new Lamborghini(2006, "gallardo",       506.3, true));
        inventory.add(new Lamborghini(2007, "gallardo",       507.3, true));
        inventory.add(new Lamborghini(2008, "reventon",       308.3, false));
        inventory.add(new Lamborghini(2008, "reventon",       508.3, true));
        inventory.add(new Lamborghini(2009, "gallardo",       409.3, true));
        inventory.add(new Lamborghini(2010, "murcielago",     310.3, false));
        inventory.add(new Lamborghini(2011, "aventador",      411.3, false));
        inventory.add(new Lamborghini(2012, "sesto elemento", 512.3, true));

    }

    /**
     * @return    the lot name
     */
    public String getLotName(){
        return lotName;
    }

    /**
     * @return the LamborghiniCarLot inventory
     */
    public ArrayList getInventory(){
        return inventory;
    }

    /**
     * @param the new lot Name. Cannot be "Taylors Used Lambos"
     */
    public void changLotName(){
        if (lotName != null){
            if (lotName.equalsIgnoreCase("Taylor's Used Lambos")){
                this.lotName = "Jason's Used Lambos";       
            }else{
                this.lotName = lotName;
            }

        }
    }
    
    /**
     * @param the new inventory
     */
    public void changeInventory(ArrayList inventory){
    this.inventory = inventory;
    }
    
    /**
     * @param the new Lamborghini, cannot be null
     */
    public void addLamborghini(Lamborghini newLamborghini){
    if (newLamborghini != null){
    inventory.add(new Lamborghini());
    }
    }
}

