package devs.kodlama.io.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import devs.kodlama.io.dataAccess.abstracts.ProgrammingLanguageRepository;
import devs.kodlama.io.entities.concretes.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository {

	List<ProgrammingLanguage> programmingLanguages;

	public InMemoryProgrammingLanguageRepository() {
		programmingLanguages = new ArrayList<ProgrammingLanguage>();
		programmingLanguages.add(new ProgrammingLanguage(1, "C#"));
		programmingLanguages.add(new ProgrammingLanguage(2, "Java"));
		programmingLanguages.add(new ProgrammingLanguage(3, "Python"));
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguages;
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		return programmingLanguages.get(id - 1);
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) {
		programmingLanguages.add(programmingLanguage);
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) {
		ProgrammingLanguage updateProgrammingLanguage = programmingLanguages.get(programmingLanguage.getId());
		updateProgrammingLanguage.setName(programmingLanguage.getName());
	}

	@Override
	public void delete(int id) {
		if (programmingLanguages.contains(programmingLanguages)) {
			ProgrammingLanguage deleteProgrammingLanguage = programmingLanguages.get(id);
			programmingLanguages.remove(deleteProgrammingLanguage.getId());
		}
	}

}
