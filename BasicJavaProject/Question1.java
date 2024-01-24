import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Quetion1 {	
	public static void main(String[] args) {
		//Creating a HashMap.
		HashMap<Integer, String> frenchToastIngredients = new HashMap<>();
	
		//Inserting data into the HashMap.
		frenchToastIngredients.put(1, "Bread");
		frenchToastIngredients.put(2, "Eggs");
		frenchToastIngredients.put(3, "Milk");
		frenchToastIngredients.put(4, "Butter");
		frenchToastIngredients.put(5, "Honey");
		
		// Printing out the HashMap.
		System.out.println(frenchToastIngredients);
		
		// Finding a specific index as well as printing it out.
		System.out.println(frenchToastIngredients.get(1));
		
		// Removing an element from the HashMap. And printing out the changes.
		frenchToastIngredients.remove(5);
		System.out.println(frenchToastIngredients);
		
		//Creating a Linked List.
		LinkedHashMap<String, String> pokemon = new LinkedHashMap<>();
		
		//Adding elements to the Linked List.
		pokemon.put("Fire", "Charizard");
		pokemon.put("Fighting", "Ratata");
		pokemon.put("Electric", "Pikachu");
		pokemon.put("Ground", "Diglet");
		pokemon.put("Dark", "Ceruledge");
		
		//Printing the Linked List.
		System.out.println(pokemon);
		
	}
	
}