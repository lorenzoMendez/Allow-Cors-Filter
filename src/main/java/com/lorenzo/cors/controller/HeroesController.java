package com.lorenzo.cors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lorenzo.cors.service.HeroesService;

@RestController
@RequestMapping("/api/v1")
public class HeroesController {
	
	private static final String RESOURCE_NAME = "heroes";
	
	private final HeroesService heroesService;
	
	@Autowired
	public HeroesController(final HeroesService heroesService) {
		this.heroesService = heroesService;
	}
	
	@GetMapping(RESOURCE_NAME)
	public ResponseEntity getHeroes() {
		return ResponseEntity.ok().body(this.heroesService.getHeroes());
	}
	
}
