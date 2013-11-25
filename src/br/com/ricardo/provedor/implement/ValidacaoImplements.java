package br.com.ricardo.provedor.implement;

import br.com.ricardo.provedor.persistencia.dao.ValidacaoDAO;
import java.util.InputMismatchException;

/**
 * www.tecnokernel.com.br
 *
 * @author Ricardo Benedet Garcia rbg_info@hotmail.com
 */
public class ValidacaoImplements implements ValidacaoDAO{

    
    
    
    @Override
    public boolean validaCNPJ(String strCNPJ) {
    int iSoma = 0, iDigito;
    char[] chCaracteresCNPJ;
    String strCNPJ_Calculado;
 
    if (! strCNPJ.substring(0,1).equals("")){
        try{
            strCNPJ=strCNPJ.replace('.',' ');
            strCNPJ=strCNPJ.replace('/',' ');
            strCNPJ=strCNPJ.replace('-',' ');
            strCNPJ=strCNPJ.replaceAll(" ","");
            strCNPJ_Calculado = strCNPJ.substring(0,12);
            if ( strCNPJ.length() != 14 ) return false;
            chCaracteresCNPJ = strCNPJ.toCharArray();
            for(int i = 0; i < 4; i++) {
                if ((chCaracteresCNPJ[i]-48 >= 0) && (chCaracteresCNPJ[i]-48 <= 9)) {
                    iSoma += (chCaracteresCNPJ[i] - 48 ) * (6 - (i + 1)) ;
                }
            }
            for( int i = 0; i < 8; i++ ) {
                if ((chCaracteresCNPJ[i+4]-48 >= 0) && (chCaracteresCNPJ[i+4]-48 <= 9)) {
                    iSoma += (chCaracteresCNPJ[i+4] - 48 ) * (10 - (i + 1)) ;
                }
            }
            iDigito = 11 - (iSoma % 11);
            strCNPJ_Calculado += ((iDigito == 10) || (iDigito == 11)) ? "0" : Integer.toString(iDigito);
               /* Segunda parte */
            iSoma = 0;
            for (int i = 0; i < 5; i++) {
                if ((chCaracteresCNPJ[i]-48 >= 0) && (chCaracteresCNPJ[i]-48 <= 9)) {
                    iSoma += (chCaracteresCNPJ[i] - 48) * (7 - (i + 1)) ;
                }
            }
            for (int i = 0; i < 8; i++) {
                if ((chCaracteresCNPJ[i+5]-48 >= 0) && (chCaracteresCNPJ[i+5]-48 <= 9)) {
                    iSoma += (chCaracteresCNPJ[i+5] - 48) * (10 - (i + 1)) ;
                }
            }
            iDigito = 11 - (iSoma % 11);
            strCNPJ_Calculado += ((iDigito == 10) || (iDigito == 11)) ? "0" : Integer.toString(iDigito);
            return strCNPJ.equals(strCNPJ_Calculado);
        } catch (Exception e) {
            return false;
        }
    } else return false;
}

    @Override
    public boolean validaCPF(String CPF) {
          // considera-se erro CPF's formados por uma sequencia de numeros iguais 
        if (CPF.equals("00000000000") || CPF.equals("11111111111")
                || CPF.equals("22222222222") || CPF.equals("33333333333")
                || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777")
                || CPF.equals("88888888888") || CPF.equals("99999999999")
                || (CPF.length() != 11)) {
            return (false);
        }

        char dig10, dig11;
        int sm, i, r, num, peso;
        
        try {
            // Calculo do 1o. Digito Verificador 
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                // converte o i-esimo caractere do CPF em um numero: 
                // por exemplo, transforma o caractere '0' no inteiro 0 
                // (48 eh a posicao de '0' na tabela ASCII) 
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48);
            }
            // converte no respectivo caractere numerico
            // Calculo do 2o. Digito Verificador 
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (CPF.charAt(i) - 48);
            
            sm = sm + (num * peso);
            peso = peso - 1;
        }
        r = 11 - (sm % 11);
        if ((r == 10) || (r == 11)) 
            dig11 = '0';
         else 
            dig11 = (char) (r + 48);
            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) 
                return (true);
        else 
                return (false);
        }catch (InputMismatchException erro ) { 
    return (false);
    }
  }

    @Override
    public boolean validaCTPS(String strPIS) {
        
    char i, j, somatorio = 0;
    char chDigitoVerificador;
    char chPISAux;
 
    try{
        for (i = 0, j = 4; j >= 2; i++, j--)
            somatorio += ((strPIS.charAt(i) - 0x30) * j);
        for (j = 9; j >= 2; i++, j--)
            somatorio += ((strPIS.charAt(i) - 0x30) * j);
        if (( somatorio % 11 ) < 2) {
            chDigitoVerificador = 0;
        } else {
            chDigitoVerificador = (char)(11 - ( somatorio % 11 ));
        }
        chPISAux = (char)(chDigitoVerificador+'0');
        if (strPIS.charAt(11) == chPISAux)
            return true;
        else
            return false;
    } catch (Exception e) {
        return false;
    }
}
}
