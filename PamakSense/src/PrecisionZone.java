import java.util.ArrayList;

public class PrecisionZone extends Zone{
	private ArrayList<Sensor> precisionZoneSensors = new ArrayList<>();
	
	public PrecisionZone(String name, String description) {
		super(name, description);
	}
	
	public void addSensor(Sensor sensor) {
		if(sensor.getName().startsWith("Precise_"))
		{
			Zone zone = sensor.getZone();
			if(zone!=null)
			{
				zone.getSensors().remove(sensor);
			}
			precisionZoneSensors.add(sensor);
			sensor.setZone(this);
			sensor.wasPlacedTo();
		}
		else 
		{
			System.out.println("Error: " + sensor.getName() + " cannot be placed in zone " + this.getName());
		}
	}
	
	public void printSensors()
	{
		int size = precisionZoneSensors.size();
		System.out.println("Zone " + name + " contains " + size + " sensors: ");
		for(int i=0; i<size; i++ )
		{
			System.out.println(precisionZoneSensors.get(i).getName() + " (" + precisionZoneSensors.get(i).getBluetooth() + ")" );
		}
		
		System.out.println("----------------------------------------------------");
	}

}
