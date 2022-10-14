import java.util.HashMap;
import java.util.Map;
import java.util.Scanner; 

//Item Class
class Item
{
	int itemId;
	String itemName;
	String description;
	double price;
	
	Item(int itemId,String name, String description, double price)
	{
		this.itemId = itemId;
		this.itemName = name;
		this.description = description;
		this.price = price;
	}
	
}

//Cart Class
class Cart
{
	
	Map<Item, Integer> hash_map = new HashMap<Item, Integer>();
	
	// Adding the item into Cart
	void addToCart(Item item,int quantity)
	{
		hash_map.put(item, quantity);
	}
	
	// Displaying the Quantity of the Item 
	int displayQuantity(Item item)
	{
		int quantity=0;
		
		if(hash_map.get(item)!=null)
		{
			quantity = hash_map.get(item);
		}
		else
		{
			System.out.print("The Item is not present in the Cart: ");
		}
		return quantity;
	}
	
	// Updating the Quantity of the Item
	void updateQuantity(Item item,int quantity)
	{

		if(hash_map.get(item)!=null)
		{
			hash_map.put(item,quantity);
		}
		else
		{
			System.out.print("The Item is not present in the Cart: ");
		}
	}
	
	// Deleting the Item from the Cart
	void deleteItem(Item item)
	{
		if(hash_map.get(item)!=null)
		{
			hash_map.remove(item);
		}
		else
		{
			System.out.print("The Item is not present in the Cart: ");
		}
	}
	
	// Total Cart Items Price
	double cartTotalValue(Item item)
	{
		double sum=0;

		for (Map.Entry<Item, Integer> set : hash_map.entrySet()) {
			sum = sum + (set.getKey().price)*(set.getValue());
		}
		return sum;
	}
}

//Main Class
class ShoppingCart
{
	public static void main(String[] args)
	{
		double totalValue=0;
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Shopping Cart");

			Cart vishal = new Cart();
			
			Item item1 = new Item(1,"laptop","this is a laptop",40000.0);
			
			vishal.addToCart(item1,2);
			
			int quant = vishal.displayQuantity(item1);
			
			System.out.println("Item1 Quantity "+quant);
			
			Item item2 = new Item(2,"computer","this is a computer",20000.0);
			
			vishal.addToCart(item2,3);
			
			int quant2 = vishal.displayQuantity(item2);
			
			System.out.println("Item2 Quantity "+quant2);
			
			Item item3 = new Item(1,"laptop","this is a laptop",40000.0);
			vishal.addToCart(item3,2);
			
			totalValue = totalValue + vishal.cartTotalValue(item2);
			System.out.println("Total Cart Value "+totalValue);
			
			
			vishal.updateQuantity(item1,1);
			
			int quant21 = vishal.displayQuantity(item1);
  		    System.out.println("Updated Quantity Of Item1 "+quant21);
			
			vishal.deleteItem(item1);
			System.out.println("After Deleting the Item1");
			int quant4 = vishal.displayQuantity(item1);
			System.out.println("Quantity "+quant4);
			
		}
		
			
	}
}