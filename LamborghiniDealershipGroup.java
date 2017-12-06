
/**
 * describes a LamborghiniDealershipGroup.
 *
 * @author Aaron
 * @version Dec 4
 */

import java.util.ArrayList;

public class LamborghiniDealershipGroup
{
    // instance variables - replace the example below with your own
    private String                        dealershipGroupName;
    private ArrayList <LamborghiniCarLot> carLots;

    public static final int ZERO = 0;

    /**
     * Default LamborghiniDealershipGroup constructor
     *
     */
    public LamborghiniDealershipGroup()
    {
        carLots = new ArrayList<LamborghiniCarLot>(); //create empty array
    }

    /**
     * LamborghiniDealershipGroup constructor
     * @param dealershipGroupName the name of the dealership group
     *
     */
    public LamborghiniDealershipGroup(String dealershipGroupName)
    {
        // initialise instance variables
        carLots = new ArrayList<LamborghiniCarLot>();
        this.dealershipGroupName = dealershipGroupName;

        //Create the first car lot
        LamborghiniCarLot carlot1 = new LamborghiniCarLot();

        carlot1.setLotName("Jason's vintage lambos.");
        carlot1.addLamborghini(new Lamborghini(1965, "350GT", 365.3, true));
        carlot1.addLamborghini(new Lamborghini(1966, "400GT 2+2", 366.3, false));
        carlot1.addLamborghini(new Lamborghini(1967, "MIURA", 367.3, true));
        carlot1.addLamborghini(new Lamborghini(1968, "espada", 368.3, false));
        carlot1.addLamborghini(new Lamborghini(1969, "islero", 369.3, true));
        carlot1.addLamborghini(new Lamborghini(1970, "jarama", 370.3, false));
        carlot1.addLamborghini(new Lamborghini(1971, "urraco", 371.3, false));
        carlot1.addLamborghini(new Lamborghini(1971, "urraco", 371.3, false));
        carlot1.addLamborghini(new Lamborghini(1973, "countache", 373.3, false));
        carlot1.addLamborghini(new Lamborghini(1974, "silhouette", 374.3, false));
        carlot1.addLamborghini(new Lamborghini(1975, "jalpa", 375.3, true));
        carlot1.addLamborghini(new Lamborghini(1976, "silhouette", 476.3, false));
        carlot1.addLamborghini(new Lamborghini(1977, "silhouette", 377.3, true));
        carlot1.addLamborghini(new Lamborghini(1978, "countache", 478.3, false));
        carlot1.addLamborghini(new Lamborghini(1978, "countache", 578.3, false));
        carlot1.addLamborghini(new Lamborghini(1978, "countache", 378.3, true));
        carlot1.addLamborghini(new Lamborghini(1979, "silhouette", 479.3, false));

        //Create the second car lot
        LamborghiniCarLot carlot2 = new LamborghiniCarLot();

        carlot2.setLotName("Taylor's brand new lambos.");

        carlot2.addLamborghini(new Lamborghini(2006, "gallardo", 506.3, true));
        carlot2.addLamborghini(new Lamborghini(2007, "gallardo", 507.3, true));
        carlot2.addLamborghini(new Lamborghini(2008, "reventon", 308.3, false));
        carlot2.addLamborghini(new Lamborghini(2008, "reventon", 508.3, true));
        carlot2.addLamborghini(new Lamborghini(2009, "gallardo", 409.3, true));
        carlot2.addLamborghini(new Lamborghini(2010, "murcielago", 310.3, false));
        carlot2.addLamborghini(new Lamborghini(2011, "aventador", 411.3, false));
        carlot2.addLamborghini(new Lamborghini(2012, "sesto elemento", 512.3, true));

        //Add them to the arraylist
        carLots.add(carlot1);
        carLots.add(carlot2);        
    }

    /**
     * getter for dealershipGroupName
     * @return the dealershipGroupName
     */
    public String getDealershipGroupName(){
        return dealershipGroupName;
    }

    /**
     * getter for carLots
     * @return the ArrayList carLost
     */
    public ArrayList getCarLots(){
        return carLots;
    }

    /**
     * set method for dealershipGroupName
     * @param newDealershipGroupName the new dealership group name
     */
    public void setDealershipGroupName(String newDealershipGroupName){
        dealershipGroupName = newDealershipGroupName;
    }

    /**
     * set method for ArrayList carLots
     * @param newCarLots the new carLots
     */
    public void setCarLots (ArrayList newCarLots){
        carLots = newCarLots;
    }

    /**
     * adds the carLot provided to the carLots ArrayList
     * @param carLot the carlot to be added to carLots
     */
    public void addCarLot(LamborghiniCarLot carLot){
        if (carLots != null){
            carLots.add(carLot);
        }
    }

    /**
     * counts the number of carLot objects in carLots
     * @return the number of carLot objects in carLots
     */
    public int getTotalInventoryCount(){
        int matches = ZERO;

        if (carLots != null){            
                for(LamborghiniCarLot lot: carLots){
                    matches += lot.getNumberOfCars();                  
                }            
        }

        return matches;   
    }

    /**
     * returns true if the model name exists in any car lot
     * @param modelName the model name of the car, case insensitive
     * @return true for model name exists in any car lot
     */
    public boolean hasModelName(String modelName){
        boolean carExists = false;

        if (carLots != null){            
            for(LamborghiniCarLot lot: carLots){
                if(lot !=null){
                    if (lot.hasCarModel(modelName)){
                        carExists = true;
                        break;
                    }
                }
            } 
        }

        return carExists;
    }

    /**
     * returns an array of all the car lots whos average horsepower for a given year is within the specified range
     * @param modelYear the model year to find the average horsepower for
     * @param lowHP the lower bound of the range
     * @param highHP the upper bound of the range
     * @return an array with of the car lots that meet the parameters
     */
    public LamborghiniCarLot[] getAllCarLotsWithAverageHorsepowerInRangeForYear(int modelYear, double lowHP, double highHP){
        int numberOfMatches = ZERO;
        int y               = ZERO;

        if (carLots != null){
            for (LamborghiniCarLot lot: carLots){
                if (lot != null){
                    if ((lot.getAverageHorsepowerOfYear(modelYear) >= lowHP) && (lot.getAverageHorsepowerOfYear(modelYear) <= highHP)){
                        numberOfMatches++;                        
                    } 
                }
            }
        }

        LamborghiniCarLot[] matches = new LamborghiniCarLot[numberOfMatches];

        if (carLots != null){
            for (LamborghiniCarLot lot: carLots){
                if (lot != null){
                    if ((lot.getAverageHorsepowerOfYear(modelYear) >= lowHP) && (lot.getAverageHorsepowerOfYear(modelYear) <= highHP)){
                        matches[y] = lot;
                        y++;
                    }
                }
            }

        }  
        return matches;
    }
}

