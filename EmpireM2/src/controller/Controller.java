package controller;

import java.io.IOException;

import buildings.*;
import engine.Game;
import exceptions.NotEnoughGoldException;
import views.Main;

public class Controller {

	private static Game theGame;
	private static Main theView;
	static boolean endturn;
	static boolean winner;
	public Controller (Game theGame, Main theView ) {
		this.theGame=theGame;
		this.theView=theView;

	}
	public Controller() {
		
	}
	public void startGame (String name, String City) throws IOException {
		this.theGame = new Game (name,City);
		
	}
	public static int getTurns() {
		 int x =theGame.getCurrentTurnCount();
		 return x;
	}
	public static String getName() {
		return theGame.getPlayer().getName();
	}
	
	public static double getFood() {
		return theGame.getPlayer().getFood();
	}
	public static double getGold() {
		return theGame.getPlayer().getTreasury();
	}
	public static Boolean onEndTurn() {
			if (theGame.isGameOver()) {
				
				return false;
				}
			theGame.endTurn();
		return true;
	}
	public static Boolean FindWinner() {
		if (theGame.getPlayer().getControlledCities().size()==3) {
			return true;
		}
		return false;
		
	}
	public static Boolean CityOwned(String cityName) {
		for (int i =0; i<theGame.getPlayer().getControlledCities().size();i++) {
		if (theGame.getPlayer().getControlledCities().get(i).getName().equals(cityName)) {
			return true;
			
		}}
		return false;
	}
	public static boolean FarmOwned (String cityName) {
		for (int i =0; i<theGame.getPlayer().getControlledCities().size();i++) {
			if (theGame.getPlayer().getControlledCities().get(i).getName().equals(cityName)) {
				for (int j=0;j<theGame.getPlayer().getControlledCities().get(i).getEconomicalBuildings().size();j++) {
				if (theGame.getPlayer().getControlledCities().get(i).getEconomicalBuildings().get(j) instanceof Farm)
					return true;
				
			}}}
			return false;
		}
	public static boolean MarketOwned (String cityName) {
		for (int i =0; i<theGame.getPlayer().getControlledCities().size();i++) {
			if (theGame.getPlayer().getControlledCities().get(i).getName().equals(cityName)) {
				for (int j=0;j<theGame.getPlayer().getControlledCities().get(i).getEconomicalBuildings().size();j++) {
				if (theGame.getPlayer().getControlledCities().get(i).getEconomicalBuildings().get(j) instanceof Market)
					return true;
				
			}}}
			return false;
		}
	public static boolean ArcheryRangeOwned (String cityName) {
		for (int i =0; i<theGame.getPlayer().getControlledCities().size();i++) {
			if (theGame.getPlayer().getControlledCities().get(i).getName().equals(cityName)) {
				for (int j=0;j<theGame.getPlayer().getControlledCities().get(i).getMilitaryBuildings().size();j++) {
				if (theGame.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j) instanceof ArcheryRange)
					return true;
				
			}}}
			return false;
		}
	public static boolean BarracksOwned (String cityName) {
		for (int i =0; i<theGame.getPlayer().getControlledCities().size();i++) {
			if (theGame.getPlayer().getControlledCities().get(i).getName().equals(cityName)) {
				for (int j=0;j<theGame.getPlayer().getControlledCities().get(i).getMilitaryBuildings().size();j++) {
				if (theGame.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j) instanceof Barracks)
					return true;
				
			}}}
			return false;
		}
	public static boolean StableOwned (String cityName) {
		for (int i =0; i<theGame.getPlayer().getControlledCities().size();i++) {
			if (theGame.getPlayer().getControlledCities().get(i).getName().equals(cityName)) {
				for (int j=0;j<theGame.getPlayer().getControlledCities().get(i).getMilitaryBuildings().size();j++) {
				if (theGame.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j) instanceof Stable)
					return true;
				
			}}}
			return false;
		}
	
	public static void OnBuild (String type,String cityName) throws NotEnoughGoldException {
		theGame.getPlayer().build(type, cityName);
	}
	
	
}
