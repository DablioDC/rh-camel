package br.com.unicoob.domain.model;

import br.com.unicoob.domain.dto.FuncionarioApiDTO;
import br.com.unicoob.domain.type.OperationType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rh_operation_log", catalog = "DataTransaction", schema = "camel")
public class RhOperationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "db_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dbTime;

    @Column(name = "operation", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private OperationType operation;

    @Column(name = "numemp", nullable = false)
    private Integer numemp;

    @Column(name = "numcad")
    private Integer numcad;

    @Column(name = "nomfun", nullable = false, length = 80)
    private String nomfun;

    @Column(name = "numcpf", nullable = false)
    private Long numcpf;

    @Column(name = "login", length = 40)
    private String login;

    @Column(name = "incident", length = 18)
    private String incident;

    @Column(name = "operatorGroup")
    private String operatorGroup;

    public RhOperationLog() {

    }

    public RhOperationLog(FuncionarioApiDTO funcionario, OperationType operation, String incident, String operatorGroup) {
        this.dbTime = new Date();
        this.operation = operation;
        this.numemp = funcionario.getCooperativa().getCooperativa();
        this.numcad = Integer.valueOf(funcionario.getMatricula());
        this.nomfun = funcionario.getNomeCompleto();
        this.numcpf = Long.valueOf(funcionario.getCpf());
        this.login = funcionario.getLoginAd();
        this.incident = incident;
        this.operatorGroup = operatorGroup;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDbTime() {
        return dbTime;
    }

    public void setDbTime(Date dbTime) {
        this.dbTime = dbTime;
    }

    public OperationType getOperation() {
        return operation;
    }

    public void setOperation(OperationType operation) {
        this.operation = operation;
    }

    public Integer getNumemp() {
        return numemp;
    }

    public void setNumemp(Integer numemp) {
        this.numemp = numemp;
    }

    public Integer getNumcad() {
        return numcad;
    }

    public void setNumcad(Integer numcad) {
        this.numcad = numcad;
    }

    public String getNomfun() {
        return nomfun;
    }

    public void setNomfun(String nomfun) {
        this.nomfun = nomfun;
    }

    public Long getNumcpf() {
        return numcpf;
    }

    public void setNumcpf(Long numcpf) {
        this.numcpf = numcpf;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getIncident() {
        return incident;
    }

    public void setIncident(String incident) {
        this.incident = incident;
    }

    public String getOperatorGroup() {
        return operatorGroup;
    }

    public void setOperatorGroup(String operatorGroup) {
        this.operatorGroup = operatorGroup;
    }
}