package eidi2.sose2022.admission_exam.group01;

import java.util.List;
import java.util.LinkedList;

import eidi2.sose2022.admission_exam.group01.util.Tuple;
import eidi2.sose2022.admission_exam.storage.IStoreable;
import eidi2.sose2022.admission_exam.storage.Vault;

public class VaultingManager {
	final List<Tuple<Bank, List<Vault<IStoreable>>>> banksAndVaults = new LinkedList<>();
	
	/**
	 * Searches for a bank and its associated vaults and returns both of them in the form of a tuple.
	 * @param bankToFind the bank for which a mapping tuple should be found
	 * @return Tuple containing the sought bank and a list of its associated Vaults or NULL if the bank does not exist in the mappings
	 */
	private Tuple<Bank, List<Vault<IStoreable>>> findBankTuple(Bank bankToFind) {
		return banksAndVaults.stream().filter(t -> t.first == bankToFind).findFirst().orElse(null);
	}
	
	public void addVaultForBank(Bank bankToFind, Vault<IStoreable> vaultToAdd) {
		if(bankToFind == null)
			throw new IllegalArgumentException("Argument bank was null");

		if(vaultToAdd == null)
			throw new IllegalArgumentException("Argument vaultToAdd was null");

		var bank = findBankTuple(bankToFind);

		if(bank == null) {
			bank = new Tuple<Bank,List<Vault<IStoreable>>>(bankToFind, new LinkedList<Vault<IStoreable>>());
			banksAndVaults.add(bank);
		}

		bank.second.add(vaultToAdd);
	}
	
	/**
	 * Searches for a vault with the passed ID.
	 * @param idToFind
	 * @return the vault with the passed ID or null if no such vault was found.
	 */
	Vault<IStoreable> findVaultWithID(long idToFind) {
		return banksAndVaults.stream().flatMap(t -> t.second.stream()).filter(v -> v.getID() == idToFind).findFirst().orElse(null);
	}
	
	public boolean addStoreableToBankVault(long vaultID, IStoreable storeableToAdd) {
		var vault = findVaultWithID(vaultID);

		if(vault == null)
			return false;

		return vault.addStoreableToVault(storeableToAdd);
	}
}
