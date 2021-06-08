package kodlamaio.hrms.entities.dtos;

import java.util.List;

import kodlamaio.hrms.entities.concretes.CVCoverLetter;
import kodlamaio.hrms.entities.concretes.CVExperience;
import kodlamaio.hrms.entities.concretes.CVForeignLanguage;
import kodlamaio.hrms.entities.concretes.CVImage;
import kodlamaio.hrms.entities.concretes.CVLink;
import kodlamaio.hrms.entities.concretes.CVProgrammingSkill;
import kodlamaio.hrms.entities.concretes.CVSchool;
import kodlamaio.hrms.entities.concretes.Candidate;

public class CandidateCVDto {

	public Candidate candidate;
	public List<CVCoverLetter> coverLetters;
	public List<CVSchool> schools;
	public List<CVLink> links;
	public List<CVProgrammingSkill> programingSkills;
	public List<CVForeignLanguage> languages;
	public List<CVExperience> experiences;
	public CVImage image;
}
