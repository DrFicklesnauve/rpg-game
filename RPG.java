import java.util.Scanner;
import java.util.Random;

public class RPG {
	
	public static void main(String[] args) {
		
		String response = "Y";
		Boolean hasCoin = false;
		int gachaExp;
		
		// Creates scanner/stat objects
		Scanner keyboard = new Scanner(System.in);
		lunaStats luna = new lunaStats();
		friarRexStats friar = new friarRexStats();
		
		// Create random object
		Random rand = new Random();
		
		System.out.println("Luna is a brand new adventurer who for the first time in \n"
				+ "her life is leaving the safety of her home to pursue a life of adventure. \n"
				+ "While walking through the woods she notices two mischevious looking Gooblins \n"
				+ "and to her they seem to be up to no good.\n\n"
				+ "\"HEY! What do you think you two are doing in my woods?\"\n\n"
				+ "The Gooblins look at each other confused. One gets ready to explain but it is too late...\n\n"
				+ "\"ATTACK!!!\"");
		gooblinStats(keyboard, luna, friar);
		gooblinStats(keyboard, luna, friar);
		
		hasCoin = getCoin(keyboard, response);
		
		takeRest(response, keyboard, luna, friar);
		System.out.println("You sit down and rest. \nHP is now full. \n");
		
		System.out.print("Feeling accomplished leaving behind the unconscious bodies of two Gooblins she failed to interrogate\n"
				+ "Luna takes a path that leads to lone casino in the middle of the woods.\n"
				+ "A rather peculiar place for a casino but she enters nonetheless.\n"
				+ "She passes slot machines, blackjack, and poker tables and finds a decrepit old\n"
				+ "toy machine with a sign on it that says \"For Kids.\" Would you like to enter the coin? (Y/N)");
		response = keyboard.nextLine();
		if (response.toUpperCase().equals("Y")) {
			System.out.print("She decides to try it out using the coin she found in the woods. ");
			gachaExp = getGachaPrize(rand, friar, hasCoin);
			levelUp(gachaExp, luna, friar);
		} 
		
		System.out.println("Running around touching everything Luna is searching out for a new villain to vanquish\n\n"
				+ "\"Excuse me where are your parents?\"\n\n"
				+ "An employee, named Jeanna, from the casino who looks like she long ago stopped caring about her job asked.\n"
				+ "Luna decided she, while not the perfect candidate, would have to do.");
		secondBattleMethod(keyboard, luna, friar);
		
		takeRest(response, keyboard, luna, friar);
		System.out.println("You sit down and rest. \nHP is now full. \n");
		
		System.out.println("After being thrown out by security, Luna now decides to find adventure elsewhere.\n"
				+ "While wandering she comes across an unaturally tall, lanky man with a permanant grin picking flowers.\n\n"
				+ "\"Hey, do you know where I can find some jerks to beat?\"\n\n"
				+ "Luna asks the man but receives no reply as he continues to smile go about his flower picking business.\n\n"
				+ "\"Man you are real creepy with your smile, people like you shouldn't have teeth to smile with.\"");
		horkyDorkyStats(keyboard, luna, friar);
		
		takeRest(response, keyboard, luna, friar);
		System.out.println("You sit down and rest. There are shards of teeth all over. \nHP is now full. \n");
		
		System.out.println("Luna brushes the teeth from her clothes and turns to continue on her adventure but is\n"
				+ "immediately stopped.\n\n \"You've been causing problems for all of the people of this town, I'm taking you in.\"\n\n"
				+ "Said the constable of the town know only as, The Constable."
				+ "\"No u.\"\n\n Luna cleverly retorted.");
		fourthBattleMethod(keyboard, luna, friar);
		
		System.out.println("And so our lead faces no repercussions for her actions because injustices exist in this world.\n"
				+ "The End.");
			
		keyboard.close();
		System.exit(0);
	}
	
	// 1st Battle
	public static void gooblinStats(Scanner keyboard, lunaStats luna, friarRexStats friar) {
		int hp = 50;
		int attack = 10;
		int defense = 10;
		int expOut = 50;
		String intro = "The Gooblin takes a step back. \n";
		String enemyName = "Gooblin";
		
		battleMethod(hp, attack, defense, expOut, intro, enemyName, keyboard, luna, friar);
	}
	
	// 3rd Battle
	public static void horkyDorkyStats(Scanner keyboard, lunaStats luna, friarRexStats friar) {
		int hp = 200;
		int attack = 10;
		int defense = 15;
		int expOut = 50;
		String intro = "Horky Dorky lopes up. ";
		String enemyName = "Horky Dorky";
		
		battleMethod(hp, attack, defense, expOut, intro, enemyName, keyboard, luna, friar);
	}
	
	public static void battleMethod(int enemyHp, int enemyAttack, int enemyDefense, int enemyExpOut, 
			String intro, String enemyName, Scanner keyboard, lunaStats luna,
			friarRexStats friar) {
		
		Random rand = new Random();
		
		System.out.println(intro);
		
		while (enemyHp > 0 && luna.getLunaHp() > 0) {
			int number = 8, number2 = 9, healNumber = 7, healNumber2 = 6;

			
			System.out.print("Luna's HP: " + luna.getLunaHp() + "\t\t");
			if (friar.getIfFriarRex() == true) {
				System.out.print("Friar Rex's HP: " + friar.getfriarRexHp());
			}
			System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println(enemyName + " HP: " + enemyHp + "\n");
			
				
			// TODO find a way to write it so that if you put in letters it defaults

			while (number != 1 && number != 2 && number != 3) {
				System.out.print("Press 1 to have Luna attack, 2 to defend, or 3 to heal. ");
				number = Integer.parseInt(keyboard.nextLine());
					
				switch (number) {
					case 1:	
						System.out.println("You have attacked " + enemyName + " for " + 
								(luna.getLunaAttack() - (enemyDefense / 2)) + " damage.");
						enemyHp -= luna.getLunaAttack() - (enemyDefense / 2);
						break;
					case 2:	
						System.out.println("You have defended.");
						break;
					
						case 3:
							if (friar.getIfFriarRex() == true) {
								System.out.println("Press 1 to heal Luna or 2 to heal Friar Rex");
								healNumber = Integer.parseInt(keyboard.nextLine());
								
								switch (healNumber) {
									case 1:
										if (luna.getLunaHp() < luna.getLunaMaxHp() && (luna.getLunaHp() + friar.getfriarRexHeal()) <= luna.getLunaMaxHp()) {
											System.out.println("Luna healed herself.");
											luna.setLunaHp(luna.getLunaHp() + luna.getLunaHeal());
										} else if (luna.getLunaHp() < luna.getLunaMaxHp() && (luna.getLunaHp() + luna.getLunaHeal()) > luna.getLunaMaxHp()) {
											luna.setLunaHp(luna.getLunaMaxHp());
											System.out.println("Luna healed herself");
										} else {
											System.out.println("You do not need to heal.");
										}
										break;
									case 2:
										if (friar.getfriarRexHp() < friar.getfriarRexMaxHp() && (friar.getfriarRexHp() + luna.getLunaHeal()) <= friar.getfriarRexMaxHp()) {
											System.out.println("Luna healed Friar Rex.");
											friar.setfriarRexHp(friar.getfriarRexHp() + luna.getLunaHeal());
										} else if (friar.getfriarRexHp() < friar.getfriarRexMaxHp() && (friar.getfriarRexHp() + luna.getLunaHeal()) > friar.getfriarRexMaxHp()) { 
											friar.setfriarRexHp(friar.getfriarRexMaxHp());
											System.out.println("Luna healed Friar Rex.");
										} else {
											System.out.println("You do not need to heal.");
										}
										break;
									default: 
										System.out.println("Please enter a proper input.\n");
										break;
								}
								break;
					} else {
						if (luna.getLunaHp() < luna.getLunaMaxHp() && (luna.getLunaHp() + friar.getfriarRexHeal()) <= luna.getLunaMaxHp()) {
							System.out.println("Luna healed herself.");
							luna.setLunaHp(luna.getLunaHp() + luna.getLunaHeal());
						} else if (luna.getLunaHp() < luna.getLunaMaxHp() && (luna.getLunaHp() + luna.getLunaHeal()) > luna.getLunaMaxHp()) {
							luna.setLunaHp(luna.getLunaMaxHp());
							System.out.println("Luna healed herself");
						} else {
							System.out.println("You do not need to heal.");
						}
					}
					}
				System.out.print("\n");
				
				if (friar.getIfFriarRex() == true && enemyHp > 0 && friar.getfriarRexHp() > 0) {
					System.out.print("Press 1 for Friar Rex to attack, 2 to defend, or 3 to heal. ");
					number2 = Integer.parseInt(keyboard.nextLine());
						
					switch (number2) {
						case 1:	
							System.out.println("Friar Rex has attacked " + enemyName + " for " + 
									(friar.getfriarRexAttack() - (enemyDefense / 2)) + " damage.");
							enemyHp -= friar.getfriarRexAttack() - (enemyDefense / 2);
							break;
						case 2:	
							System.out.println("Friar Rex defended.");
							break;
						case 3:
							System.out.println("Press 1 to heal Luna or 2 to heal Friar Rex");
							healNumber2 = Integer.parseInt(keyboard.nextLine());
							
							switch (healNumber2) {
								case 1:
									if (luna.getLunaHp() < luna.getLunaMaxHp() && (luna.getLunaHp() + friar.getfriarRexHeal()) <= luna.getLunaMaxHp()) {
										System.out.println("Friar Rex healed Luna.");
										luna.setLunaHp(luna.getLunaHp() + friar.getfriarRexHeal());
									} else if (luna.getLunaHp() < luna.getLunaMaxHp() && (luna.getLunaHp() + friar.getfriarRexHeal()) > luna.getLunaMaxHp()) {
										luna.setLunaHp(luna.getLunaMaxHp());
										System.out.println("Friar Rex healed Luna.");
									} else {
										System.out.println("You do not need to heal.");
									}
									break;
								case 2:
									if (friar.getfriarRexHp() < friar.getfriarRexMaxHp() && (friar.getfriarRexHp() + friar.getfriarRexHeal() <= friar.getfriarRexMaxHp())) {
										System.out.println("Friar Rex healed himself.");
										friar.setfriarRexHp(friar.getfriarRexExp() + friar.getfriarRexHeal());
									} else if (friar.getfriarRexHp() < friar.getfriarRexMaxHp() && (friar.getfriarRexHp() + friar.getfriarRexHeal()) > friar.getfriarRexMaxHp()) {
										friar.setfriarRexHp(friar.getfriarRexMaxHp());
										System.out.println("Friar Rex healed himself.");
									} else {
										System.out.println("You do not need to heal.");
									}
									break;
								default: 
									System.out.println("Please enter a proper input.\n");
									break;
							}
							break;
					}
				}
			}
			System.out.print("\n");
				
			int random;
			if (friar.getIfFriarRex() == true) {
				random = rand.nextInt(2);	
			} else {
				random = 0;
			}

			if (enemyHp > 0 && random == 0) {
				if (number == 2) {
					System.out.println(enemyName + " attacked! " + ((enemyAttack / 2) - 
							(luna.getLunaDefense() / 2)) + " damage to Luna.\n");
					luna.setLunaHp(luna.getLunaHp() - ((enemyAttack / 2) - (luna.getLunaDefense() / 2)));
				} else {
					System.out.println(enemyName + " attacked! " + (enemyAttack  - 
							(luna.getLunaDefense() / 2)) + " damage to Luna.\n");
					luna.setLunaHp(luna.getLunaHp() - (enemyAttack - (luna.getLunaDefense() / 2 )));
				}
			} else if (enemyHp > 0 && random == 1) {
				if (number2 == 2) {
					System.out.println(enemyName + " attacked! " + ((enemyAttack / 2) - 
							(friar.getfriarRexDefense() / 2)) + " damage to Friar Rex.\n");
					friar.setfriarRexHp(friar.getfriarRexHp() - ((enemyAttack / 2) - (friar.getfriarRexDefense() / 2)));
				} else {
					System.out.println(enemyName + " attacked! " + (enemyAttack  - 
							(friar.getfriarRexDefense() / 2)) + " damage to Friar Rex.\n");
					friar.setfriarRexHp(friar.getfriarRexHp() - (enemyAttack - (friar.getfriarRexDefense() / 2)));
				}
			}
		} 
		
		
		if (enemyHp <= 0) {
			System.out.println("\nYou defeated " + enemyName + "!\n");
			levelUp(enemyExpOut, luna, friar);
		} else if (luna.getLunaHp() <= 0) {
			System.out.println("Luna's health is " + luna.getLunaHp());
			System.out.print("How could you let this happen...");
			System.exit(0);
		}
	} 
	
	// end of battleMethod
	
	public static void secondBattleMethod(Scanner keyboard, lunaStats luna,
			friarRexStats friar) {
		int enemyHp = 125, enemyAttack = 15, enemyDefense = 10, enemyExpOut = 200, enemyHeal = 25;
		int counter = 1;
		String intro = "Jeanna rolls her eyes at you.";
		String enemyName = "Jeanna";
		Random rand = new Random();
		
		System.out.println(intro);
		
			while (enemyHp > 0 && luna.getLunaHp() > 0) {
				int number = 8, number2 = 9, healNumber = 7, healNumber2 = 6;
	
				
				System.out.print("Luna's HP: " + luna.getLunaHp() + "\t\t");
				if (friar.getIfFriarRex() == true) {
					System.out.print("Friar Rex's HP: " + friar.getfriarRexHp());
				}
				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println(enemyName + " HP: " + enemyHp + "\n");
				
					
				// TODO find a way to write it so that if you put in letters it defaults
	
				while (number != 1 && number != 2 && number != 3) {
					System.out.print("Press 1 to have Luna attack, 2 to defend, or 3 to heal. ");
					number = Integer.parseInt(keyboard.nextLine());
						
					switch (number) {
						case 1:	
							System.out.println("You have attacked " + enemyName + " for " + 
									(luna.getLunaAttack() - (enemyDefense / 2)) + " damage.");
							enemyHp -= luna.getLunaAttack() - (enemyDefense / 2);
							break;
						case 2:	
							System.out.println("You have defended.");
							break;
						case 3:
							if (friar.getIfFriarRex() == true) {
								System.out.println("Press 1 to heal Luna or 2 to heal Friar Rex");
								healNumber = Integer.parseInt(keyboard.nextLine());
								
								switch (healNumber) {
									case 1:
										if (luna.getLunaHp() < luna.getLunaMaxHp() && (luna.getLunaHp() + friar.getfriarRexHeal()) <= luna.getLunaMaxHp()) {
											System.out.println("Luna healed herself.");
											luna.setLunaHp(luna.getLunaHp() + luna.getLunaHeal());
										} else if (luna.getLunaHp() < luna.getLunaMaxHp() && (luna.getLunaHp() + luna.getLunaHeal()) > luna.getLunaMaxHp()) {
											luna.setLunaHp(luna.getLunaMaxHp());
											System.out.println("Luna healed herself");
										} else {
											System.out.println("You do not need to heal.");
										}
										break;
									case 2:
										if (friar.getfriarRexHp() < friar.getfriarRexMaxHp() && (friar.getfriarRexHp() + luna.getLunaHeal()) <= friar.getfriarRexMaxHp()) {
											System.out.println("Luna healed Friar Rex.");
											friar.setfriarRexHp(friar.getfriarRexHp() + luna.getLunaHeal());
										} else if (friar.getfriarRexHp() < friar.getfriarRexMaxHp() && (friar.getfriarRexHp() + luna.getLunaHeal()) > friar.getfriarRexMaxHp()) { 
											friar.setfriarRexHp(friar.getfriarRexMaxHp());
											System.out.println("Luna healed Friar Rex.");
										} else {
											System.out.println("You do not need to heal.");
										}
										break;
									default: 
										System.out.println("Please enter a proper input.\n");
										break;
								}
								break;
					} else {
						if (luna.getLunaHp() < luna.getLunaMaxHp() && (luna.getLunaHp() + friar.getfriarRexHeal()) <= luna.getLunaMaxHp()) {
							System.out.println("Luna healed herself.");
							luna.setLunaHp(luna.getLunaHp() + luna.getLunaHeal());
						} else if (luna.getLunaHp() < luna.getLunaMaxHp() && (luna.getLunaHp() + luna.getLunaHeal()) > luna.getLunaMaxHp()) {
							luna.setLunaHp(luna.getLunaMaxHp());
							System.out.println("Luna healed herself");
						} else {
							System.out.println("You do not need to heal.");
						}
					}
					}
					System.out.print("\n");
					
					if (friar.getIfFriarRex() == true && enemyHp > 0 && friar.getfriarRexHp() > 0) {
						System.out.print("Press 1 for Friar Rex to attack, 2 to defend, or 3 to heal. ");
						number2 = Integer.parseInt(keyboard.nextLine());
							
						switch (number2) {
							case 1:	
								System.out.println("Friar Rex has attacked " + enemyName + " for " + 
										(friar.getfriarRexAttack() - (enemyDefense / 2)) + " damage.");
								enemyHp -= friar.getfriarRexAttack() - (enemyDefense / 2);
								break;
							case 2:	
								System.out.println("Friar Rex defended.");
								break;
							case 3:
								System.out.println("Press 1 to heal Luna or 2 to heal Friar Rex");
								healNumber2 = Integer.parseInt(keyboard.nextLine());
								
								switch (healNumber2) {
									case 1:
										if (luna.getLunaHp() < luna.getLunaMaxHp() && (luna.getLunaHp() + friar.getfriarRexHeal()) <= luna.getLunaMaxHp()) {
											System.out.println("Friar Rex healed Luna.");
											luna.setLunaHp(luna.getLunaHp() + friar.getfriarRexHeal());
										} else if (luna.getLunaHp() < luna.getLunaMaxHp() && (luna.getLunaHp() + friar.getfriarRexHeal()) > luna.getLunaMaxHp()) {
											luna.setLunaHp(luna.getLunaMaxHp());
											System.out.println("Friar Rex healed Luna.");
										} else {
											System.out.println("You do not need to heal.");
										}
										break;
									case 2:
										if (friar.getfriarRexHp() < friar.getfriarRexMaxHp() && (friar.getfriarRexHp() + friar.getfriarRexHeal() <= friar.getfriarRexMaxHp())) {
											System.out.println("Friar Rex healed himself.");
											friar.setfriarRexHp(friar.getfriarRexExp() + friar.getfriarRexHeal());
										} else if (friar.getfriarRexHp() < friar.getfriarRexMaxHp() && (friar.getfriarRexHp() + friar.getfriarRexHeal()) > friar.getfriarRexMaxHp()) {
											friar.setfriarRexHp(friar.getfriarRexMaxHp());
											System.out.println("Friar Rex healed himself.");
										} else {
											System.out.println("You do not need to heal.");
										}
										break;
									default: 
										System.out.println("Please enter a proper input.\n");
										break;
								}
								break;
						}
					}
				}
				System.out.print("\n");
					
				int random;
				if (friar.getIfFriarRex() == true) {
					random = rand.nextInt(2);	
				} else {
					random = 0;
				}
				
				if (enemyHp < 25 && counter % 3 == 0) {
					System.out.println("Jeana healed herself.");
					enemyHp += enemyHeal;
				}  else {
					if (enemyHp > 0 && random == 0) {
						if (number == 2) {
							System.out.println(enemyName + " attacked! " + ((enemyAttack / 2) - 
									(luna.getLunaDefense() / 2)) + " damage to Luna.\n");
							luna.setLunaHp(luna.getLunaHp() - ((enemyAttack / 2) - (luna.getLunaDefense() / 2)));
						} else {
							System.out.println(enemyName + " attacked! " + (enemyAttack  - 
									(luna.getLunaDefense() / 2)) + " damage to Luna.\n");
							luna.setLunaHp(luna.getLunaHp() - (enemyAttack - (luna.getLunaDefense() / 2)));
						}
					} else if (enemyHp > 0 && random == 1) {
						if (number2 == 2) {
							System.out.println(enemyName + " attacked! " + ((enemyAttack / 2) - 
									(friar.getfriarRexDefense() / 2)) + " damage to Friar Rex.\n");
							friar.setfriarRexHp(friar.getfriarRexHp() - ((enemyAttack / 2) - (friar.getfriarRexDefense() / 2)));
						} else {
							System.out.println(enemyName + " attacked! " + (enemyAttack  - 
									(friar.getfriarRexDefense() / 2)) + " damage to Friar Rex.\n");
							friar.setfriarRexHp(friar.getfriarRexHp() - (enemyAttack - (friar.getfriarRexDefense() / 2)));
						}
					}
				}
				counter++;
			} 
			
			
			
			if (enemyHp <= 0) {
				System.out.println("\nYou defeated " + enemyName + "!\n");
				levelUp(enemyExpOut, luna, friar);
			} else if (luna.getLunaHp() <= 0) {
				System.out.println("Luna's health is " + luna.getLunaHp());
				System.out.print("How could you let this happen...");
				System.exit(0);
			}
			
		
	}
	
	public static void fourthBattleMethod(Scanner keyboard, lunaStats luna,
			friarRexStats friar) {
		int counter = 1;
		int enemyHp = 200, enemyAttack = 15, enemyDefense = 25, enemyExpOut = 400;
		String intro = "The Constable twirls his handcuffs.";
		String enemyName = "The Constable";
		Random rand = new Random();
		
		System.out.println(intro);
		
			while (enemyHp > 0 && luna.getLunaHp() > 0) {
				int number = 8, number2 = 9, healNumber = 7, healNumber2 = 6;
	
				
				System.out.print("Luna's HP: " + luna.getLunaHp() + "\t\t");
				if (friar.getIfFriarRex() == true) {
					System.out.print("Friar Rex's HP: " + friar.getfriarRexHp());
				}
				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println(enemyName + " HP: " + enemyHp + "\n");
				
					
				// TODO find a way to write it so that if you put in letters it defaults
	
				while (number != 1 && number != 2 && number != 3) {
					System.out.print("Press 1 to have Luna attack, 2 to defend, or 3 to heal. ");
					number = Integer.parseInt(keyboard.nextLine());
						
					switch (number) {
						case 1:	
							System.out.println("You have attacked " + enemyName + " for " + 
									(luna.getLunaAttack() - (enemyDefense / 2)) + " damage.");
							enemyHp -= luna.getLunaAttack() - (enemyDefense / 2);
							break;
						case 2:	
							System.out.println("You have defended.");
							break;
						case 3:
							if (friar.getIfFriarRex() == true) {
								System.out.println("Press 1 to heal Luna or 2 to heal Friar Rex");
								healNumber = Integer.parseInt(keyboard.nextLine());
								
								switch (healNumber) {
									case 1:
										if (luna.getLunaHp() < luna.getLunaMaxHp() && (luna.getLunaHp() + friar.getfriarRexHeal()) <= luna.getLunaMaxHp()) {
											System.out.println("Luna healed herself.");
											luna.setLunaHp(luna.getLunaHp() + luna.getLunaHeal());
										} else if (luna.getLunaHp() < luna.getLunaMaxHp() && (luna.getLunaHp() + luna.getLunaHeal()) > luna.getLunaMaxHp()) {
											luna.setLunaHp(luna.getLunaMaxHp());
											System.out.println("Luna healed herself");
										} else {
											System.out.println("You do not need to heal.");
										}
										break;
									case 2:
										if (friar.getfriarRexHp() < friar.getfriarRexMaxHp() && (friar.getfriarRexHp() + luna.getLunaHeal()) <= friar.getfriarRexMaxHp()) {
											System.out.println("Luna healed Friar Rex.");
											friar.setfriarRexHp(friar.getfriarRexHp() + luna.getLunaHeal());
										} else if (friar.getfriarRexHp() < friar.getfriarRexMaxHp() && (friar.getfriarRexHp() + luna.getLunaHeal()) > friar.getfriarRexMaxHp()) { 
											friar.setfriarRexHp(friar.getfriarRexMaxHp());
											System.out.println("Luna healed Friar Rex.");
										} else {
											System.out.println("You do not need to heal.");
										}
										break;
									default: 
										System.out.println("Please enter a proper input.\n");
										break;
								}
								break;
					} else {
						if (luna.getLunaHp() < luna.getLunaMaxHp() && (luna.getLunaHp() + friar.getfriarRexHeal()) <= luna.getLunaMaxHp()) {
							System.out.println("Luna healed herself.");
							luna.setLunaHp(luna.getLunaHp() + luna.getLunaHeal());
						} else if (luna.getLunaHp() < luna.getLunaMaxHp() && (luna.getLunaHp() + luna.getLunaHeal()) > luna.getLunaMaxHp()) {
							luna.setLunaHp(luna.getLunaMaxHp());
							System.out.println("Luna healed herself");
						} else {
							System.out.println("You do not need to heal.");
						}
					}
					}
					System.out.print("\n");
					
					if (friar.getIfFriarRex() == true && enemyHp > 0 && friar.getfriarRexHp() > 0) {
						System.out.print("Press 1 for Friar Rex to attack, 2 to defend, or 3 to heal. ");
						number2 = Integer.parseInt(keyboard.nextLine());
							
						switch (number2) {
							case 1:	
								System.out.println("Friar Rex has attacked " + enemyName + " for " + 
										(friar.getfriarRexAttack() - (enemyDefense / 2)) + " damage.");
								enemyHp -= friar.getfriarRexAttack() - (enemyDefense / 2);
								break;
							case 2:	
								System.out.println("Friar Rex defended.");
								break;
							case 3:
								System.out.println("Press 1 to heal Luna or 2 to heal Friar Rex");
								healNumber2 = Integer.parseInt(keyboard.nextLine());
								
								switch (healNumber2) {
									case 1:
										if (luna.getLunaHp() < luna.getLunaMaxHp() && (luna.getLunaHp() + friar.getfriarRexHeal()) <= luna.getLunaMaxHp()) {
											System.out.println("Friar Rex healed Luna.");
											luna.setLunaHp(luna.getLunaHp() + friar.getfriarRexHeal());
										} else if (luna.getLunaHp() < luna.getLunaMaxHp() && (luna.getLunaHp() + friar.getfriarRexHeal()) > luna.getLunaMaxHp()) {
											luna.setLunaHp(luna.getLunaMaxHp());
											System.out.println("Friar Rex healed Luna.");
										} else {
											System.out.println("You do not need to heal.");
										}
										break;
									case 2:
										if (friar.getfriarRexHp() < friar.getfriarRexMaxHp() && (friar.getfriarRexHp() + friar.getfriarRexHeal() <= friar.getfriarRexMaxHp())) {
											System.out.println("Friar Rex healed himself.");
											friar.setfriarRexHp(friar.getfriarRexExp() + friar.getfriarRexHeal());
										} else if (friar.getfriarRexHp() < friar.getfriarRexMaxHp() && (friar.getfriarRexHp() + friar.getfriarRexHeal()) > friar.getfriarRexMaxHp()) {
											friar.setfriarRexHp(friar.getfriarRexMaxHp());
											System.out.println("Friar Rex healed himself.");
										} else {
											System.out.println("You do not need to heal.");
										}
										break;
									default: 
										System.out.println("Please enter a proper input.\n");
										break;
								}
								break;
						}
					}
				}
				System.out.print("\n");
					
				int random;
				if (friar.getIfFriarRex() == true) {
					random = rand.nextInt(2);	
				} else {
					random = 0;
				}
				
				if (counter % 4 == 0) {
					System.out.println(enemyName + " is charging up for a big attack!!");
				} else if (counter % 5 == 0) {
					
					// TODO real impotent, decide number
					enemyAttack = 45;
					if (enemyHp > 0 && random == 0) {
						if (number == 2) {
							System.out.println(enemyName + " attacked! " + ((enemyAttack / 2) - 
									(luna.getLunaDefense() / 2)) + " damage to Luna.\n");
							luna.setLunaHp(luna.getLunaHp() - ((enemyAttack / 2) - (luna.getLunaDefense() / 2)));
						} else {
							System.out.println(enemyName + " attacked! " + (enemyAttack  - 
									(luna.getLunaDefense() / 2)) + " damage to Luna.\n");
							luna.setLunaHp(luna.getLunaHp() - (enemyAttack - (luna.getLunaDefense() / 2)));
						}
					} else if (enemyHp > 0 && random == 1) {
						if (number2 == 2) {
							System.out.println(enemyName + " attacked! " + ((enemyAttack / 2) - 
									(friar.getfriarRexDefense() / 2)) + " damage to Friar Rex.\n");
							friar.setfriarRexHp(friar.getfriarRexHp() - ((enemyAttack / 2) - (friar.getfriarRexDefense() / 2)));
						} else {
							System.out.println(enemyName + " attacked! " + (enemyAttack  - 
									(friar.getfriarRexDefense() / 2)) + " damage to Friar Rex.\n");
							friar.setfriarRexHp(friar.getfriarRexHp() - (enemyAttack - (friar.getfriarRexDefense() / 2 )));
						}
					}
					enemyAttack = 15;
				} else {
					if (enemyHp > 0 && random == 0) {
						if (number == 2) {
							System.out.println(enemyName + " attacked! " + ((enemyAttack / 2) - 
									(luna.getLunaDefense() / 2)) + " damage to Luna.\n");
							luna.setLunaHp(luna.getLunaHp() - ((enemyAttack / 2) - (luna.getLunaDefense() / 2)));
						} else {
							System.out.println(enemyName + " attacked! " + (enemyAttack  - 
									(luna.getLunaDefense() / 2)) + " damage to Luna.\n");
							luna.setLunaHp(luna.getLunaHp() - (enemyAttack - (luna.getLunaDefense() / 2)));
						}
					} else if (enemyHp > 0 && random == 1) {
						if (number2 == 2) {
							System.out.println(enemyName + " attacked! " + ((enemyAttack / 2) - 
									(friar.getfriarRexDefense() / 2)) + " damage to Friar Rex.\n");
							friar.setfriarRexHp(friar.getfriarRexHp() - ((enemyAttack / 2) - (friar.getfriarRexDefense() / 2)));
						} else {
							System.out.println(enemyName + " attacked! " + (enemyAttack  - 
									(friar.getfriarRexDefense() / 2)) + " damage to Friar Rex.\n");
							friar.setfriarRexHp(friar.getfriarRexHp() - (enemyAttack - (friar.getfriarRexDefense() / 2)));
						}
					}
				}
				counter += 1;
			} 
			
			
			
			if (enemyHp <= 0) {
				System.out.println("\nYou defeated " + enemyName + "!\n");
				levelUp(enemyExpOut, luna, friar);
			} else if (luna.getLunaHp() <= 0) {
				System.out.println("Luna's health is " + luna.getLunaHp());
				System.out.print("How could you let this happen...");
				System.exit(0);
			}
			
		
	}

	// this should be a loop in later iterations. Eg. while exp > maxExp
	public static void levelUp(int expOut, lunaStats luna, friarRexStats friar) {
		// Give Exp
					luna.setLunaExp(luna.getLunaExp() + expOut);
					while (luna.getLunaExp() >= luna.getLunaNextLevel()) {
						// Random variable for HP
						Random randHp = new Random();
						// Random variable for attack
						Random randAttack = new Random();
						// Random variable for defense
						Random randDefense = new Random();
						luna.setLunaLevel(luna.getLunaLevel() + 1); // level
						luna.setLunaAttack(luna.getLunaAttack() + randAttack.nextInt(5));//attack
						luna.setLunaDefense(luna.getLunaDefense() + randDefense.nextInt(5)); //defense
						luna.setLunaNextLevel((luna.getLunaNextLevel() * 2));
						//luna.setLunaNextLevel((int)(luna.getLunaNextLevel() * 1.5f));
						luna.setLunaMaxHp(luna.getLunaMaxHp() + randHp.nextInt(11));
						
						// Class printout
						System.out.print("Luna Leveled Up to Level: " + luna.getLunaLevel() + "! She is now: ");
						if (luna.getLunaLevel() == 2) {
							System.out.println("Fresh Meat.");
						} else if (luna.getLunaLevel() == 3) {
							System.out.println("Target Practice.");
						} else if (luna.getLunaLevel() == 4) {
							System.out.println("A Novice.");
						} else if (luna.getLunaLevel() == 5) {
							System.out.println("A Hero.");
						}
						System.out.print("Exp: " + luna.getLunaExp());
						System.out.println("\t\t\tLevel Up at: " + luna.getLunaNextLevel() + " Exp\n" +
								"HP: " + luna.getLunaMaxHp() + "\t\t" + "Attack: " + luna.getLunaAttack() + "\tDefense: " + luna.getLunaDefense() + "\n");
					}	
					
					if (friar.getIfFriarRex() == true) {
						friar.setfriarRexExp(friar.getfriarRexExp() + expOut);
							while (friar.getfriarRexExp() >= friar.getfriarRexNextLevel()) {
								// Random variable for HP
								Random randHp = new Random();
								// Random variable for attack
								Random randAttack = new Random();
								// Random variable for defense
								Random randDefense = new Random();
								friar.setfriarRexLevel(friar.getfriarRexLevel() + 1); // level
								friar.setfriarRexAttack(friar.getfriarRexAttack() + randAttack.nextInt(5));//attack
								friar.setfriarRexDefense(friar.getfriarRexDefense() + randDefense.nextInt(5)); //defense
								friar.setfriarRexNextLevel((friar.getfriarRexNextLevel() * 2));
								//friar.setfriarRexNextLevel((int)(friar.getfriarRexNextLevel() * 1.5f));
								friar.setfriarRexMaxHp(friar.getfriarRexMaxHp() + randHp.nextInt(11));
								
								// Class printout
								System.out.print("Friar Rex Leveled Up! He is now: ");
								if (friar.getfriarRexLevel() == 2) {
									System.out.println("Reformed.\n");
								} else if (friar.getfriarRexLevel() == 3) {
									System.out.println("Baptized.\n");
								} else if (friar.getfriarRexLevel() == 4) {
									System.out.println("Confirmed.\n");
								} else if (friar.getfriarRexLevel() == 5) {
									System.out.println("Holy.\n");
								}
								System.out.print("Exp: " + friar.getfriarRexExp());
								System.out.println("\t\t\tLevel Up at: " + friar.getfriarRexNextLevel() + " Exp\n" +
										"HP: " + friar.getfriarRexMaxHp() + "\t\t" + "Attack: " + 
										friar.getfriarRexAttack() + "\tDefense: " + friar.getfriarRexDefense() + "\n");
							}
					}
	}
	
	public static Boolean getCoin(Scanner keyboard, String response) {
		Boolean hasCoin = false;
		System.out.print("As the Gooblins run off they each drop something. Luna goes to \n"
				+ "inspect what what they dropped. On the ground are two coins, one is a normal \n"
				+ "gold coin she's seen and used countless times before. The other coin looks \n"
				+ "to be incredibly heavy and is adorned with a cross and the name Friar Rex. \n"
				+ "There's no way to take both coins considering the weight of the cross coin. \n"
				+ "Will you leave behind the cross coin and take the gold coin? (Y/N) ");
		response = keyboard.nextLine();
		if (response.toUpperCase().equals("N")) {
			System.out.print("\nAre you sure you want this coin? It is sure to burden you on your adventure. (Y/N) ");
			response = keyboard.nextLine();
			if (response.toUpperCase().equals("Y")) {
				System.out.println("\nThough it is not recommended, you pick up the coin anyways.\n");
				hasCoin = true;
			}
		} else {
			System.out.println("\nLuna picked up the gold coin.\n");
		}
		return hasCoin;
	}
	
	public static void takeRest(String response, Scanner keyboard, lunaStats luna, friarRexStats friar) {
		// Heal Station
		if (luna.getLunaHp() < luna.getLunaMaxHp() || friar.getfriarRexHp() < friar.getfriarRexMaxHp()) {
			System.out.println("You look tired. Would you like to rest for a while?(Y/N) ");
			response = keyboard.nextLine();
			if (response.toUpperCase().equals("Y") && luna.getLunaHp() < luna.getLunaMaxHp()) {
				luna.setLunaHp(luna.getLunaHp() + (luna.getLunaMaxHp() - luna.getLunaHp()));
			}
			if (response.toUpperCase().equals("Y") && friar.getfriarRexHp() < friar.getfriarRexMaxHp()) {
				friar.setfriarRexHp(friar.getfriarRexHp() + (friar.getfriarRexMaxHp() - friar.getfriarRexHp()));
			}
		}
	}
	
	public static int getGachaPrize(Random rand, friarRexStats friar, Boolean hasCoin) {
		int expPrize;
		int randomNumber = rand.nextInt(100) + 1;
		if (hasCoin == true) {
			friar.setIfFriarRex(true);
			expPrize = 0;
			System.out.println("\"Ahem...\", a colossal man quitely clears his throat\n" + "Luna looks behind as she is about to put in the "
					+ "large, barely managable coin she found. \n"
					+ "She turns around to see a large man with a scar over a white eye, wearing what seems to \n"
					+ "be a religious monk's robes.\n"
					+ "\"I believe that may be my coin, may I have it back?\"");
		} else if (randomNumber >= 99) {
			friar.setIfFriarRex(true);
			System.out.println("Luna enters the gold coin and watches as the gears turns.\n"
					+ "Luna got a Rare Prize! +150 xp\n");
			expPrize = 150;
		} else if (randomNumber > 79 && randomNumber < 99) {
			System.out.println("Luna enters the gold coin and watches as the gears turns.\n"
					+ "Luna got an Uncommon Prize! +100 xp\n");
			expPrize = 100;
		} else {
			System.out.println("Luna enters the gold coin and watches as the gears turns.\n"
					+ "Luna got a Common Prize. +50 xp\n");
			expPrize = 50;
		}
		return expPrize;
	}
	
}
