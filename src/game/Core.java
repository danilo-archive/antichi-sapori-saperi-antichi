package game;

public class Core
{
	public static final long serialVersionUID = 1L;
	int dado;
	int posgioc1=0;
	int posgioc2=0;
	int i;
	boolean turno;
	boolean winner;
	
	String[] domanda=new String[28];
	String[][] risposta=new String[28][4];//primo numero righe, secondo numero colonne
	
	public boolean randomStart()
	{
		i=(int) Math.round(Math.random());
		if(i==0) 
		{
			turno=false;
		}
		else if(i==1)
		{
			turno=true;
		}
		setDomanda();
		setRisposta();
		return turno;
	}
	
    public int lanciaDadoPlayer1()
    {
    	this.dado=(int)Math.round((Math.random()*5)+1);
    	System.out.println("E'usito il numero "+dado);
    	muoviGioc1(dado);
    	return posgioc1;
    }
    public int lanciaDadoPlayer2()
    {
    	this.dado=(int)Math.round((Math.random()*5)+1);
    	System.out.println("E'usito il numero "+dado);
    	muoviGioc2(dado);
    	return posgioc2;
    }
    
    public int getDado()
    {
    	return dado;
    }
    
    public void muoviGioc1(int d)
    {
    	this.posgioc1=posgioc1+d;
    	if(posgioc1>27) this.posgioc1=27;
    	System.out.println("P1, ora sei sulla casella "+posgioc1);
    }
    
    public void muoviGioc2(int d)
    {
    	this.posgioc2=posgioc2+d;
    	if(posgioc2>27) this.posgioc2=27;
    	System.out.println("P2, ora sei sulla casella "+posgioc2);
    }
    
    public int setPosgioc1(int pos)
    {
    	this.posgioc1=pos-dado;
    	System.out.println("P1,sei tornato sulla casella "+posgioc1);
    	return posgioc1;
    }
    
    public int setPosgioc2(int pos)
    {
    	this.posgioc2=pos-dado;
    	System.out.println("P2, sei tornato sulla casella "+posgioc2);
    	return posgioc2;
    }
    
    public String getDomanda(int posgioc)
    {
    	return domanda[posgioc];
    }
    public String getRisposta(int posgioc, int i)
    {
    	return risposta[posgioc][i];
    }
    
    public void setDomanda()
    {
    	domanda[1]="<html><p align=center>Per quale scopo venne costruito il lago d'Occhito?</p></html>";
    	domanda[2]="<html><p align=center>Qual è la particolarità dei sedili nel teatro di Pietrabbondante?</p></html>";
    	domanda[3]="<html><p align=center>Agnone è famosa per:</p></html>";
    	
    	domanda[5]="<html><p align=center>La zuppa alla santé va servita:</p></html>";
    	domanda[6]="<html><p align=center>In pizz e fogl cosa sono le fogl?</p></html>";
    	domanda[7]="<html><p align=center>La transumanza che avveniva sui tratturi é:</p></html>";
    	domanda[8]="<html><p align=center>La riserva MAB di Montedimezzo è situata in provincia:</p></html>";
    	domanda[9]="<html><p align=center>Quale dei seguenti piatti NON viene preparato in occasione della festa di San Giuseppe a Riccia:</p></html>";

    	domanda[11]="<html><p align=center>Per preparare gli spaghetti con la mollica viene usata la mollica di:</p></html>";
    	domanda[12]="<html><p align=center>Saepinum originariamente venne costruita:</p></html>";
    	domanda[13]="<html><p align=center>I Ri Sciusce che restavano dopo il falò di San Antonio venivano:</p></html>";
    	domanda[14]="<html><p align=center>Per la ricerca del tartufo in Molise vengono adoperati:</p></html>";
    	domanda[15]="<html><p align=center>Da chi venne costruito il castello Monforte a Campobasso?</p></html>";
    	domanda[16]="<html><p align=center>Il castello Svevo, quando venne costruito, aveva funzione:</p></html>";
    	domanda[17]="<html><p align=center>Per preparare l’Taccarill vengono impiegate le farine di:</p></html>";
    	
    	domanda[19]="<html><p align=center>La Rocca era:</p></html>";
    	domanda[20]="<html><p align=center>Tra questi ingredienti quali sono quelli fondamentali per la ricetta cacio e ova:</p></html>";
    	domanda[21]="<html><p align=center>La Tintilia del Molise rosso é un vino:</p></html>";
    	domanda[22]="<html><p align=center>Cosa sono Le Bangale?</p></html>";
    	domanda[23]="<html><p align=center>Il Parco Nazionale d'Abruzzo, Lazio e Molise é ricoperto principalmente da boschi di:</p></html>";
    	
    	domanda[25]="<html><p align=center>In seguito a quale terremoto Limosano fu gramente danneggiata:</p></html>";
    	domanda[26]="<html><p align=center>La ricetta della Bambola viene preparate nel periodo:</p></html>";
    	
    }
    public void setRisposta()
    {
    	risposta[1][1]="per irrigazione";
    	risposta[1][2]="per la pesca";
    	risposta[1][3]="per la caccia";
    	
    	risposta[2][1]="Erano anatomici";
    	risposta[2][2]="Erano simili a sgabelli";
    	risposta[2][3]="Erano in legno";
    	
    	risposta[3][1]="le campane e i caciocavalli";
    	risposta[3][2]="le campane e le mozzarelle";
    	risposta[3][3]="l'olio e i caciocavalli";
    	
    	
    	risposta[5][1]="bollente";
    	risposta[5][2]="calda";
    	risposta[5][3]="tiepida";
    	
    	risposta[6][1]="verza";
    	risposta[6][2]="insalata"; 
    	risposta[6][3]="foglie di quercia";
    	
    	risposta[7][1]="lo spostamento di greggi";
    	risposta[7][2]="una fiera";
    	risposta[7][3]="una passeggiata quotidiana";
    	
    	risposta[8][1]="di Isernia";
    	risposta[8][2]="di Campobasso";
    	risposta[8][3]="di Foggia";
    	
    	risposta[9][1]="pasta al pesto e ris cu’ latt";
    	risposta[9][2]="ris cu’ latt e pasta col tonno";
    	risposta[9][3]="cavzone e agrodolce";
    	
    	risposta[11][1]="pane raffermo";
    	risposta[11][2]="pane fresco";
    	risposta[11][3]="panettone";
    	
    	
    	risposta[12][1]="dai Sanniti";
    	risposta[12][2]="dai Romani";
    	risposta[12][3]="dagli Etruschi";
    	
    	risposta[13][1]="donati ai poveri e malati";
    	risposta[13][2]="venduti";
    	risposta[13][3]="buttati";
    	
    	risposta[14][1]="cani";
    	risposta[14][2]="cinghiali";
    	risposta[14][3]="strumenti elettronici";
    	
    	risposta[15][1]="Cola di Monforte";
    	risposta[15][2]="Giovanni di Monforte";
    	risposta[15][3]="Giovanni Savoia";
    	
    	risposta[16][1]="difensiva";
    	risposta[16][2]="residenziale";
    	risposta[16][3]="ornamentale";
    	
    	risposta[17][1]="mais e grano duro";
    	risposta[17][2]="mais e grano tenero";
    	risposta[17][3]="manitopa e cocco";
    	
    	
    	risposta[19][1]="un castello medievale";
    	risposta[19][2]="una rovina";
    	risposta[19][3]="una montagna";
    
    	risposta[20][1]="piselli, uova e formaggio";
    	risposta[20][2]="piselli, uova e salvia";
    	risposta[20][3]="fagioli, uova e lenticchie";
    	
    	risposta[21][1]="DOC";
    	risposta[21][2]="DOP";
    	risposta[21][3]="DOT";
    	
    	risposta[22][1]="Associazione Culturale";
    	risposta[22][2]="Canti Popolari";
    	risposta[22][3]="Un piatto tipico";
    	
    	risposta[23][1]="faggio";
    	risposta[23][2]="betulla";
    	risposta[23][3]="abete";
    	
    	
    	risposta[25][1]="2002";
    	risposta[25][2]="1980";
    	risposta[25][3]="2014";
    	
    	risposta[26][1]="pasquale";
    	risposta[26][2]="di carnevale";
    	risposta[26][3]="natalizio";
    }
}
