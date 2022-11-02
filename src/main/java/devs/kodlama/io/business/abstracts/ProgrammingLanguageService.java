package devs.kodlama.io.business.abstracts;

import java.util.List;

import devs.kodlama.io.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {
	List<ProgrammingLanguage> getAll();

	ProgrammingLanguage getById(int id);

	String add(ProgrammingLanguage programmingLanguage);

	String update(ProgrammingLanguage programmingLanguage);

	String delete(int id);
}
