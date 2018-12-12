
CREATE SCHEMA IF NOT EXISTS  ProtoSys  ;
USE  ProtoSys  ;

CREATE TABLE departamento  (
   iddepartamento  INT NOT NULL AUTO_INCREMENT,
   descricao  VARCHAR(255) NOT NULL,
  PRIMARY KEY ( iddepartamento ) 
  );

CREATE TABLE    usuario  (
   idusuario  INT NOT NULL AUTO_INCREMENT,,
   nome  VARCHAR(255) NOT NULL,
   sobrenome  VARCHAR(255) NOT NULL,
   email  VARCHAR(255) NOT NULL,
   senha  VARCHAR(255) NOT NULL,
   departamento  INT NOT NULL,
  PRIMARY KEY ( idusuario )
  
);


CREATE TABLE movimentacoes  (
   idmovimentacoes  INT NOT NULL AUTO_INCREMENT,
   observacao  VARCHAR(255) NULL,
   dataMovimentacao  DATE NULL,
  PRIMARY KEY ( idmovimentacoes )
  );


CREATE TABLE tipoDocumento  (
   idtipodocumento  INT NOT NULL AUTO_INCREMENT,
   nome  VARCHAR(255) NOT NULL,
  PRIMARY KEY ( idtipodocumento  )
  );

CREATE TABLE documento(
   iddocumento  INT NOT NULL AUTO_INCREMENT,
   descricao VARCHAR(255) NOT NULL,
  PRIMARY KEY ( iddocumento )
  );


CREATE TABLE protocolo  (
   idprotocolo  INT NOT NULL AUTO_INCREMENT,
   remetente  VARCHAR(255) NOT NULL,
   destinatario  VARCHAR(255) NOT NULL,
   movimentacoes  INT NOT NULL,
   TIPOdocumento  INT NOT NULL,
   Usuario  INT NOT NULL,
  PRIMARY KEY ( idprotocolo )
  
  );
ALTER TABLE usuario ADD CONSTRAINT  fk_Usuario_departamento1 FOREIGN KEY ( departamento ) REFERENCES   departamento  ( iddepartamento );
ALTER TABLE protocolo ADD  CONSTRAINT  fk_protocolo_movimentacoes1 FOREIGN KEY ( movimentacoes )REFERENCES movimentacoes  ( idmovimentacoes );
ALTER TABLE protocolo ADD  CONSTRAINT  fk_protocolo_TIPOdocumento1 FOREIGN KEY ( tipoDocumento  )REFERENCES tipoDocumento  ( idtipodocumento  );
ALTER TABLE protocolo ADD  CONSTRAINT  fk_protocolo_documento1 FOREIGN KEY ( documento) REFERENCES documento( iddocumento);
ALTER TABLE protocolo ADD CONSTRAINT  fk_protocolo_Usuario1 FOREIGN KEY ( Usuario )REFERENCES Usuario  ( idusuario );
