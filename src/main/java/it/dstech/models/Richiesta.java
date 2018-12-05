package it.dstech.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity(name="richiesta")
@Table(name = "richiesta", schema = "richiesta_ferie")
public class Richiesta {

	@Id
	@GeneratedValue
	@SequenceGenerator (name = "id", allocationSize = 1, initialValue =1)
	private Long id;

	@DateTimeFormat(iso = ISO.DATE )
	@Column(name = "data_richiesta", nullable = false)
	private Date dataRichiesta;

	@DateTimeFormat(iso = ISO.DATE )
	@Column(name = "data_accetazione")
	private Date dataAccettazione;

	@DateTimeFormat(iso = ISO.DATE )
	@Column(name = "data_ultima_modifica")
	private Date dataUltimaModifica;

	@DateTimeFormat(iso = ISO.DATE )
	@Column(name = "data_rifiuto")
	private Date dataRifiuto;

	@DateTimeFormat(iso = ISO.DATE )
	@Column(name = "data_inizio", nullable = false)
	private Date dataInizio;

	@DateTimeFormat(iso = ISO.DATE )
	@Column(name = "data_fine")
	private Date dataFine;

	@NotNull(message = "Tipo richiesta non può essere null")
	@Column(name = "tipo_richiesta", nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoRichiesta tipoRichiesta;

	@Positive(message = "Le ore richieste devono essere  positive")
	@Column(name = "num_ore")
	private Integer numeroOre;


	@NotNull(message = "Stato richiesta non può essere null")
	@Enumerated(EnumType.STRING)
	@Column(name = "stato_richiesta")
	private StatoRichiesta statoRichiesta;


	@NotNull(message = "AnagraficaId non può essere null")
	@Column(name = "id_anagrafica", nullable = false)
	private Integer anagraficaId;


	@NotEmpty
	@NotNull(message = "Nome dipendete non può essere null")
	@Column(name = "nome", nullable = false)
	private String nome;


	@NotEmpty
	@NotNull(message = "Cognome dipendente non può essere null")
	@Column(name = "cognome", nullable = false)
	private String cognome;


	@NotEmpty
	@NotNull(message = "Project manager non può essere null")
	@Column(name = "projectManager", nullable = false)
	private String projectManager;

	@Column(name = "id_project_manager", nullable = false)
	private Long idProjectManager;

	@NotEmpty
	@NotNull(message = "Responsabile azienda non può essere null")
	@Column(name = "responsabileAziendale", nullable = false)
	private String responsabileAziendale;

	@Column(name = "id_resp_aziendale", nullable = false)
	private Long idRespAziendale;
	public Richiesta() {
	}
	
	@PrePersist
	void valorizzaDataRichiesta() {

		this.dataRichiesta = new Date();
	}


	public Date getDataRichiesta() {
		return dataRichiesta;
	}

	public void setDataRichiesta(Date dataRichiesta) {
		this.dataRichiesta = dataRichiesta;
	}

	public Date getDataAccettazione() {
		return dataAccettazione;
	}

	public void setDataAccettazione(Date dataAccettazione) {
		this.dataAccettazione = dataAccettazione;
	}

	public Date getDataUltimaModifica() {
		return dataUltimaModifica;
	}

	public void setDataUltimaModifica(Date dataUltimaModifica) {
		this.dataUltimaModifica = dataUltimaModifica;
	}

	public Date getDataRifiuto() {
		return dataRifiuto;
	}

	public void setDataRifiuto(Date dataRifiuto) {
		this.dataRifiuto = dataRifiuto;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public Integer getNumeroOre() {
		return numeroOre;
	}

	public void setNumeroOre(Integer numeroOre) {
		this.numeroOre = numeroOre;
	}

	public TipoRichiesta getTipoRichiesta() {
		return tipoRichiesta;
	}

	public void setTipoRichiesta(TipoRichiesta tipoRichiesta) {
		this.tipoRichiesta = tipoRichiesta;
	}

	public StatoRichiesta getStatoRichiesta() {
		return statoRichiesta;
	}

	public void setStatoRichiesta(StatoRichiesta statoRichiesta) {
		this.statoRichiesta = statoRichiesta;
	}

	public Integer getAnagraficaId() {
		return anagraficaId;
	}

	public void setAnagraficaId(Integer anagraficaId) {
		this.anagraficaId = anagraficaId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}

	public String getResponsabileAziendale() {
		return responsabileAziendale;
	}

	public void setResponsabileAziendale(String responsabileAziendale) {
		this.responsabileAziendale = responsabileAziendale;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdProjectManager() {
		return idProjectManager;
	}
	public void setIdProjectManager(Long idProjectManager) {
		this.idProjectManager = idProjectManager;
	}
	public Long getIdRespAziendale() {
		return idRespAziendale;
	}
	public void setIdRespAziendale(Long idRespAziendale) {
		this.idRespAziendale = idRespAziendale;
	}
	@Override
	public String toString() {
		return "Richiesta [dataRichiesta=" + dataRichiesta + ", dataAccettazione=" + dataAccettazione
				+ ", dataUltimaModifica=" + dataUltimaModifica + ", dataRifiuto=" + dataRifiuto + ", dataInizio="
				+ dataInizio + ", dataFine=" + dataFine + ", tipoRichiesta=" + tipoRichiesta + ", numeroOre="
				+ numeroOre + ", statoRichiesta=" + statoRichiesta + ", anagraficaId=" + anagraficaId + ", nome=" + nome
				+ ", cognome=" + cognome + ", projectManager=" + projectManager + ", responsabileAziendale="
				+ responsabileAziendale + "]";
	}



}
