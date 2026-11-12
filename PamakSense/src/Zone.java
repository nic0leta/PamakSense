import java.util.ArrayList;

public class Zone {
	protected String name;
	protected String description;
	private ArrayList<Sensor> sensors = new ArrayList<>();
	
	public Zone(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
	
	
	public ArrayList<Sensor> getSensors() {
		return sensors;
	}

	public void addSensor(Sensor sensor) {
		Zone zone = sensor.getZone();
		if(zone!=null)
		{
			zone.getSensors().remove(sensor);
		}
		sensors.add(sensor);
		sensor.setZone(this);
		sensor.wasPlacedTo();
	}
	
	public void printSensors()
	{
		int size = sensors.size();
		System.out.println("Zone " + name + " contains " + size + " sensors: ");
		for(int i=0; i<size; i++ )
		{
			System.out.println(sensors.get(i).getName() + " (" + sensors.get(i).getBluetooth() + ")" );
		}
		
		System.out.println("----------------------------------------------------");
	}
}
