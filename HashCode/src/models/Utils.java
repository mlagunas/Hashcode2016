package models;

public class Utils {

	public static long euclideanDistance(Drone d, Order o) {
		double x = Math.abs(d.getPosition().getX() + o.getCoordinates().getX());
		double y = Math.abs(d.getPosition().getY() + o.getCoordinates().getY());
		x = x * x;
		y = y * y;
		return Math.round(Math.sqrt(x+y));
	}
	
	public static long euclideanDistance(Drone d, Warehouse o) {
		double x = Math.abs(d.getPosition().getX() + o.getCoordinates().getX());
		double y = Math.abs(d.getPosition().getY() + o.getCoordinates().getY());
		x = x * x;
		y = y * y;
		return Math.round(Math.sqrt(x+y));
	}

}
