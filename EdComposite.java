package patterns;

import java.util.ArrayList;
import java.util.Iterator;

public class EdComposite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompositeTester cT = new CompositeTester();
		cT.runCompositeTest();

	}

}

class CompositeTester {
	
	public void runCompositeTest() {
		MenuComponent pancakeHouse = new Menu("PK MENU", "Breakfast");
		MenuComponent sunDiner = new Menu("DINER MENU", "Lunch");
		MenuComponent topCafe = new Menu("CAFE MENU", "Supper");
		MenuComponent dessertMenu = new Menu("SWEETS MENU", "Desserts");

		MenuComponent allMenus = new Menu("ALL MENUS", "Three Restos");
		allMenus.add(pancakeHouse);
		allMenus.add(sunDiner);
		allMenus.add(topCafe);

		pancakeHouse.add(new MenuItem("3Coins","Pancakes",true,10.00));
		sunDiner.add(new MenuItem("Pasta","Spaghetti",true,15.00));
		topCafe.add(new MenuItem("Steak","Ribeye",true,20.00));
		dessertMenu.add(new MenuItem("Ice Cream","Shake",true,5.00));
		sunDiner.add(dessertMenu);
		
		Waitress wt = new Waitress(allMenus);
		wt.printMenu();
		
	}
	
}

class Waitress {
	MenuComponent allMyMenus;
	public Waitress (MenuComponent mc) {
		this.allMyMenus = mc;
	}
	void printMenu() {
		allMyMenus.print();
	}
	
}

abstract class MenuComponent {
	void add(MenuComponent menuComponent) {
		throw new UnsupportedOperationException();
	}
	void remove(MenuComponent menuComponent) {
		throw new UnsupportedOperationException();
	}
	String getName() {
		throw new UnsupportedOperationException();
	}
	String getDescription() {
		throw new UnsupportedOperationException();
	}
	double getPrice() {
		throw new UnsupportedOperationException();
	}
	boolean isVegetarian() {
		throw new UnsupportedOperationException();
	}
	void print() {
		throw new UnsupportedOperationException();
	}
}

class MenuItem extends MenuComponent {
	String name;
	String description;
	boolean vegetarian;
	double price;

	public MenuItem(String name, String description, boolean vegetarian, double price) {
		this.name = name;
		this.description = description;
		this.vegetarian = vegetarian;
		this.price = price;

	}

	String getName() {
		return name;
	}

	String getDescription() {
		return description;
	}

	boolean isVegetarian() {
		return vegetarian;
	}

	double getPrice() {
		return price;
	}
	
	void print() {
		String veg;
		if (isVegetarian() ) {
			veg = "(v)";	
		} else {
			veg = "   ";	

		}
		System.out.println(veg + " " + getName() + ", " + getPrice() + " -- " + getDescription());
	}

}

class Menu extends MenuComponent {
	ArrayList<MenuComponent> menuComponents = new ArrayList<>();
	String name;
	String description;
	
	public Menu(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	void add(MenuComponent menuComponent) {
		menuComponents.add(menuComponent);
	}
	void remove(MenuComponent menuComponent) {
		menuComponents.remove(menuComponent);
	}
	MenuComponent getChild(int i) {
		return menuComponents.get(i);
	}
	String getName() {
		return name;
	}

	String getDescription() {
		return description;
	}
	void print() {
		System.out.println(" " + getName() + ", " + getDescription());
		Iterator<MenuComponent> it = menuComponents.iterator();
		while (it.hasNext()) {
			MenuComponent mc = (MenuComponent)it.next();
			mc.print();
		}
		
	}


}