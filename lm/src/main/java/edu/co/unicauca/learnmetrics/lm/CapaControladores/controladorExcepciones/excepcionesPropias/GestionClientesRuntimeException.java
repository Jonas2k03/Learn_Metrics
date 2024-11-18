package edu.co.unicauca.learnmetrics.lm.CapaControladores.controladorExcepciones.excepcionesPropias;

import edu.co.unicauca.learnmetrics.lm.CapaControladores.controladorExcepciones.estructuraExcepciones.CodigoError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public abstract class GestionClientesRuntimeException extends RuntimeException {

  protected CodigoError codigoError;

  public abstract String formatException();
}
