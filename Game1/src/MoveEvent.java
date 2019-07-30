// initiates events on movement
// events include battle, find gold, and random messages
import java.util.Random;
import java.util.Scanner;

public class MoveEvent {
		
		private Scanner scan = new Scanner(System.in);
		private final int MAX_EVENTS = 10;
		private Random ran = new Random();
		private PlayerCharacter player;

		public MoveEvent(PlayerCharacter p) {
			player = p;
			int event = ran.nextInt(MAX_EVENTS);
			
			// 0 1 = battle 2 = treasure 3 = message
			if(event == 0 || event == 1 || event == 4) {
				beginBattle();
			} else if(event == 2) {
				findTreasure();
			} else if(event == 3) {
				randomMessage();
			}
		}
		
		private void beginBattle() {
			int enemyNum = (ran.nextInt(4) + 1);
			int command = 0;
			Slime[] slime = new Slime[enemyNum];
			String[] playerAbilities = player.getAbilities();
			String entry;
			boolean valid = false;
			boolean runAway = false;
			int deadCounter = 0;
			int experience = 0;
			int gold = 0;
			
			enemyNum += 1;
			
			for(int x = 0; x < slime.length; ++x) {
				slime[x] = new Slime();
			}
			
			System.out.println("\nBattle Initiated!\n" + slime.length + " " + slime[0].getName() + " have appeared!");
			
			// main battle loop, continues until all enemies defeated/player defeated/run away
			do {
				// show enemy image
				for(int x = 0; x < slime.length; ++x) {
					if(slime[x].getHealth() > 0) {
						System.out.print(slime[x].getImage());
					}
				}
				
				System.out.println("\nHealth: " + player.getHealth() + "/" + player.getMaxHealth() + " Mana: " + player.getMaxMana() + "/" + player.getMana());
				System.out.println("\nCommand?");
				
				for(int x = 0; x < playerAbilities.length; ++x) {
					System.out.println((x + 1) + " - " + playerAbilities[x]);
				}
				
				// loop until a valid command is entered
				do {
					System.out.print(">>>");
					entry = scan.nextLine();
					
					try {
						command = Integer.parseInt(entry);
					} catch(Exception e) {
						System.out.println("Please enter a valid command");
					}
					
					if(command >= 1 && command <= playerAbilities.length) {
						valid = true;
					} else {
						System.out.println("Please enter a valid number");
					}
				} while(!valid);
				
				valid = false;
				boolean playerTurnOver = false;
				
				// command decision structure, its a mess i know
				if(command == 1) { // attack command
					for(int x = 0; x < slime.length; ++x) {
						// attack if enemy isn't dead and player hasn't attacked yet
						if(!slime[x].isDead() && !playerTurnOver) {
							playerTurnOver = true;
							if(player.getAgility() >= slime[x].getAgility()) {
								slime[x].damageHealth(player.getPhysicalAttackDamage());
								System.out.println(slime[x].getName() + " " + (x + 1) + " takes " + player.getPhysicalAttackDamage() + " damage");
								if(slime[x].isDead() ) {
									deadCounter += 1;
									experience += slime[x].getExperienceGained();
									gold += slime[x].getGoldGained();
								} else {
									player.damageHealth(slime[x].getPhysicalAttackDamage());
									System.out.println(player.getName() + " takes " + slime[x].getPhysicalAttackDamage() + " damage from " + slime[x].getName());
								}
							} else {
								player.damageHealth(slime[x].getPhysicalAttackDamage());
								System.out.println(player.getName() + " takes " + slime[x].getPhysicalAttackDamage() + " damage");
							}
						} else if(!slime[x].isDead() && playerTurnOver) {
							player.damageHealth(slime[x].getPhysicalAttackDamage());
							System.out.println(player.getName() + " takes " + slime[x].getPhysicalAttackDamage() + " damage from " + slime[x].getName());
						}
						// prints if enemy died during the process
						if(slime[x].isDead() && !slime[x].isDeadNotify()) {
							System.out.println(slime[x].getName() + " " + (x + 1) + " was slain");
							slime[x].setIsDeadNotify(true);
						}
					}
				} else if(command == 2) { // unique command
					// defend takes priority
					if(playerAbilities[command - 1] == "Defend") {
						playerTurnOver = true;
						
						System.out.println(player.getName() + " defends - All damage is reduced by half");
						
						for(int x = 0; x < slime.length; ++x) {
							if(!slime[x].isDead()) {
								player.damageHealth(slime[x].getPhysicalAttackDamage() / 2);
								System.out.println(player.getName() + " takes " + slime[x].getPhysicalAttackDamage() + " damage from " + slime[x].getName());
							}
						}
					} else if(playerAbilities[command - 1] == "Steal") {
						int stealChance = player.getAgility() * player.getLuck() + 20;
						int randomSteal = ran.nextInt(100);
						
						for(int x = 0; x < slime.length; ++x) {
							// steal takes move priority
							if(!slime[x].isDead() && !playerTurnOver) {
								if(randomSteal <= stealChance) {
									System.out.println(player.getName() + " stole " + slime[x].getGoldGained() + " gold from " + slime[x].getName() + " " + (x + 1));
									gold += slime[x].getGoldGained();
									playerTurnOver = true;
								} else {
									System.out.println("Steal failed");
									playerTurnOver = true;
								}
								// enemies attack after steal is used
								player.damageHealth(slime[x].getPhysicalAttackDamage());
								System.out.println(player.getName() + " takes " + slime[x].getPhysicalAttackDamage() + " damage from " + slime[x].getName());
								
							} else if(!slime[x].isDead() && playerTurnOver) {
								player.damageHealth(slime[x].getPhysicalAttackDamage());
								System.out.println(player.getName() + " takes " + slime[x].getPhysicalAttackDamage() + " damage from " + slime[x].getName());
							}
						}
					} else if(playerAbilities[command - 1] == "Fireball") {
						// attack with fireball is mana is sufficient
						if(player.getAbilitiesMana(command - 1) <= player.getMana()) {
							player.damageMana(player.getAbilitiesMana(command - 1));
							
							for(int x = 0; x < slime.length; ++x) {
								
								if(!slime[x].isDead() && !playerTurnOver) {
									playerTurnOver = true;
									System.out.println(player.getName() + " launches a fireball at " + slime[x].getName() + " " + (x + 1));
									System.out.println(slime[x].getName() + " " + (x + 1) + " takes " + player.getMagicAttackDamage() + " fire damage");
									slime[x].damageHealth(player.getMagicAttackDamage());
									if(slime[x].isDead()) {
										deadCounter += 1;
										experience += slime[x].getExperienceGained();
										gold += slime[x].getGoldGained();
									} else {
										player.damageHealth(slime[x].getPhysicalAttackDamage());
										System.out.println(player.getName() + " takes " + slime[x].getPhysicalAttackDamage() + " damage from " + slime[x].getName());
									}
								} else {
									player.damageHealth(slime[x].getPhysicalAttackDamage());
									System.out.println(player.getName() + " takes " + slime[x].getPhysicalAttackDamage() + " damage from " + slime[x].getName());
								}
								
								if(slime[x].isDead() && !slime[x].isDeadNotify()) {
									System.out.println(slime[x].getName() + " " + (x + 1) + " was slain");
									slime[x].setIsDeadNotify(true);
								}
							}
						} else {
							System.out.println("Insuffucient mana to cast fireball");
						}
					}
				} else if(command == 3) { // item command
					boolean exitInventory = false;
					// check if anything is in inventory, display result
					if(player.items.getInventorySize() == 0) {
						System.out.println("\nInventory is empty\n");
						// if inventory is not empty
					} else {
						for(int x = 0; x < player.items.getPotionNameSize(); ++x) {
							if(player.items.getInventoryItemQuantity(x) > 0) {
								System.out.println(player.items.getInventory(x));
							}
						}
						
						int validItem;
						
						do {
							System.out.print("Enter a number for an item or 0 to return >>");
							entry = scan.nextLine();
							try {
								validItem = Integer.parseInt(entry);
								if(validItem >= 0 && validItem <= player.items.getPotionNameSize()) {
									//System.out.println("validitem: " + validItem + " potionnamesize " + player.items.getPotionNameSize());
									exitInventory = true;
									if(validItem > 0) {
										validItem -= 1;
										if(player.items.getPotionQuantity(validItem) > 0) {
											//System.out.println("validitem: " + validItem + " potionnamesize " + player.items.getPotionNameSize());
											player.useItem(validItem);
											System.out.println(player.getName() + " used a " + (player.items.getPotion(validItem)).substring(3));
											// enemies attack if item was used
											for(int x = 0; x < slime.length; ++x) {
												if(!slime[x].isDead()) {
													player.damageHealth(slime[x].getPhysicalAttackDamage());
													System.out.println(player.getName() + " takes " + slime[x].getPhysicalAttackDamage() + " damage from " + slime[x].getName());
												}
											}
										} else {
											System.out.println("Invalid selection");
										}
									}
								} else {
									System.out.println("Invalid entry 1");
								}
							} catch(Exception e) {
								System.out.println("Invalid entry 2" + e.getMessage());
							}
						} while(!exitInventory);
					}
				} else if(command == 4) { // run command, takes priority, 50% chance to run
					if(ran.nextInt(100) % 2 == 0) {
						runAway = true;
					} else {
						System.out.println("Failed to run away");
						// enemy attacks if run command failed
						for(int x = 0; x < slime.length; ++x) {
							if(!slime[x].isDead()) {
								player.damageHealth(slime[x].getPhysicalAttackDamage());
								System.out.println(player.getName() + " takes " + slime[x].getPhysicalAttackDamage() + " damage from " + slime[x].getName());
							}
						}
					}
				}
				
				playerTurnOver = false;
				
				// loops until all enemies defeated or player dies or player runs
			} while(deadCounter < slime.length && !player.isDead() && !runAway);
			
			// check for conditions after battle end
			if(!player.isDead() && !runAway) {
				System.out.println("\nVictory - You gained " + experience + " experience points");
				player.addExperience(experience);
				player.addGoldAmount(gold);
			} else if (player.isDead()) {
				System.out.println(player.getName() + " has perished");
			} else {
				System.out.println("Ran away successfully");
			}
		}
		
		// get a random amount of gold
		private void findTreasure() {
			int gold = ran.nextInt(player.getLuck() + player.getLevel() * 2);
			
			System.out.println(player.getName() + " found " + gold + " gold");
			player.addGoldAmount(gold);
		}
		
		private void randomMessage() {
			String message1 = player.getName() + " stops to admire the sun. If only I could be so grossly incandescent.";
			String message2 = "I was born in a crossfire hurricane. I howled at my ma in the driving rain.";
			String message3 = "Maybe it's just jealousy, mixing up with a violent mind. A circumstance that doesn't make much sense.";
			String message4 = "You see a message on the ground. It says illusionary wall ahead.";
			String message5 = "You wonder if slimes are intelligent enough to be aware of their own existence.";
			String message6 = "I really could go for a beer right about now.";
			String[] messages = {message1, message2, message3, message4, message5, message6};
			int num = ran.nextInt(messages.length);
			
			System.out.println("\n" + messages[num] + "\n");
		}
}
