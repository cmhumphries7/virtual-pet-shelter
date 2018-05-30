import java.util.Scanner;

public class VirtualPetApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		VirtualPetShelter myVirtualPetShelter = new VirtualPetShelter();

		String catChoice = "";

		VirtualPet petOne = new VirtualPet("Teeney", "A dainty and adorable calico princess.", 50, 50, 50);
		VirtualPet petTwo = new VirtualPet("Merlin", "A curious and strange creature.", 50, 50, 50);
		VirtualPet petThree = new VirtualPet("Salem", "Who says black cats are unlucky? Not this guy.", 50, 50, 50);

		myVirtualPetShelter.intake(petOne);
		myVirtualPetShelter.intake(petTwo);
		myVirtualPetShelter.intake(petThree);

		System.out.println(
				"Welcome to The Cat's Pajamas! I understand this is your first day at work!\nSorry... what's your name again?");
		String employeeName = input.nextLine();

		System.out.println("Of course your name is " + employeeName + "!!! How silly of me.");

		while (true) {
			
			System.out.println("This is the status of your kitties:");
			System.out.println();
			System.out.println("Name\tHunger\tThirst\tBoredom");
			System.out.println(myVirtualPetShelter.displayStatus());
			System.out.println();
			System.out.println("What would you like to do next, " + employeeName + " ?");
			System.out.println("[1] Feed all the cats.");
			System.out.println("[2] Water the cats.");
			System.out.println("[3] Play with a cat.");
			System.out.println("[4] Adopt a cat.");
			System.out.println("[5] Admit a cat.");
			System.out.println("[6] Quit");

			String selection = input.nextLine();

			switch (selection) {
			case "1": {
				myVirtualPetShelter.feedPets();
				System.out.println("[1] You feed all the kitties Meow Mix.");
				break;
			}
			case "2": {
				myVirtualPetShelter.waterPets();
				System.out.println("[2] You fill the cats' water bowls with fresh water.");
				break;
			}

			case "3": {
				System.out.println("Which cat would you like to play with?");
				System.out.println(myVirtualPetShelter.displayNamesAndDesciptions());
				catChoice = input.nextLine();
				myVirtualPetShelter.playWithPet(catChoice);
				System.out.println(catChoice + " purrs with delight!");
				break;

			}

			case "4": {
				System.out.println("[4] Fantastic! Which cat has won your heart?");
				System.out.println(myVirtualPetShelter.displayNamesAndDesciptions());
				catChoice = input.nextLine();
				myVirtualPetShelter.adopt(catChoice);
				System.out.println("The happy new cat owner leaves the shelter with " + catChoice + " .");
				break;
			}

			case "5": {
				System.out.println("[5] Alright... just need to fill out some paperwork.");
				System.out.println("Give the cat a name, " + employeeName + " !");

				String newName = input.nextLine();

				System.out.println("Provide a brief desciption of the cat's temperment.");

				String newDescription = input.nextLine();

				myVirtualPetShelter.intake(new VirtualPet(newName, newDescription, 50, 50, 50));

				System.out.println(newName + " is now avaiable for adoption at the Cat's Pajamas!");
				break;
			}

			case "6": {
				System.out.println(
						"[6] You decide this isn't the right job for you and you abandon your scratching post.");
				System.exit(0);
			}
			default: {
				System.out.println("Stop playing with the laser pointer and get back to work!");
			}

			}
			myVirtualPetShelter.tick();
			for (int i =0; i < 4; i++) {
				System.out.println();
			}

		}
	}
}
