package eidi2.sose2022.admission_exam.group03;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import eidi2.sose2022.admission_exam.group03.animal.AAnimal;
import eidi2.sose2022.admission_exam.group03.animal.CanFly;
import eidi2.sose2022.admission_exam.group03.animal.Raven;
import eidi2.sose2022.admission_exam.group03.animal.Tiger;

public class Zoo {
	HashMap<Trainer<AAnimal>, List<Enclosure<AAnimal>>> trainings = new HashMap<>();;
	
	public <T extends AAnimal> void addEnclosureForTrainer(Trainer<T> trainer, Enclosure<T> enclosureToAdd) {
		if (enclosureToAdd == null)
			throw new IllegalArgumentException("Argument enclosure can't be null");

		if(!trainings.containsKey(trainer)) {
			trainings.put((Trainer<AAnimal>) trainer, new LinkedList<Enclosure<AAnimal>>());
		}

		trainings.get(trainer).add((Enclosure<AAnimal>) enclosureToAdd);
	}
	
	public <T extends AAnimal & CanFly> int countLegsOnGroundInAllEnclosures(Trainer<T> trainer) {
		var encolsures = trainings.get(trainer);

		int sum = 0;

		for(var enc : encolsures) {
			if(enc.enclosedAnimals.equals(Raven.class)) {
				for(var animal : enc.animals) {
					if(((Raven)animal).isAirborne() == false) {
						sum += animal.getLegCount();
					}
				}
			}
		}

		return sum;
	}
	
	public void gutAllTigers() {
		for(var enclosures : trainings.values()) {
			for(var encolsure : enclosures) {
				if(encolsure.enclosedAnimals.equals(Tiger.class)) {
					encolsure.animals.forEach(s -> s.setLegCount(0));
				}
			}
		}
	}

	@Override
	public String toString() {
		return "Zoo [trainings=" + trainings + "]";
	}
}
