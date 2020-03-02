package es.salesianos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.salesianos.model.Pokemon;
import es.salesianos.model.PokemonTrainer;

@RestController
@CrossOrigin(origins = "http://localhost:8089")
@RequestMapping(value = "/api/v1/trainer")
public class KeyController {
	
	@Autowired 
	private PokemonTrainer trainer;
	
	
	@RequestMapping(value = "/show")
	public ResponseEntity<PokemonTrainer> show() {
		return new ResponseEntity<PokemonTrainer>(trainer, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/showB", method = RequestMethod.GET)
	public ResponseEntity<PokemonTrainer> showB(@RequestParam Integer id) {
		return new ResponseEntity<PokemonTrainer>(trainer, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/changeName")
	public ResponseEntity<PokemonTrainer> changeName() {
		trainer.setName("Marko");
		return new ResponseEntity<PokemonTrainer>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/insert")
	public ResponseEntity<PokemonTrainer> insert() {
		Pokemon pokemon = new Pokemon();
		pokemon.setName("Venusaur");
		pokemon.setPower(20);
		pokemon.setHealth(120);
		pokemon.setMaxHealth(120);
		trainer.getTeam().addMember(pokemon);
		return new ResponseEntity<PokemonTrainer>(HttpStatus.CREATED);
	}
	
	@PostMapping
	@RequestMapping(value = "/insertTrainer")
	public ResponseEntity<PokemonTrainer> insertTrainer(@RequestBody PokemonTrainer trainer) {
		trainer.setName("Red");
		return new ResponseEntity<PokemonTrainer>(HttpStatus.CREATED);
	}
	
	@PostMapping
	@RequestMapping(value = "/insertPokemon")
	public ResponseEntity<PokemonTrainer> insertPokemon(@RequestBody Pokemon pokemon) {
		pokemon.setName("Venusaur");
		pokemon.setPower(20);
		pokemon.setHealth(120);
		pokemon.setMaxHealth(120);
		trainer.getTeam().addMember(pokemon);
		return new ResponseEntity<PokemonTrainer>(HttpStatus.CREATED);
	}

}
