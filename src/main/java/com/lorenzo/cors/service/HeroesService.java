package com.lorenzo.cors.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
// @Transactional use it with JPA
public class HeroesService {
	
	private List<String> heroes = new ArrayList<String>();
	
	public HeroesService () {
		this.heroes = Arrays.asList("Batman", "Superman", "Hombre Araña");
	}
	
	public List<String> getHeroes () {
		return this.heroes;
	}
}
