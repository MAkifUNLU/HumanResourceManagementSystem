package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.core.utilities.adapters.ValidationService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.verification.VerificationService;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.VerificationCode;

@Service
public class AuthManager implements AuthService{
	
	private UserService userService;
	private EmployerService employerService;
	private CandidateService candidateService;
	private VerificationService verificationService;
	private ValidationService validationService;
	private VerificationCodeService verificationCodeService;
	
	@Autowired
	public AuthManager(UserService userService, EmployerService employerService, CandidateService candidateService,
			VerificationService verificationService, ValidationService validationService,
			VerificationCodeService verificationCodeService) {
		super();
		this.userService = userService;
		this.employerService = employerService;
		this.candidateService = candidateService;
		this.verificationService = verificationService;
		this.validationService = validationService;
		this.verificationCodeService = verificationCodeService;
	}


	@Override
	public Result registerEmployer(Employer employer, String confirmPassword) {
		
		if (!checkIfNullInfoForEmployer(employer)) {

			return new ErrorResult("Eksik Bilgi Girdiniz. Lütfen Tüm Alanları Doldurun");
		}

		if (!checkIfEqualEmailAndDomain(employer.getEmail(), employer.getWebsite())) {

			return new ErrorResult("Geçersiz Email");
		}

		if (!checkIfEmailExists(employer.getEmail())) {

			return new ErrorResult(employer.getEmail() + " Email Zaten Mevcut");
		}

		if (!checkIfEqualPasswordAndConfirmPassword(employer.getPassword(), confirmPassword)) {

			return new ErrorResult("Parola Eşleşmedi");
		}

		employerService.add(employer);
		String code = verificationService.sendCode();
		verificationCodeRecord(code, employer.getId(), employer.getEmail());
		return new SuccessResult("Kayıt Başarı İle Tamamlandı");
	}

	@Override
	public Result registerCandidate(Candidate candidate, String confirmPassword) {
		
		if (checkIfRealPerson(Long.parseLong(candidate.getNationalId()), candidate.getFirstName(),
				candidate.getLastName(), candidate.getDateOfBirth().getDayOfYear()) == false) {
			return new ErrorResult("TCKN Doğrulanamadı.");
		}

		if (!checkIfNullInfoForCandidate(candidate, confirmPassword)) {

			return new ErrorResult("Eksik Bilgi Girdiniz. Lütfen Tüm Alanları Doldurun");
		}

		if (!checkIfExistsTcNo(candidate.getNationalId())) {

			return new ErrorResult(candidate.getNationalId() + "Tc Zaten Mevcut");
		}

		if (!checkIfEmailExists(candidate.getEmail())) {

			return new ErrorResult(candidate.getEmail() + "Email Zaten Mevcut");
		}
		
		candidateService.add(candidate);
		String code = verificationService.sendCode();
		verificationCodeRecord(code, candidate.getId(), candidate.getEmail());
		return new SuccessResult("Kayıt Başarı İle Tamamlandı");
	}
	
	// İş Veren Doğrulaması 

		private boolean checkIfNullInfoForEmployer(Employer employer) {

			if (employer.getCompanyName() != null && employer.getWebsite() != null && employer.getEmail() != null
					&& employer.getPhoneNumber() != null && employer.getPassword() != null) {

				return true;
			}
			return false;
		}

		private boolean checkIfEqualEmailAndDomain(String email, String website) {
			String[] emailArr = email.split("@", 2);
			String domain = website.substring(4, website.length());

			if (emailArr[1].equals(domain)) {

				return true;
			}

			return false;
		}
		// İş Arayan Doğrulama 
		
		private boolean checkIfNullInfoForCandidate(Candidate candidate, String confirmPassword) {

			if (candidate.getFirstName() != null && candidate.getLastName() != null && candidate.getNationalId() != null
					&& candidate.getDateOfBirth() != null && candidate.getPassword() != null && candidate.getEmail() != null
					&& confirmPassword != null) {

				return true;
			}
			return false;
		}

		private boolean checkIfExistsTcNo(String nationalId) {

			if (this.candidateService.getCandidateByNationalId(nationalId).getData() == null) {
				return true;
			}
			return false;
		}

		private boolean checkIfRealPerson(long nationalId, String firstName, String lastName, int yearOfBirth) {

			if (validationService.validateByMernis(nationalId, firstName, lastName, yearOfBirth)) {
				return true;
			}
			return false;
		}
		
		// Doğrulama Kodları

		private boolean checkIfEmailExists(String email) {

			if (this.userService.getUserByEmail(email).getData() == null) {

				return true;
			}

			return false;
		}

		private boolean checkIfEqualPasswordAndConfirmPassword(String password, String confirmPassword) {

			if (!password.equals(confirmPassword)) {
				return false;
			}

			return true;
		}
		
		private void verificationCodeRecord(String code, int id, String email) {
			
			VerificationCode verificationCode = new VerificationCode(id, code, false);
			this.verificationCodeService.add(verificationCode);
			System.out.println("Verification code has been sent to " + email );
		
		}

}
