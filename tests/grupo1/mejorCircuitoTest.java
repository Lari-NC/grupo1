package grupo1;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import grupo1.Terminal; SE SACA??
import grupo1.circuito.Circuito;
import grupo1.circuito.Tramo;
import grupo1.mejorCircuito.MenorCantidadTerminales;
import grupo1.mejorCircuito.MenorPrecio;
import grupo1.mejorCircuito.MenorTiempo;
import grupo1.mejorCircuito.Naviera;

class mejorCircuitoTest {
		
		private Naviera naviera;
		private MenorTiempo buscadorMenorTiempo;
		private MenorPrecio buscadorMenorPrecio;
		private MenorCantidadTerminales buscadorMenorCantidadTerminales;
		
		private Terminal bsAs;
		private Terminal ush;
		private Terminal valp;
		private Terminal syd;
		private Terminal rio;
		private Terminal ind;
		private Terminal sudAf;
		private Terminal uru;
			
		private Circuito circuitoA; //bsAs-india mas rapido a sydney
			private Tramo tramoBsAs_Ush; 	//bsAs
			private Tramo tramoUsh_Valp;
			private Tramo tramoValp_SydA; 	//syd
			private Tramo tramoSyd_Ind;

		private Circuito circuitoB; //bra-sydney mas corto
			private Tramo tramoRio_BsAS;
			private Tramo tramoBsAS_Valp; 	//bsas
			private Tramo tramoValp_Syd;  	//syd
		
		private Circuito circuitoC; // bsAs-sydney mas barato
			private Tramo tramoBsAS_Uru;	//bsAs
			private Tramo tramoUru_SudAf;
			private Tramo tramoSudAf_Syd;	//syd
			
		@BeforeEach
		void setUp() throws Exception {
			
			this.bsAs = mock(Terminal.class);
	        this.ush = mock(Terminal.class);
	        this.valp = mock(Terminal.class);
	        this.syd = mock(Terminal.class);
	        this.rio = mock(Terminal.class);
	        this.ind = mock(Terminal.class);
	        this.sudAf = mock(Terminal.class);
	        this.uru = mock(Terminal.class);
	        
	        this.circuitoA = new Circuito(LocalDate.of(2023, 01, 15));
	        	
	        	this.tramoBsAs_Ush = new Tramo(bsAs,ush,5,10000);
		        this.tramoUsh_Valp = new Tramo(ush,valp,5,10000);
		        this.tramoValp_SydA = new Tramo(valp,syd,5,15000);
		        this.tramoSyd_Ind = new Tramo(syd,ind,8,16000);
		        //mas rapido
		        //15 dias entre bs a sydney
		        //3 tramos/2 terminales intermedias
		        //$35.000
		        
				    this.circuitoA.addTramo(tramoBsAs_Ush);
				    this.circuitoA.addTramo(tramoUsh_Valp);
				    this.circuitoA.addTramo(tramoValp_SydA);
				    this.circuitoA.addTramo(tramoSyd_Ind);
		     
	        this.circuitoB = new Circuito(LocalDate.of(2023, 02, 15));
		        this.tramoRio_BsAS = new Tramo(rio,bsAs,5,5000);
		        this.tramoBsAS_Valp = new Tramo(bsAs, valp,25,25000);
		        this.tramoValp_Syd = new Tramo(valp, syd, 15,15000);
		        //menosTerminales
		        //40 dias entre bs a sydney
		        //2 tramos/1 terminal intermedia
		        //$40.000
		        
			        this.circuitoB.addTramo(tramoRio_BsAS);
			        this.circuitoB.addTramo(tramoBsAS_Valp);
			        this.circuitoB.addTramo(tramoValp_Syd);

	        this.circuitoC = new Circuito(LocalDate.of(2023, 03, 15));
		        this.tramoBsAS_Uru = new Tramo(bsAs,uru,3,3000);
		        this.tramoUru_SudAf = new Tramo(uru,sudAf,10,10000);
		        this.tramoSudAf_Syd = new Tramo(sudAf,syd,11,11000);
		        //masBarato
		        //24 dias entre bs a sydney
		        //2 tramos/1 terminal intermedia
		        //$24.000
			        this.circuitoC.addTramo(tramoBsAS_Uru);
			        this.circuitoC.addTramo(tramoUru_SudAf);
			        this.circuitoC.addTramo(tramoSudAf_Syd);
			        
			 this.buscadorMenorTiempo = new MenorTiempo();
			 this.buscadorMenorPrecio = new MenorPrecio();
			 this.buscadorMenorCantidadTerminales = new MenorCantidadTerminales();
			 
			 this.naviera = new Naviera(buscadorMenorTiempo);
			 this.naviera.addCircuito(circuitoA);
			 this.naviera.addCircuito(circuitoB);
			 this.naviera.addCircuito(circuitoC);
			 
	        
		}

		@Test
		public void unaTerminalTieneUnBuscadorDeMejorCircuito() {
			
			assertEquals(this.naviera.getBuscador(),this.buscadorMenorTiempo);
		}
		
		@Test
		public void seLePuedeCambiarElBuscadorAUnaNaviera() {
			
			naviera.setBuscador(buscadorMenorCantidadTerminales);
			
			assertEquals(this.naviera.getBuscador(),this.buscadorMenorCantidadTerminales);
		}
		
		@Test
		public void sePuedeSaberCualEsElMejorCircuitoDeBuenosAiresASydneyMAS_RAPIDO() {
			
			assertEquals(this.naviera.getBuscador(),this.buscadorMenorTiempo);
			Circuito mejorCircuito = naviera.buscarMejorCircuitoQueConecta(bsAs, syd);
			assertEquals(mejorCircuito,circuitoA);
		}
		
		@Test
		public void sePuedeSaberCualEsElMejorCircuitoDeBuenosAiresASydneyMAS_CORTO() {
			
			naviera.setBuscador(buscadorMenorCantidadTerminales);
			assertEquals(this.naviera.getBuscador(),this.buscadorMenorCantidadTerminales);
			
			Circuito mejorCircuito = naviera.buscarMejorCircuitoQueConecta(bsAs, syd);
			assertEquals(mejorCircuito,circuitoB);
		}
		
		@Test
		public void sePuedeSaberCualEsElMejorCircuitoDeBuenosAiresASydneyMAS_BARATO() {
			
			naviera.setBuscador(buscadorMenorPrecio);
			assertEquals(this.naviera.getBuscador(),this.buscadorMenorPrecio);
			
			Circuito mejorCircuito = naviera.buscarMejorCircuitoQueConecta(bsAs, syd);
			assertEquals(mejorCircuito,circuitoC);
		}

	}

