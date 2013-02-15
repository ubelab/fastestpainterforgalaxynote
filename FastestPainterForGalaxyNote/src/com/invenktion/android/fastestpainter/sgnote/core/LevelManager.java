package com.invenktion.android.fastestpainter.sgnote.core;

import java.util.ArrayList;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.BitmapFactory.Options;

import com.invenktion.android.fastestpainter.sgnote.bean.AmmoBean;
import com.invenktion.android.fastestpainter.sgnote.bean.PictureBean;
import com.invenktion.android.fastestpainter.sgnote.bean.SectionArrayList;
import com.invenktion.android.fastestpainter.sgnote.R;


public class LevelManager {
	private static int currentLevel = 0;
	//Lista di tutte le sezioni
	private static ArrayList<SectionArrayList> sections = new ArrayList<SectionArrayList>();
	//La sezione del gioco corrente, cambierà a runtime con una reference ad una delle liste sotto.
	private static SectionArrayList<PictureBean> currentSection;
	private static SectionArrayList<PictureBean> firstSection = new SectionArrayList<PictureBean>();
	private static SectionArrayList<PictureBean> secondSection = new SectionArrayList<PictureBean>();
	private static SectionArrayList<PictureBean> thirdSection = new SectionArrayList<PictureBean>();
	private static SectionArrayList<PictureBean> fourthSection = new SectionArrayList<PictureBean>();
	private static SectionArrayList<PictureBean> fifthSection = new SectionArrayList<PictureBean>();
	private static SectionArrayList<PictureBean> sixthSection = new SectionArrayList<PictureBean>();
	//Sezione BONUS: è al di fuori delle modalità di gioco! Ogni quadro è indipendente.
	private static SectionArrayList<PictureBean> bonusSection = new SectionArrayList<PictureBean>();
	//Sezione SOLO in ATELIER: è al di fuori delle modalità di gioco! Si vedono sempre e solo nell'atelier, come quadri diprova.
	private static SectionArrayList<PictureBean> plusAtelierSection = new SectionArrayList<PictureBean>();

	public static void initializeLevels(Context context) {
		currentLevel = -1;
		
		sections.clear();
		sections.add(firstSection);
		sections.add(secondSection);
		sections.add(thirdSection);
		sections.add(fourthSection);
		sections.add(fifthSection);
		sections.add(sixthSection);
		sections.add(bonusSection);
		sections.add(plusAtelierSection);
		
		//##########################################################
		//####################  QUADRI DI PROVA ATELIER ############
		//##########################################################
		plusAtelierSection.setSectionName("Atelier");
		plusAtelierSection.setStoryboardImage(R.drawable.sec1storyboard);
		plusAtelierSection.setSfondoImage(R.drawable.sfondo1);
		/*
		plusAtelierSection.setNumber(0);
		plusAtelierSection.setBossResourceNormal(R.drawable.sec1start);
		plusAtelierSection.setBossResourceSuccess(R.drawable.sec1ok);
		plusAtelierSection.setBossResourceFailure(R.drawable.sec1failed);
		plusAtelierSection.setPresentationImage(R.drawable.sec1presentation);
		plusAtelierSection.setLockedImage(R.drawable.sec1locked);
		plusAtelierSection.setTelaImage(R.drawable.tela1);
		plusAtelierSection.setCorniceImage(R.drawable.cornici1);
		*/
		plusAtelierSection.clear();
		plusAtelierSection.add(new PictureBean("mela",context.getString(R.string.apple),R.drawable.mela,R.drawable.mela_tr,new int[] {
				Color.rgb(218, 17, 17),
				Color.rgb(79, 143, 40),
				Color.rgb(129, 67, 12)},
				31000,true,99));
		plusAtelierSection.add(new PictureBean("banana",context.getString(R.string.banana),R.drawable.banane,R.drawable.banane_tr,new int[] {
				Color.rgb(249, 176, 6),
				Color.rgb(120, 138, 18)},
				31000,true,97));
		plusAtelierSection.add(new PictureBean("cocco",context.getString(R.string.cocco),R.drawable.cocco,R.drawable.cocco_tr,new int[] {
				Color.rgb(175, 110, 16),
				Color.rgb(110, 67, 6)},
				31000,true,98));
		plusAtelierSection.add(new PictureBean("uva",context.getString(R.string.uva),R.drawable.uva,R.drawable.uva_tr,new int[] {
				Color.rgb(170, 14, 176),
				Color.rgb(147, 193, 7),
				Color.rgb(104, 75, 13)},
				31000,true,95));
		plusAtelierSection.add(new PictureBean("lemon",context.getString(R.string.limone),R.drawable.lemon,R.drawable.lemon_tr,new int[] {
				Color.rgb(242, 217, 3),
				Color.rgb(248, 240, 176)},
				31000,true,98));
		plusAtelierSection.add(new PictureBean("ciliegie",context.getString(R.string.ciliegia),R.drawable.ciliegie,R.drawable.ciliegie_tr,new int[] {
				Color.rgb(222, 0, 26)},
				31000,true,99));
		
		//##########################################################
		//####################  1 SEZIONE ##########################
		//##########################################################
		firstSection.setSectionName("Big Boss");
		firstSection.setNumber(0);
		firstSection.setStoryboardImage(R.drawable.sec1storyboard);
		firstSection.setBossResourceNormal(R.drawable.sec1start);
		firstSection.setBossResourceSuccess(R.drawable.sec1ok);
		firstSection.setBossResourceFailure(R.drawable.sec1failed);
		firstSection.setPresentationImage(R.drawable.sec1presentation);
		firstSection.setLockedImage(R.drawable.sec1locked);
		firstSection.setTelaImage(R.drawable.tela1);
		firstSection.setCorniceImage(R.drawable.cornici1);
		firstSection.setSfondoImage(R.drawable.sfondo1);
		firstSection.clear();
		
		firstSection.add(new PictureBean("ritrattovanghog",context.getString(R.string.ritrattovanghog),R.drawable.ritratto_van_gogh,R.drawable.ritratto_van_gogh_tr,new int[] {
				Color.rgb(116, 150, 188),
				Color.rgb(250, 156, 23),
				Color.rgb(254, 236, 205)},
				21000,true,94));
		firstSection.add(new PictureBean("medusa",context.getString(R.string.medusa),R.drawable.medusa,R.drawable.medusa_tr,new int[] {
				Color.rgb(220, 3, 49),
				Color.rgb(243, 214, 186),
				Color.rgb(130, 181, 89)},
				21000,false,91));
		firstSection.add(new PictureBean("ermellino",context.getString(R.string.ermellino),R.drawable.ermellino,R.drawable.ermellino_tr,new int[] {
				Color.rgb(202, 123, 39),
				Color.rgb(252, 224, 227),
				Color.rgb(85, 127, 98),
				Color.rgb(176, 59, 70),
				Color.rgb(206, 206, 206)},
				21000,false,99));
		firstSection.add(new PictureBean("gioconda",context.getString(R.string.gioconda),R.drawable.gioconda,R.drawable.gioconda_tr,new int[] {
				Color.rgb(140, 86, 62),
				Color.rgb(244, 205, 210),
				Color.rgb(229, 16, 66),
				Color.rgb(173, 149, 154),
				Color.rgb(197, 194, 255)},
				21000,false,98));
		firstSection.add(new PictureBean("vitruvian",context.getString(R.string.vitruvian),R.drawable.vitruvian,R.drawable.vitruvian_tr,new int[] {
				Color.rgb(87, 73, 57),
				Color.rgb(251, 204, 154),
				Color.rgb(62, 140, 24)},
				21000,false,99));
		firstSection.add(new PictureBean("starrynight",context.getString(R.string.starrynight),R.drawable.starrynight,R.drawable.starrynight_tr,new int[] {
				Color.rgb(58, 97, 184),
				Color.rgb(127, 157, 225),
				Color.rgb(241, 189, 31),
				Color.rgb(51, 111, 10)},
				31000,false,97));
		firstSection.add(new PictureBean("youngman",context.getString(R.string.youngman),R.drawable.youngman,R.drawable.youngman_tr,new int[] {
				Color.rgb(72, 72, 72),
				Color.rgb(214, 162, 107),
				Color.rgb(245, 199, 177)},
				16000,false,98));

		firstSection.add(new PictureBean("tregrazie",context.getString(R.string.tregrazie),R.drawable.tre_grazie,R.drawable.tre_grazie_tr,new int[] {
				Color.rgb(255, 225, 225),
				Color.rgb(248, 187, 3),
				Color.rgb(188, 107, 53)},
				21000,false,93));
		firstSection.add(new PictureBean("carlosettimo",context.getString(R.string.carlosettimo),R.drawable.carlo_7,R.drawable.carlo_7_tr,new int[] {
				Color.rgb(144, 62, 48),
				Color.rgb(226, 103, 83),
				Color.rgb(253, 210, 203)},
				16000,false,96));
		firstSection.add(new PictureBean("girasolivangog",context.getString(R.string.girasolivangog),R.drawable.girasolivangogh,R.drawable.girasolivangogh_tr,new int[] {
				Color.rgb(255, 180, 0),
				Color.rgb(245, 208, 120),
				Color.rgb(123, 174, 43)},
				21000,false,96));
		
		
		//##########################################################
		//####################  2 SEZIONE ##########################
		//##########################################################
		secondSection.setSectionName("Jean-Luis Baguette");
		secondSection.setNumber(1);
		secondSection.setStoryboardImage(R.drawable.sec2storyboard);
		secondSection.setBossResourceNormal(R.drawable.sec2start);
		secondSection.setBossResourceSuccess(R.drawable.sec2ok);
		secondSection.setBossResourceFailure(R.drawable.sec2failed);
		secondSection.setPresentationImage(R.drawable.sec2presentation);
		secondSection.setLockedImage(R.drawable.sec2locked);
		secondSection.setTelaImage(R.drawable.tela2);
		secondSection.setCorniceImage(R.drawable.cornici2);
		secondSection.setSfondoImage(R.drawable.sfondo2);
		secondSection.clear();
		secondSection.add(new PictureBean("napoleonealpi",context.getString(R.string.napoleonealpi),R.drawable.napoleonealpi,R.drawable.napoleonealpi_tr,new int[] {
				Color.rgb(113, 149, 251),
				Color.rgb(235, 0, 0),
				Color.rgb(247, 223, 196),
				Color.rgb(137, 58, 23),
				Color.rgb(240, 234, 222)},
				31000,true,88));
		secondSection.add(new PictureBean("ficodindaio",context.getString(R.string.ficodindaio),R.drawable.ficodindaio,R.drawable.ficodindaio_tr,new int[] {
				Color.rgb(255, 139, 46),
				Color.rgb(255, 215, 167),
				Color.rgb(187, 119, 52),
				Color.rgb(223, 244, 249)},
				16000,false,88));
		secondSection.add(new PictureBean("baccogiovane",context.getString(R.string.baccogiovane),R.drawable.baccogiovane,R.drawable.baccogiovane_tr,new int[] {
				Color.rgb(251, 229, 185),
				Color.rgb(220, 241, 243),
				Color.rgb(172, 195, 126)},
				21000,false,91));
		secondSection.add(new PictureBean("nascitavenere",context.getString(R.string.nascitavenere),R.drawable.nascitavenere,R.drawable.nascitavenere_tr,new int[] {
				Color.rgb(229, 174, 86),
				Color.rgb(255, 173, 133),
				Color.rgb(255, 228, 208),
				Color.rgb(216, 236, 244)},
				31000,false,96));
		
		secondSection.add(new PictureBean("venereurbino",context.getString(R.string.venereurbino),R.drawable.venere_urbino,R.drawable.venere_urbino_tr,new int[] {
				Color.rgb(239, 203, 152),
				Color.rgb(221, 144, 160),
				Color.rgb(224, 244, 246),
				Color.rgb(230, 111, 14)},
				16000,false,92));
		secondSection.add(new PictureBean("duchessaurbino",context.getString(R.string.duchessaurbino),R.drawable.ritratto_duchessa_urbino,R.drawable.ritratto_duchessa_urbino_tr,new int[] {
				Color.rgb(248, 231, 208),
				Color.rgb(154, 151, 148),
				Color.rgb(208, 149, 66)},
				16000,false,95));
	
		secondSection.add(new PictureBean("morsoramarro",context.getString(R.string.morsoramarro),R.drawable.morsoramarro,R.drawable.morsoramarro_tr,new int[] {
				Color.rgb(160, 29, 51),
				Color.rgb(192, 236, 247),
				Color.rgb(121, 168, 100),
				Color.rgb(255, 222, 184),
				Color.rgb(130, 88, 14)},
				21000,false,95));
		secondSection.add(new PictureBean("giardiniera",context.getString(R.string.giardiniera),R.drawable.giardiniera,R.drawable.giardiniera_tr,new int[] {
				Color.rgb(255, 222, 207),
				Color.rgb(231, 174, 0),
				Color.rgb(58, 90, 170),
				Color.rgb(212, 10, 10)},
				31000,false,91));
		secondSection.add(new PictureBean("sognosantelena",context.getString(R.string.sognosantelena),R.drawable.sogno_santelena,R.drawable.sogno_santelena_tr,new int[] {
				Color.rgb(236, 187, 17),
				Color.rgb(255, 99, 5),
				Color.rgb(240, 205, 177),
				Color.rgb(193,147,81)},
				31000,false,90));
		
		
		//##########################################################
		//####################  3 SEZIONE ##########################
		//##########################################################
		thirdSection.setSectionName("The King");
		thirdSection.setNumber(2);
		thirdSection.setStoryboardImage(R.drawable.sec3storyboard);
		thirdSection.setBossResourceNormal(R.drawable.sec3start);
		thirdSection.setBossResourceSuccess(R.drawable.sec3ok);
		thirdSection.setBossResourceFailure(R.drawable.sec3failed);
		thirdSection.setPresentationImage(R.drawable.sec3presentation);
		thirdSection.setLockedImage(R.drawable.sec3locked);
		thirdSection.setTelaImage(R.drawable.tela3);
		thirdSection.setCorniceImage(R.drawable.cornici3);
		thirdSection.setSfondoImage(R.drawable.sfondo3);
		thirdSection.clear();
		
		thirdSection.add(new PictureBean("ritratto_federico",context.getString(R.string.ritratto_federico),R.drawable.ritratto_federico,R.drawable.ritratto_federico_tr,new int[] {
				Color.rgb(180, 47, 65),
				Color.rgb(244, 201, 182),
				Color.rgb(183, 178, 175)},
				16000,true,98));
		thirdSection.add(new PictureBean("eleonoratoledo",context.getString(R.string.eleonoratoledo),R.drawable.eleonora_toledo,R.drawable.eleonora_toledo_tr,new int[] {
				Color.rgb(214, 168, 78),
				Color.rgb(145, 170, 199),
				Color.rgb(251, 230, 212),
				Color.rgb(223, 6, 27),
				Color.rgb(113, 88, 39)},
				31000,false,95));
		thirdSection.add(new PictureBean("giannibattista",context.getString(R.string.giannibattista),R.drawable.john_the_batist,R.drawable.john_the_batist_tr,new int[] {
				Color.rgb(183, 151, 113),
				Color.rgb(247, 207, 207),
				Color.rgb(188, 107, 53)},
				16000,false,97));
		
		thirdSection.add(new PictureBean("supperemmaus",context.getString(R.string.supperemmaus),R.drawable.supperemmaus,R.drawable.supperemmaus_tr,new int[] {
				Color.rgb(144, 163, 55),
				Color.rgb(189, 16, 20),
				Color.rgb(146, 93, 36),
				Color.rgb(253, 225, 203)},
				31000,false,86));
		thirdSection.add(new PictureBean("autoritrattorembrant",context.getString(R.string.autoritrattorembrant),R.drawable.autoritrattorembrandth,R.drawable.autoritrattorembrandth_tr,new int[] {
				Color.rgb(138, 111, 80),
				Color.rgb(208, 148, 77),
				Color.rgb(250, 237, 207),
				Color.rgb(130, 118, 144)},
				21000,false,92));
		
		
		thirdSection.add(new PictureBean("mariamaddalena",context.getString(R.string.mariamaddalena),R.drawable.maria_maddalena,R.drawable.maria_maddalena_tr,new int[] {
				Color.rgb(209, 206, 197),
				Color.rgb(214, 0, 0),
				Color.rgb(249, 226, 213)},
				16000,false,96));
		thirdSection.add(new PictureBean("figliaherodias",context.getString(R.string.figliaherodias),R.drawable.figlia_herodias,R.drawable.figlia_herodias_tr,new int[] {
				Color.rgb(86, 119, 227),
				Color.rgb(223, 240, 201),
				Color.rgb(240, 205, 177),
				Color.rgb(156, 106, 57),
				Color.rgb(195, 59, 88)},
				21000,false,90));

		//##########################################################
		//####################  4 SEZIONE ##########################
		//##########################################################
		fourthSection.setSectionName("Big Moma");
		fourthSection.setNumber(3);
		fourthSection.setStoryboardImage(R.drawable.sec4storyboard);
		fourthSection.setBossResourceNormal(R.drawable.sec4start);
		fourthSection.setBossResourceSuccess(R.drawable.sec4ok);
		fourthSection.setBossResourceFailure(R.drawable.sec4failed);
		fourthSection.setPresentationImage(R.drawable.sec4presentation);
		fourthSection.setLockedImage(R.drawable.sec4locked);
		fourthSection.setTelaImage(R.drawable.tela4);
		fourthSection.setCorniceImage(R.drawable.cornici4);
		fourthSection.setSfondoImage(R.drawable.sfondo4);
		fourthSection.clear();
		
		fourthSection.add(new PictureBean("ragazzaorecchinoperla",context.getString(R.string.ragazzaorecchinoperla),R.drawable.ragazzaorecchinoperla,R.drawable.ragazzaorecchinoperla_tr,new int[] {
				Color.rgb(245, 176, 55),
				Color.rgb(248, 213, 185),
				Color.rgb(55, 133, 193),
				Color.rgb(245, 55, 91)},
				21000,false,96));
		fourthSection.add(new PictureBean("johnannfriendrick",context.getString(R.string.johnannfriendrick),R.drawable.johannfriedrich,R.drawable.johannfriedrich_tr,new int[] {
				Color.rgb(157, 188, 32),
				Color.rgb(254, 221, 182),
				Color.rgb(187, 106, 62),
				Color.rgb(216, 217, 210)},
				21000,false,86));
		fourthSection.add(new PictureBean("angeliraffaello",context.getString(R.string.angeliraffaello),R.drawable.angeliraffaello,R.drawable.angeliraffaello_tr,new int[] {
				Color.rgb(254, 228, 195),
				Color.rgb(204, 100, 43),
				Color.rgb(210, 149, 77)},
				21000,false,96));
		fourthSection.add(new PictureBean("giocatoricarte",context.getString(R.string.giocatoricarte),R.drawable.giocatori_carte,R.drawable.giocatori_carte_tr,new int[] {
				Color.rgb(183, 133, 83),
				Color.rgb(201, 187, 90),
				Color.rgb(246, 92, 8),
				Color.rgb(254, 211, 173)},
				31000,false,91));
		fourthSection.add(new PictureBean("sleepinggipsy",context.getString(R.string.sleepinggipsy),R.drawable.sleeping_gipsy,R.drawable.sleeping_gipsy_tr,new int[] {
				Color.rgb(163, 105, 30),
				Color.rgb(212, 155, 81),
				Color.rgb(213, 241, 242)},
				31000,false,87));
		fourthSection.add(new PictureBean("annazborowska",context.getString(R.string.annazborowska),R.drawable.annazborowska,R.drawable.annazborowska_tr,new int[] {
				Color.rgb(138, 6, 13),
				Color.rgb(29, 40, 72),
				Color.rgb(255, 219, 219),
				Color.rgb(59, 24, 12)},
				16000,false,98));
		fourthSection.add(new PictureBean("demoiselleavignon",context.getString(R.string.demoiselleavignon),R.drawable.demoiselleavignon,R.drawable.demoiselleavignon_tr,new int[] {
				Color.rgb(250, 225, 199),
				Color.rgb(146, 90, 30)},
				21000,false,92));
		fourthSection.add(new PictureBean("juanpareja",context.getString(R.string.juanpareja),R.drawable.juanpareja,R.drawable.juanpareja_tr,new int[] {
				Color.rgb(139, 142, 109),
				Color.rgb(233, 233, 233),
				Color.rgb(227, 165, 115),
				Color.rgb(54, 53, 53)},
				16000,false,97));
		fourthSection.add(new PictureBean("souvenirvojage",context.getString(R.string.souvenirvojage),R.drawable.souvenirvojage,R.drawable.souvenirvojage_tr,new int[] {
				Color.rgb(140, 214, 91),
				Color.rgb(93, 162, 96),
				Color.rgb(100, 190, 216)},
				16000,false,99));
		fourthSection.add(new PictureBean("uomobombetta",context.getString(R.string.uomobombetta),R.drawable.uomobombetta,R.drawable.uomobombetta_tr,new int[] {
				Color.rgb(91, 91, 91),
				Color.rgb(255, 61, 1),
				Color.rgb(253, 224, 184),
				Color.rgb(47, 221, 7)},
				21000,false,95));
		
		
		//##########################################################
		//####################  5 SEZIONE ##########################
		//##########################################################
		fifthSection.setSectionName("Enigmus");
		fifthSection.setNumber(4);
		fifthSection.setStoryboardImage(R.drawable.sec5storyboard);
		fifthSection.setBossResourceNormal(R.drawable.sec5start);
		fifthSection.setBossResourceSuccess(R.drawable.sec5ok);
		fifthSection.setBossResourceFailure(R.drawable.sec5failed);
		fifthSection.setPresentationImage(R.drawable.sec5presentation);
		fifthSection.setLockedImage(R.drawable.sec5locked);
		fifthSection.setTelaImage(R.drawable.tela5);
		fifthSection.setCorniceImage(R.drawable.cornici5);
		fifthSection.setSfondoImage(R.drawable.sfondo5);
		fifthSection.clear();
		
		fifthSection.add(new PictureBean("urlomunch",context.getString(R.string.urlomunch),R.drawable.urlo,R.drawable.urlo_tr,new int[] {
				Color.rgb(203, 192, 158),
				Color.rgb(104, 97, 97),
				Color.rgb(92, 131, 174),
				Color.rgb(251, 122, 71)},
				31000,false,97));
		fifthSection.add(new PictureBean("bernardobrembo",context.getString(R.string.bernardobrembo),R.drawable.bernardobrembo,R.drawable.bernardobrembo_tr,new int[] {
				Color.rgb(92, 92, 92),
				Color.rgb(211, 186, 111),
				Color.rgb(255, 224, 199)},
				21000,true,97));
		fifthSection.add(new PictureBean("marat",context.getString(R.string.marat),R.drawable.marat,R.drawable.marat_tr,new int[] {
				Color.rgb(129, 129, 129),
				Color.rgb(193, 152, 89),
				Color.rgb(248, 225, 189)},
				21000,false,91));
		fifthSection.add(new PictureBean("merylaurent",context.getString(R.string.merylaurent),R.drawable.mery_laurent,R.drawable.mery_laurent_tr,new int[] {
				Color.rgb(95, 96, 132),
				Color.rgb(255, 238, 245),
				Color.rgb(252, 155, 1),
				Color.rgb(129, 73, 39)},
				21000,false,96));
		fifthSection.add(new PictureBean("frida",context.getString(R.string.frida),R.drawable.frida,R.drawable.frida_tr,new int[] {
				Color.rgb(192, 28, 63),
				Color.rgb(254, 228, 197),
				Color.rgb(82, 82, 82)},
				16000,false,94));
		fifthSection.add(new PictureBean("americangothic",context.getString(R.string.americangothic),R.drawable.america_gothic,R.drawable.america_gothic_tr,new int[] {
				Color.rgb(108, 108, 108),
				Color.rgb(157, 63, 72),
				Color.rgb(235, 245, 251),
				Color.rgb(255, 219, 201),
				Color.rgb(218, 174, 21)},
				21000,false,87));
		fifthSection.add(new PictureBean("watteau",context.getString(R.string.watteau),R.drawable.watteau,R.drawable.watteau_tr,new int[] {
				Color.rgb(190, 190, 190),
				Color.rgb(169, 117, 50),
				Color.rgb(255, 238, 224)},
				16000,false,98));
		fifthSection.add(new PictureBean("bacioklimt",context.getString(R.string.bacioklimt),R.drawable.bacio_klimt,R.drawable.bacio_klimt_tr,new int[] {
				Color.rgb(0, 242, 11),
				Color.rgb(255, 222, 0),
				Color.rgb(252, 230, 230),
				Color.rgb(71, 71, 71),
				Color.rgb(238, 118, 0)},
				21000,false,91));
		fifthSection.add(new PictureBean("ritrattomonet",context.getString(R.string.ritrattomonet),R.drawable.ritratto_monet,R.drawable.ritratto_monet_tr,new int[] {
				Color.rgb(41, 63, 132),
				Color.rgb(255, 228, 192),
				Color.rgb(148, 85, 2)},
				16000,false,96));
		fifthSection.add(new PictureBean("tsunami",context.getString(R.string.tsunami),R.drawable.tsunami,R.drawable.tsunami_tr,new int[] {
				Color.rgb(112, 144, 235),
				Color.rgb(200, 165, 70)},
				21000,false,76));
		
		//##########################################################
		//####################  6 SEZIONE ##########################
		//##########################################################
		sixthSection.setSectionName("Joaquin Toreros");
		sixthSection.setNumber(5);
		sixthSection.setStoryboardImage(R.drawable.sec6storyboard);
		sixthSection.setBossResourceNormal(R.drawable.sec6start);
		sixthSection.setBossResourceSuccess(R.drawable.sec6ok);
		sixthSection.setBossResourceFailure(R.drawable.sec6failed);
		sixthSection.setPresentationImage(R.drawable.sec6presentation);
		sixthSection.setLockedImage(R.drawable.sec6locked);
		sixthSection.setTelaImage(R.drawable.tela6);
		sixthSection.setCorniceImage(R.drawable.cornici6);
		sixthSection.setSfondoImage(R.drawable.sfondo6);
		sixthSection.clear();
		
		sixthSection.add(new PictureBean("autoritratto",context.getString(R.string.autoritratto),R.drawable.autoritratto,R.drawable.autoritratto_tr,new int[] {
				Color.rgb(184, 141, 105),
				Color.rgb(144, 102, 68),
				Color.rgb(62, 44, 29),
				Color.rgb(233, 205, 205)},
				21000,false,95));
		sixthSection.add(new PictureBean("autoritrattovelasquez",context.getString(R.string.autoritrattovelasquez),R.drawable.autoritrattovelasquez,R.drawable.autoritrattovelasquez_tr,new int[] {
				Color.rgb(76, 47, 13),
				Color.rgb(247, 208, 208),
				Color.rgb(23, 38, 103)},
				21000,false,97));
		sixthSection.add(new PictureBean("colossus",context.getString(R.string.colossus),R.drawable.colossus,R.drawable.colossus_tr,new int[] {
				Color.rgb(76, 45, 24),
				Color.rgb(225, 174, 140),
				Color.rgb(191, 155, 132)},
				21000,false,96));
		sixthSection.add(new PictureBean("donna_collare_rosso",context.getString(R.string.donna_collare_rosso),R.drawable.donna_collare_rosso,R.drawable.donna_collare_rosso_tr,new int[] {
				Color.rgb(227, 58, 36),
				Color.rgb(6, 114, 98),
				Color.rgb(251, 242, 0)},
				21000,false,95));
		sixthSection.add(new PictureBean("duca_alba",context.getString(R.string.duca_alba),R.drawable.duca_alba,R.drawable.duca_alba_tr,new int[] {
				Color.rgb(163, 163, 163),
				Color.rgb(233, 205, 181),
				Color.rgb(196, 216, 214),
				Color.rgb(48, 48, 48),
				Color.rgb(199, 95, 44)},
				21000,false,92));
		sixthSection.add(new PictureBean("duchessa_alba",context.getString(R.string.duchessa_alba),R.drawable.duchessa_alba,R.drawable.duchessa_alba_tr,new int[] {
				Color.rgb(59, 59, 59),
				Color.rgb(236, 195, 195),
				Color.rgb(193, 5, 5),
				Color.rgb(227, 229, 239)},
				21000,false,95));
		sixthSection.add(new PictureBean("Filippo_armatura",context.getString(R.string.Filippo_armatura),R.drawable.filippo_armatura,R.drawable.filippo_armatura_tr,new int[] {
				Color.rgb(242, 134, 7),
				Color.rgb(236, 214, 200),
				Color.rgb(185, 198, 203),
				Color.rgb(242, 45, 7)},
				21000,false,91));
		sixthSection.add(new PictureBean("ritratto_mia_sorella",context.getString(R.string.ritratto_mia_sorella),R.drawable.ritratto_mia_sorella,R.drawable.ritratto_mia_sorella_tr,new int[] {
				Color.rgb(59, 58, 58),
				Color.rgb(247, 226, 226),
				Color.rgb(225, 120, 120),
				Color.rgb(35, 112, 240)},
				21000,false,96));
		sixthSection.add(new PictureBean("ritratto_mio_padre",context.getString(R.string.ritratto_mio_padre),R.drawable.ritratto_mio_padre,R.drawable.ritratto_mio_padre_tr,new int[] {
				Color.rgb(246, 220, 220),
				Color.rgb(216, 216, 216),
				Color.rgb(140, 174, 208)},
				21000,false,96));
		sixthSection.add(new PictureBean("saint_paul",context.getString(R.string.saint_paul),R.drawable.saint_paul,R.drawable.saint_paul_tr,new int[] {
				Color.rgb(176,176,176),
				Color.rgb(251, 233, 209),
				Color.rgb(153, 100, 43),
				Color.rgb(133, 135, 86)},
				21000,false,95));
		sixthSection.add(new PictureBean("saturno",context.getString(R.string.saturno),R.drawable.saturno,R.drawable.saturno_tr,new int[] {
				Color.rgb(148, 148, 148),
				Color.rgb(220, 183, 130),
				Color.rgb(238, 179, 153),
				Color.rgb(165, 100, 15)},
				21000,false,96));
		sixthSection.add(new PictureBean("tandem",context.getString(R.string.tandem),R.drawable.tandem,R.drawable.tandem_tr,new int[] {
				Color.rgb(227, 224, 224),
				Color.rgb(183, 138, 80),
				Color.rgb(55, 55, 55)},
				21000,false,91));
	
		//##########################################################
		//##############  7 SEZIONE BONUS ##########################
		//##########################################################
		bonusSection.setSectionName("Bonus");
		bonusSection.setNumber(6);
		bonusSection.setStoryboardImage(R.drawable.sec1storyboard);
		bonusSection.setBossResourceNormal(R.drawable.jhonnybrushfull);
		bonusSection.setBossResourceSuccess(R.drawable.jhonnybrushfull_8);
		bonusSection.setBossResourceFailure(R.drawable.jhonnybrushfull_9);
		bonusSection.setPresentationImage(R.drawable.bonuspresentation);
		bonusSection.setLockedImage(R.drawable.bonuspresentation);
		bonusSection.setTelaImage(R.drawable.telabonus);
		bonusSection.setCorniceImage(R.drawable.cornici1);
		bonusSection.setSfondoImage(R.drawable.sfondo1);
		bonusSection.clear();
		
		bonusSection.add(new PictureBean("zatteramedusa",context.getString(R.string.zatteramedusa),R.drawable.zatteramedusa,R.drawable.zatteramedusa_tr,new int[] {
				Color.rgb(255, 215, 185),
				Color.rgb(221, 0, 5),
				Color.rgb(191, 108, 27),
				Color.rgb(170, 170, 170),
				Color.rgb(192, 229, 225)},
				61000,true,72));
		bonusSection.add(new PictureBean("libertacheguidapopolo",context.getString(R.string.libertacheguidapopolo),R.drawable.libertapopolo,R.drawable.libertapopolo_tr,new int[] {
				Color.rgb(255, 0, 6),
				Color.rgb(40, 112, 211),
				Color.rgb(231, 204, 123),
				Color.rgb(255, 214, 200),
				Color.rgb(164, 92, 66)},
				61000,false,66));
		bonusSection.add(new PictureBean("curiazi",context.getString(R.string.curiazi),R.drawable.curiazi,R.drawable.curiazi_tr,new int[] {
				Color.rgb(230, 4, 4),
				Color.rgb(234, 234, 234),
				Color.rgb(89, 88, 143),
				Color.rgb(251, 227, 214),
				Color.rgb(187, 187, 193)},
				61000,false,83));
		bonusSection.add(new PictureBean("quartostato",context.getString(R.string.quartostato),R.drawable.quarto_stato,R.drawable.quarto_stato_tr,new int[] {
				Color.rgb(136, 85, 31),
				Color.rgb(207, 155, 100),
				Color.rgb(178, 67, 38),
				Color.rgb(242, 211, 178)},
				61000,false,82));
		bonusSection.add(new PictureBean("persistencememory",context.getString(R.string.persistencememory),R.drawable.persistence_memory,R.drawable.persistence_memory_tr,new int[] {
				Color.rgb(200, 190, 152),
				Color.rgb(239, 210, 19),
				Color.rgb(150, 188, 235)},
				61000,false,85));
		bonusSection.add(new PictureBean("martirio_san_bartolomeo",context.getString(R.string.martirio_san_bartolomeo),R.drawable.martirio_san_bartolomeo,R.drawable.martirio_san_bartolomeo_tr,new int[] {
				Color.rgb(236, 200, 157),
				Color.rgb(220, 203, 137),
				Color.rgb(142, 141, 140)},
				61000,false,86));
		
		//La prima sezione è sbloccata di default
		//Il primo livello della prima sezione è SBLOCCATO di default
		((PictureBean)(sections.get(0).get(0))).unlockLevel(context, "arcade");
		sections.get(0).unlockSection(context, "arcade");
		
		//I quadri trial dell'atelier sono sblocati di default
		for(PictureBean bean: plusAtelierSection) {
			bean.unlockLevel(context, "arcade");
		}
		
		//##########################
		//Precarico tutte le bitmap 
		//con softreference, cosi i 
		//menù risultano più fluidi
		//##########################
		int cont = 0;
		for(SectionArrayList<PictureBean> sec:sections) {
			if(cont >= (sections.size() -1)) break;//la sezione trial atelier non la considero
			sec.getPresentaionImage(context);
			sec.getLockedImage(context);
			//precached all levels colored image
			
			//for(PictureBean pic:sec){
				//pic.getColoredPicture(context);
			//}
			cont++;
		}
		//All'inizio
		currentSection = firstSection;
	}

	public static void clearAllCachedImage() {
		for(SectionArrayList<PictureBean> sec:sections) {
			sec.clearSoftReferences();
			for(PictureBean pic:sec){
				pic.clearSoftReferences();
			}
		}
		for(AmmoBean ammo: AmmoManager.getAllAmmo()) {
			ammo.clearSoftReferences();
		}
	}
	
	public static ArrayList<PictureBean> getAllLevels() {
		return currentSection;
	}
	
	public static int getCurrentLevelIndex() {
		return currentLevel;
	}
	
	public static void setCurrentLevelIndex(int currentLevel) {
		if(currentLevel < currentSection.size() && currentLevel >= 0) {
			LevelManager.currentLevel = currentLevel;
		}
	}
	
	public static PictureBean getCurrentLevel() {
		if(currentLevel != -1 && (currentLevel < currentSection.size())) {
			return currentSection.get(currentLevel);
		}else {
			return null;
		}
	}
	
	public static PictureBean getNextLevel() {
		if(currentLevel < currentSection.size()-1) {
			return currentSection.get(currentLevel+1);
		}else return null;
	}
	
	public static PictureBean getPreviousLevel() {
		if(currentLevel > 0) {
			currentLevel--;
			return currentSection.get(currentLevel);
		}else return null;
	}
	
	public static Integer[] getAllLevelColorResourceId() {
		int count = currentSection.size();
		Integer[] resourcesId = new Integer[count];
		
		for(int i=0; i<count; i++) {
			resourcesId[i] = currentSection.get(i).getColoredPicture();
		}
		return resourcesId;
	}

	public static int getLevelCount() {
		return currentSection.size();
	}
	
	public static ArrayList<SectionArrayList> getAllSections() {
		return sections;
	}

	public static int getCurrentSectionIndex() {
		return currentSection.getNumber();
	}

	public static int getSectionCount() {
		return sections.size();
	}

	public static SectionArrayList<PictureBean> getBonusSection() {
		return bonusSection;
	}
	
	public static SectionArrayList<PictureBean> getAtelierTrialSection() {
		return plusAtelierSection;
	}
	
	public static void setCurrentSection(int position) {
		/*
		if(position == 0) {
			currentSection = firstSection;
		}else if(position == 1){
			currentSection = secondSection;
		}*/
		if(position >= 0 && position < sections.size()) {
			currentSection = sections.get(position);
		}
		currentLevel = -1;
	}
	
	public static SectionArrayList<PictureBean> getCurrentSection() {
		return currentSection;
	}
	
	//Ritorna la prossima sezione se esiste, altrimenti null
	public static SectionArrayList<PictureBean> getNextSection() {
		int sezioneAttuale = getCurrentSectionIndex();
		if(sezioneAttuale < sections.size()-1) {
			return sections.get(sezioneAttuale + 1);
		}else return null;//non ci sono altre sezioni dopo questa
	}

}
