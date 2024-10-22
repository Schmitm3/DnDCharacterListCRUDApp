package com.schmittspecialites.dndgame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class DndgameApplication {

	public static void main(String[] args) {
		SpringApplication.run(DndgameApplication.class, args);
		generateGame();
	}

	public static void generateGame() {
		Scanner scanner = new Scanner(System.in);

		while (true){
			String input = scanner.nextLine();
			System.out.println("Enter the number to choose your class:" + "\n" +
					"1: Ranger" + "\n" +
					"2: Wizard" + "\n" +
					"3: Warrior" + "\n" +
					"4: End game...");
			if(input.equals("4")) {
				break;
			} else if (input.equals("1")) {
				System.out.println("Enter your Ranger's name: ");
				input = scanner.nextLine();
			}
		}
	}

}
