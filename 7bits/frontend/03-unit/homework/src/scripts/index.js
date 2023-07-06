function createAbilityList(pokemonObj) {
  const ul = document.createElement("ul");
  ul.className = "pokemon_abilities_ul";

  pokemonObj.abilities.forEach((item) => {
    const li = document.createElement("li");
    li.className = "pokemon_abilities_li";
    li.innerText = item.ability.name;
    ul.append(li);
  });

  return ul;
}

function createPokemonImage(pokemonObj) {
  const pokemonImage = document.createElement("img");
  pokemonImage.className = "pokemon_image";
  pokemonImage.src = pokemonObj.sprites.front_default;
  return pokemonImage;
}

function renderPokemon(pokemonData) {
  const content = document.getElementById("content");

  const pokemonDivContainer = document.createElement("div");
  pokemonDivContainer.className = "pokemon_div_container";

  const leftDiv = document.createElement("div");
  leftDiv.className = "pokemon_left_div";
  const pokemonName = document.createElement("h3");
  pokemonName.className = "pokemon_name";
  pokemonName.innerText = pokemonData.name;
  leftDiv.append(createPokemonImage(pokemonData), pokemonName);

  const rigthDiv = document.createElement("div");
  rigthDiv.className = "pokemon_rigth_div";

  const abilitiesСaption = document.createElement("p");
  abilitiesСaption.className = "pokemon_abilities_caption";
  abilitiesСaption.innerText = "Abilities";

  rigthDiv.append(abilitiesСaption, createAbilityList(pokemonData));

  pokemonDivContainer.append(leftDiv, rigthDiv);

  content.appendChild(pokemonDivContainer);
}

function fetchPokemon() {
  fetch("https://pokeapi.co/api/v2/pokemon?limit=50")
    .then((response) => response.json())
    .then((allpoke) => allpoke.results.map((pokemon) => fetch(pokemon.url)))
    .then((promises) => Promise.all(promises))
    .then((arrOfResponses) => arrOfResponses.map((response) => response.json()))
    .then((promises) => Promise.all(promises))
    .then((arrPokes) => arrPokes.forEach((pokemon) => renderPokemon(pokemon)))
    .catch((error) => console.error(error))
    .then(() => {
      document.getElementById("preloader").classList.add("preloader--hide");
    });
}

fetchPokemon();
