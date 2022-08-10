import java.util.*;

class Planets{

    public String Name;
    public String [] Gases;
    public int Moons;
    public boolean Rings;

    public Planets(String name, String [] gases, int moons, boolean rings){
        Name = name;
        Gases = gases;
        Moons = moons;
        Rings = rings;
    }

    public static void ReturnMoons(Planets [] planets){
        for(Planets p : planets){
            if(p.Rings){
                System.out.println("Name : " + p.Name + ", Moons : " + p.Moons);
            }
        }
    }

    public static void MaxGasFound(Planets [] planets){
        Map<String,Integer> hm = new HashMap<String,Integer>();
        for(Planets p : planets){
            for(String g : p.Gases){
                if(hm.containsKey(g)){
                    hm.put(g, hm.get(g) + 1);
                }
                else{
                    hm.put(g,1);
                }
            }
        }
        int maxplanets = Collections.max(hm.values());
        for(Map.Entry entry : hm.entrySet()){
            if((int)entry.getValue() == maxplanets){
                System.out.println("Gas name : " + entry.getKey() + " , Found on no. of planets : " + entry.getValue());
            }
        }
    }

    public static void main (String [] args){
        Planets Mercury = new Planets("Mercury", new String [] {},0, false);
        Planets Venus = new Planets("Venus", new String [] {"Carbon Dioxide", "Nitrogen"}, 0, false);
        Planets Earth = new Planets("Earth", new String[] {"Nitrogen", "Oxygen"}, 1, false);
        Planets Jupitor = new Planets("Jupitor", new String[] {"Hydrogen" , "Helium"}, 79, true);
        Planets Saturn = new Planets("Saturn", new String [] {"Hydrogen" , "Helium"}, 83, true);
        Planets Uranus = new Planets("Uranus", new String[] {"Hydrogen" , "Helium" , "Methane"}, 27, true);

        Planets [] planets = new Planets[] {Mercury, Venus, Earth, Jupitor, Saturn, Uranus};

        Planets.ReturnMoons(planets);
        Planets.MaxGasFound(planets);

    }
}