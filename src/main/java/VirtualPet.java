
public class VirtualPet {

	private String petName;
	private int petHunger;
	private String petDescription;
	private int petThirst;
	private int petBoredom;

	public VirtualPet(String petName, String petDescription, int petHunger, int petThirst, int petBoredom) {
		this.petName = petName;
		this.petDescription = petDescription;
		this.petHunger = petHunger;
		this.petThirst = petThirst;
		this.petBoredom = petBoredom;

	}

	public String getName() {
		return petName;
	}

	public int getHunger() {
		return petHunger;
	}

	public int getThirst() {
		return petThirst;
	}

	public int getBoredom() {
		return petBoredom;
	}

	public void feedPet() {
		this.petHunger -= 10;
		if (this.petHunger < 0) {
			this.petHunger = 0;
		}

	}

	public void waterPet() {
		this.petThirst -= 10;
		if (this.petThirst < 0) {
			this.petThirst = 0;
		}

	}

	public void playWithPet() {
		this.petBoredom -= 10;
		if (this.petBoredom < 0) {
			this.petBoredom = 0;
		if (this.petBoredom > 100) {
			System.out.println("The cats are getting restless! Please play with them.");
		}
		}
		
	}
	public void tick() {
		this.petHunger += 1;
		this.petThirst += 1;
		this.petBoredom += 1;
	}

	public String returnStatus() {
		return petName + "\t|" + petHunger + "\t|" + petThirst + "\t|" + petBoredom;
	}

	public String getDescription() {
		return petDescription;
	}
}
