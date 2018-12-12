
import Usuarios.Usuarios;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author NVIDIA
 */
@Entity
public class Protocolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idprotocolo;

    @ManyToOne
    Movimentacoes movimentacoes;
    @ManyToOne
    TipoDocumento tipodocumento;
    @ManyToOne
    Documento documento;
    @ManyToOne
    Usuarios usuarioid;
    @ManyToOne
    Usuarios destinatario;
    @ManyToOne
    Usuarios remetente;
}
