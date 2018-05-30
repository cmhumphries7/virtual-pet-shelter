import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class VirtualPetShelter {

	Map<String, VirtualPet> shelterPets = new HashMap<>();

	public void intake(VirtualPet pet) {
		this.shelterPets.put(pet.getName(), pet);

	}

	public VirtualPet findPet(String petName) {
		return this.shelterPets.get(petName);
	}

	public Collection<VirtualPet> pets() {
		return this.shelterPets.values();
	}

	public void adopt(String petName) {
		this.shelterPets.remove(petName);

	}

	public void feedPets() {
		for (Entry<String, VirtualPet> fedPet : shelterPets.entrySet()) {
			fedPet.getValue().feedPet();
		}

	}

	public void waterPets() {
		for (Entry<String, VirtualPet> wateredPet : shelterPets.entrySet()) {
			wateredPet.getValue().waterPet();

		}
	}

	public void playWithPet(String petName) {
		this.shelterPets.get(petName).playWithPet();

	}

	public void tick() {
		for (Entry<String, VirtualPet> tickedPet : shelterPets.entrySet()) {
			String key = tickedPet.getKey();
			shelterPets.get(key).tick();

		}
	}

	public String displayStatus() {
		String statusOfPets = "";
		for (Entry<String, VirtualPet> everyPet : shelterPets.entrySet()) {

			statusOfPets += everyPet.getValue().returnStatus() + "\n";

		}
		return statusOfPets;

	}
	
	public String displayNamesAndDesciptions() {
		String namesAndDescriptions = "";
		for (Entry<String, VirtualPet> everyPet : shelterPets.entrySet()) {
			namesAndDescriptions += "[" + everyPet.getValue().getName() + "]" + everyPet.getValue().getDescription() +"\n";
		}
		return namesAndDescriptions;
	}
}
