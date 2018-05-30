import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.nullValue;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;

import java.util.Collection;

public class VirtualPetShelterTest {

	VirtualPetShelter underTest;
	VirtualPet testPet;
	private String petName;
	private String petDescription;
	private int petHunger = 50;
	private int petThirst = 50;
	private int petBoredom = 50;
	
	@Before
	public void setUp() {
		underTest = new VirtualPetShelter();
		testPet = new VirtualPet(petName, petDescription, petHunger, petThirst, petBoredom);
	}
	
	@Test
	public void shouldIntakePet() {
		underTest.intake(testPet);
		VirtualPet retrieved = underTest.findPet(petName);
		assertThat(retrieved, is(testPet));
	}
	
	@Test
	public void shouldIntakeMorePets() {
		String secondPetName = "Merlin";
		VirtualPet secondTestPet = new VirtualPet(secondPetName, "weirdo", 50, 50, 50);
		underTest.intake(testPet);
		underTest.intake(secondTestPet);
		Collection<VirtualPet> pets = underTest.pets();
		assertThat(pets, containsInAnyOrder(testPet, secondTestPet));
	}
	
	@Test
	public void shouldAdoptPet() {
		underTest.intake(testPet);
		
		underTest.adopt(petName);
		VirtualPet found = underTest.findPet(petName);
		assertThat(found, is(nullValue()));
		
	}
	@Test
	public void shouldFeedAllPets() {
		String secondPetName = "Merlin";
		VirtualPet secondTestPet = new VirtualPet(secondPetName, "weirdo", 50, 50, 50);
		underTest.intake(testPet);
		underTest.intake(secondTestPet);
		underTest.feedPets();
		
		int petHunger = underTest.findPet(petName).getHunger();
		int secondPetHunger = underTest.findPet(secondPetName).getHunger();
		assertThat(petHunger, is(40));
		assertThat(secondPetHunger, is(40));
	}
	
	@Test
	public void shouldWaterAllPets() {
		String secondPetName = "Merlin";
		VirtualPet secondTestPet = new VirtualPet(secondPetName, "weirdo", 50, 50, 50);
		underTest.intake(testPet);
		underTest.intake(secondTestPet);
		underTest.waterPets();
		
		int petThirst = underTest.findPet(petName).getThirst();
		int secondPetThirst = underTest.findPet(secondPetName).getThirst();
		assertThat(petThirst, is(40));
		assertThat(secondPetThirst, is(40));
	}
	
	@Test
	public void shouldPlayWithOnePet() {
		String secondPetName = "Merlin";
		VirtualPet secondTestPet = new VirtualPet(secondPetName, "weirdo", 50, 50, 50);
		underTest.intake(testPet);
		underTest.intake(secondTestPet);
		underTest.playWithPet(petName);
		
		int petBoredom = underTest.findPet(petName).getBoredom();
		int secondPetBoredom = underTest.findPet(secondPetName).getBoredom();
		assertThat(petBoredom, is(40));
		assertThat(secondPetBoredom, is(50));
	}
	
}
