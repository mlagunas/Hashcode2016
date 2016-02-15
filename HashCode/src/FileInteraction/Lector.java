package FileInteraction;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import models.Coordinates;
import models.Drone;
import models.Order;
import models.Product;
import models.Warehouse;

public class Lector {
	
	ArrayList<models.Drone> drones=null;
	public static int rows;
	public static int cols;
	public static int numDrones;
	public static int numTurns;
	public static int payLoad;
	
	public static int numOrders;
	
	public static int productTypes;
	public static ArrayList<Integer> listProducts = new ArrayList<Integer>();
	public static ArrayList<Drone> listDrone = new ArrayList<>();
	public static ArrayList<Warehouse> listWarehouse = new ArrayList<>();
	public static ArrayList<Order> listOrders = new ArrayList<>();
	
	
	
	public static void main (String[] args){
		lectura("C:/Users/Familia Serrano/Downloads/mother_of_all_warehouses.in");
		
	}
	
	public static void lectura (String path){
		
		File f = new File(path);
		Scanner s = null;
			try {
				s = new Scanner(f);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int type=-1;
			boolean firstLine=true;
				if(firstLine){
					rows=s.nextInt();
					System.out.println("rows: "+rows);
					cols=s.nextInt();
					System.out.println("cols: "+rows);
					numDrones=s.nextInt();
					System.out.println("drones: "+numDrones);
					numTurns=s.nextInt();
					System.out.println("turns: "+numTurns);
					payLoad=s.nextInt();
					System.out.println("payLoad: "+payLoad);
					firstLine=false;
					s.nextLine();
				}
				
				productTypes=s.nextInt();
				System.out.println("types: "+productTypes);
				s.nextLine();
				for (int i=0;i<productTypes;i++){
					listProducts.add(s.nextInt());
				}	
				System.out.println(listProducts.toString());
				s.nextLine();
				
				int numWarehouses=0;
				numWarehouses=s.nextInt();
				System.out.println("numware: "+numWarehouses);
				s.nextLine();
				
				for(int i=0;i<numWarehouses;i++){
							Coordinates coord=  new Coordinates(s.nextInt(),s.nextInt());
							s.nextLine();
							ArrayList<Product> prodsW= new ArrayList<Product>();
							for (int j=0; j<listProducts.size();j++){
								Product p = new Product(j,s.nextInt(),listProducts.get(j));
								prodsW.add(p);
							}
							Warehouse w = new Warehouse(coord,prodsW);
							listWarehouse.add(w);
							s.nextLine();
				}	
				System.out.println(listWarehouse.toString());
				
				numOrders=s.nextInt();
				System.out.println("NUM ORDERS: "+numOrders);
				s.nextLine();
				
				for (int i=0;i<numOrders;i++){
					Coordinates delivCoords= new Coordinates(s.nextInt(),s.nextInt());
					s.nextLine();
					int itemsOrder=s.nextInt();
					System.out.println("itemsOrder: "+itemsOrder);
					s.nextLine();
					HashMap<Integer, Product> MapOrder = new HashMap<Integer,Product>();
					int items =0;
					String orderLine=s.nextLine();
					Scanner sc = new Scanner(orderLine);
					while(sc.hasNextInt()){
						System.out.println("item "+items);
						int typ=sc.nextInt();
						items++;
						if(MapOrder.get(typ)==null){
							MapOrder.put(typ, new Product(typ,1,listProducts.get(typ)));
						}
						else{
							MapOrder.get(typ).put(1);
						}
					}
					ArrayList<Product> arrayProducts=new ArrayList<Product>(MapOrder.values());
					Order ord= new Order(delivCoords,arrayProducts);
					System.out.println("ORDER "+ord);
					listOrders.add(ord);
				}
				System.out.println("orders: "+listOrders.toString());
				
			}

	

}
