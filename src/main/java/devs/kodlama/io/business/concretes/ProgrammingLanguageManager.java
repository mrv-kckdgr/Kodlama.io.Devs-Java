package devs.kodlama.io.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devs.kodlama.io.business.abstracts.ProgrammingLanguageService;
import devs.kodlama.io.dataAccess.abstracts.ProgrammingLanguageRepository;
import devs.kodlama.io.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageRepository programmingLanguageRepository;

	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return this.programmingLanguageRepository.getAll();
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		return this.programmingLanguageRepository.getById(id);
	}

	@Override
	public String add(ProgrammingLanguage programmingLanguage) {
		String message = null;
		if (programmingLanguage.getName() == null || programmingLanguage.getName() == "") {
			message = "Programming Language cannot blank!";
			return message;
		}

		if (!programmingLanguageRepository.getAll().contains(programmingLanguage)) {
			this.programmingLanguageRepository.add(programmingLanguage);
			message = "Programming Language successfully added.";
		} else
			message = "Programming Language already added!";
		return message;
	}

	@Override
	public String update(ProgrammingLanguage programmingLanguage) {
		String message = null;
		if (programmingLanguage.getName() == null || programmingLanguage.getName() == "") {
			message = "Programming Language cannot blank!";
			return message;
		}

		if (programmingLanguageRepository.getAll().contains(programmingLanguage)) {
			ProgrammingLanguage updateProgrammingLanguage = programmingLanguageRepository
					.getById(programmingLanguage.getId());
			updateProgrammingLanguage.setName(programmingLanguage.getName());
			message = "Programming Language successfully updated.";
		} else
			message = "Programming Language not found!";
		return message;
	}

	@Override
	public String delete(int id) {
		this.programmingLanguageRepository.delete(id);
		return "Programming Language successfully deleted.";
	}
}
