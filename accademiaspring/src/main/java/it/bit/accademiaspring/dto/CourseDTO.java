package it.bit.accademiaspring.dto;

import java.time.DayOfWeek;
import java.util.List;
import java.util.stream.Collectors;

import it.bit.accademiaspring.enu.Orario;
import it.bit.accademiaspring.model.Aula;
import it.bit.accademiaspring.model.Azienda;
import it.bit.accademiaspring.model.Course;
import it.bit.accademiaspring.model.Iscrizione;

public class CourseDTO {

	private int id;
	
	private String nomeCorso;
	
	private int capienza;
	
	private int iscrizioniMin;
	
	private boolean finanziato;
	
	private Azienda azienda;
	
	private List<IscrizioneDTO> iscrizioni;
	
	private int numeroLezioni;
	
	private Orario orarioPreferito;
	
	private String dataDiInizio;
	
	private int idAulaPreferita;

	private List<DayOfWeek> dowList;



	public CourseDTO(Course c) {
		this.id = c.getId();
		this.nomeCorso = c.getNomeCorso();
		this.capienza = c.getCapienza();
		this.iscrizioniMin = c.getIscrizioniMin();
		this.finanziato = c.isFinanziato();
		this.iscrizioni = c.getIscrizioni().stream().map(IscrizioneDTO::new).collect(Collectors.toList());
		this.dataDiInizio = c.getDataDiInizio();
	}

	public CourseDTO(int id, String nomeCorso, int capienza, int iscrizioniMin, boolean finanziato, Azienda azienda,
			List<IscrizioneDTO> iscrizioni, int numeroLezioni, Orario orarioPreferito, int idAulaPreferita, String dataDiInizio, List<DayOfWeek> dowList) {
		super();
		this.id = id;
		this.nomeCorso = nomeCorso;
		this.capienza = capienza;
		this.iscrizioniMin = iscrizioniMin;
		this.finanziato = finanziato;
		this.azienda = azienda;
		this.iscrizioni = iscrizioni;
		this.numeroLezioni = numeroLezioni;
		this.orarioPreferito = orarioPreferito;
		this.idAulaPreferita = idAulaPreferita;
		this.dataDiInizio = dataDiInizio;
		this.dowList = dowList;
	}

	public List<DayOfWeek> getDowList() {
		return dowList;
	}

	public void setDowList(List<DayOfWeek> dowList) {
		this.dowList = dowList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeCorso() {
		return nomeCorso;
	}

	public String getDataDiInizio() {
		return dataDiInizio;
	}

	public int getNumeroLezioni() {
		return numeroLezioni;
	}

	public void setNumeroLezioni(int numeroLezioni) {
		this.numeroLezioni = numeroLezioni;
	}

	public Orario getOrarioPreferito() {
		return orarioPreferito;
	}

	public void setOrarioPreferito(Orario orarioPreferito) {
		this.orarioPreferito = orarioPreferito;
	}

	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}

	public int getCapienza() {
		return capienza;
	}

	public void setCapienza(int capienza) {
		this.capienza = capienza;
	}

	public int getIscrizioniMin() {
		return iscrizioniMin;
	}

	public void setIscrizioniMin(int iscrizioniMin) {
		this.iscrizioniMin = iscrizioniMin;
	}

	public boolean isFinanziato() {
		return finanziato;
	}

	public void setFinanziato(boolean finanziato) {
		this.finanziato = finanziato;
	}

	public Azienda getAzienda() {
		return azienda;
	}

	public void setAzienda(Azienda azienda) {
		this.azienda = azienda;
	}

	public List<IscrizioneDTO> getIscrizioni() {
		return iscrizioni;
	}

	public void setIscrizioni(List<IscrizioneDTO> iscrizioni) {
		this.iscrizioni = iscrizioni;
	}

	public int getIdAulaPreferita() {
		return idAulaPreferita;
	}

	public void setIdAulaPreferita(int idAulaPreferita) {
		this.idAulaPreferita = idAulaPreferita;
	}
	
	public Course toCourse() {
		return new Course(id, nomeCorso, capienza, iscrizioniMin, finanziato, 
				new Aula(idAulaPreferita, null, null, null, null), dataDiInizio);
	}

	public String getDataInizio() {
		return dataDiInizio;
	}
	public void setDataDiInizio(String data) {
	}
}
