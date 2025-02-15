//     ##########################
// ## 			   Ex1			  	##
// ##########################


// // Para lidar com prints

// 	public static PrintStream printer; // to avoid duplicated prints in console

// 	public static void main(String[] args) throws FileNotFoundException {
// 		PrintStream fl = new PrintStream(new File("pds2022.txt"));
// 		test(System.out); // executa e escreve na consola
// 		fl.println(System.getProperty("user.dir"));
// 		fl.println(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
// 		test(fl); // executa e escreve no ficheiro
// 		fl.close();
// 	}

// 	private static void test(PrintStream out) {
// 		printer = out;
// 		question1(out);
// 		question2(out);
// 		question3(out);
// 	}
  
// // Nas restantes classes, para fazerem um "print" nao usam o System.out.print(...).
// // Usam antes um XIII1.printer.print(...)



// private static void question2(PrintStream out) {
// 		out.println("\nQuestion 2 (output example) ----------------------------------\n");

// 		ToShare market = new ToShare();

// 		market.setProductsReader(new ProductsReaderHardcodedProducts());
// 		market.importProductsFromProductsReader();

// 		market.setProductsReader(new ProductsReaderFromTXTFile("products.txt")); 
// 		market.importProductsFromProductsReader();

// 		out.println("--- All Products ---\nTotal: " + market.totalProducts());
// 		for (Product item : market)
// 			out.println("\t"+item);
// 	}


// 	private static void question3(PrintStream out) {
// 		out.println("\nQuestion 3) ----------------------------------\n");
// 		// Completar
// 		Client u1 = new Client("187", "Peter Pereira");
// 		Client u2 = new Client("957", "Anne Marques");
// 		Client u3 = new Client("9257", "Anneadsfas Marques");

// 		ToShare shareIt = new ToShare();

// 		Product[] cars = {
// 				new Car("ZA11ZB", "Tesla, Grey, 2021", 100),
// 				new Van("AA22BB", "Chevrolet Chevy, 2020", 180),
// 				new Motorcycle("ZA33ZB", "Touring, 750, 2022", 85),
// 				new Car("BB44ZB", "Ford Mustang, Red, 2021", 150),
// 		};
// 		for (Product item : cars) {
// 			shareIt.add(item);
// 		}

// 		out.println("Shared products: " + shareIt.totalSharedProducts());
// 		shareIt.share("ZA11ZB", u1); 	// true
// 		shareIt.share("ZA11ZB", u2);  	// false (já está emprestada)

// 		out.println("Shared products: " + shareIt.totalSharedProducts());
// 		shareIt.giveBack("ZA11ZB");  	// true
// 		out.println("Shared products: " + shareIt.totalSharedProducts());
// 		shareIt.giveBack("ZA11ZB");  	// true
// 		out.println("Shared products: " + shareIt.totalSharedProducts());
// 	}



// ##########################
// ## 			   Ex2			  	##
// ##########################

// private static void question2(PrintStream out) {
// 		out.println("\nAlínea b) ----------------------------------\n");

// 		ShipOfSmallShips c1 = new ShipOfSmallShips("XX45", "Meio cheio", 6);
// 		c1.add(new PassengerShip("B899", "Bora", 4));
// 		c1.add(new PassengerShip("B878", "Riacho", 2));
// 		c1.add(new PassengerShip("B785", "Turista", 8));
// 		av.add("C01", c1);
// 		av.add("X01", new CargoShip("S45", "Beirão", 81));
// 		out.println(av.remove("C02").name() + " removed");

// 		for (String s : av) {
// 			out.println(s);
// 		}

// 	}

// 	// alínea c)
// 	private static void question3(PrintStream out) {
// 		out.println("\nAlínea c) ----------------------------------\n");

// 		RiverPort p = (RiverPort) PortFactory.getRiverPort();

// 		p.add("C02", new CargoShip("S101", "Quebra Molas", 1.55));
// 		p.add("C11", new CargoShip("S732", "SoPingas", 20.2));
// 		p.add("C03", new CargoShip("S923", "Madalena", 8.8));
// 		p.add("P54", new PassengerShip("S199", "Bananeiros", 5));
// 		p.add("P35", new PassengerShip("S185", "PDS All aboard", 80));
// 		p.add("P06", new PassengerShip("S078", "Costeiro", 9));

// 		p.getRiverLogger().printCurrentLogs();

// 		System.out.println("\nShips:");
// 		Iterator<String> it = p.iterator();
// 		while (it.hasNext()) {
// 			out.println(it.next());
// 		}
// 	}
// }
