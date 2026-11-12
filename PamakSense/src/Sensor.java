import java.util.ArrayList;
import java.util.Comparator;

public class Sensor {
	private String name;
	private String bluetooth;
	private ArrayList<Sensor> sensorList = new ArrayList<>();
	private Zone zone;
	
	
	public Sensor(String name, String bluetooth) {
		super();
		this.name = name;
		this.bluetooth = bluetooth;
		if(!isValidBluetoothAddress(this.bluetooth))
		{
			System.out.println("Sensor " + this.name + " cannot be created: invalid address");
		}
	}
	
	public boolean isValidBluetoothAddress(String address)
	{
		return address.matches("([0-9A-F]{2}:){5}[0-9A-F]{2}");
	}


	public String getName() {
		return name;
	}


	public String getBluetooth() {
		return bluetooth;
	}


	public Zone getZone() {
		return zone;
	}


	public ArrayList<Sensor> getSensorList() {
		return sensorList;
	}


	public void setZone(Zone zone) {
		this.zone = zone;
	}
	
	public boolean isConnectedTo (Sensor sensor)
	{
		for(int i=0; i<sensorList.size(); i++)
		{
			if(sensorList.get(i).equals(sensor) && !sensor.equals(this))
			{
				return true;
				
			}
			
		}
		
		return false;
	}
	
	public void connectTo(Sensor sensor)
	{
		
		if(sensor.equals(this)) {
			System.out.println("Error: " + sensor.getName() + " cannot connect to itself");
		}
		
		if(sensor.isConnectedTo(this)) {
			System.out.println("Error: " + name + " is already connected to " + sensor.getName());
		}
		
		if(!sensor.equals(this) && !sensor.isConnectedTo(this))
		{
			sensorList.add(sensor);
			sensor.sensorList.add(this);
			System.out.println(name + " is now connected to " + sensor.getName());
		}
	}
	
	
	public void returnCommonConnections(Sensor sensor)
	{
		ArrayList<Sensor> cs = new ArrayList<>();
		
		for(int i=0; i<sensorList.size(); i++)
		{
			for(int j=0; j<sensor.sensorList.size(); j++)
			{
				if(sensor.sensorList.get(j).equals(sensorList.get(i)))
				{
					cs.add(sensorList.get(i));
				}
			}
		}
		
		System.out.println("Common connections of " + name + " and " + sensor.getName() + ":");
		for(int i=0; i<cs.size(); i++)
		{
			System.out.println(cs.get(i).getName() + " (" + cs.get(i).getBluetooth() + ")");
		}
		
		System.out.println("----------------------------------------------------");
		
		System.out.println("****************************************************");
	}
	
	
	public void printConnections()
	{
		System.out.println("Connections of " + name + ":");
		for(int i=0; i<sensorList.size(); i++)
		{
			System.out.println(sensorList.get(i).getName() + " (" + sensorList.get(i).getBluetooth() + ")" );
		}
		
		System.out.println("----------------------------------------------------");
		
	}
	
	public void wasPlacedTo()
	{
		System.out.println(name + " was placed in " + this.getZone().getName());
	}
	
	public void getNeighbours()
	{
		ArrayList<Sensor> neighboursList = new ArrayList<>();
		
		for(int i=0; i<sensorList.size(); i++)
		{
			if(!sensorList.get(i).getSensorList().isEmpty())
			{
				for(int j=0; j<sensorList.get(i).getSensorList().size(); j++)
				{
					if(!neighboursList.contains(sensorList.get(i).getSensorList().get(j)) && !this.equals(sensorList.get(i).getSensorList().get(j)))
					{
						neighboursList.add(sensorList.get(i).getSensorList().get(j));
					}
				}
			}
		}
		
		for(int i=0; i<sensorList.size(); i++)
		{
			neighboursList.add(sensorList.get(i));
		}
		
		neighboursList.sort(Comparator.comparing(Sensor::getName));
		
		System.out.println("Neighbors of " + this.getName() + " (up to 2 distance):");
		
		for(int i=0; i<neighboursList.size(); i++)
		{
			System.out.println(neighboursList.get(i).getName() + " (" + neighboursList.get(i).getBluetooth() + ") ");
		}
		
		System.out.println("----------------------------------------------------");
	}

}
