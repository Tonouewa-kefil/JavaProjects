public class Employee 
{
	private String ID ="" ;//employee ID
    private String Name = "";//employee Name
    private double HOURS=0;//HOURS
    
    //Employee Constructor
    public Employee(String Id, String Ename,double H) 
    {
        this.ID =    Id;
        this.Name = Ename;  
        this.HOURS= H;
    }
    
    //Setting employee name
    public void setName(String Name) 
    {
    	this.Name=Name;
    }
    
    //Setting ID
    public void setID(String ID) 
    {
    	this.ID=ID;
    }
    
    //Getting ID
    public String getID() {
        return ID;
    }
    
    //Getting Hour
    public double getHour() {
        return HOURS;
    }
    
    //Getting Name
    public String getName()  {
        return Name;
    }
    
    //Setting Hours
    public void setHours(double diff) 
    {
    	HOURS=HOURS+diff;
    	
    	
    }
}
